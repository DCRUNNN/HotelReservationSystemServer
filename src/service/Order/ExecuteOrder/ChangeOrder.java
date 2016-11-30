package service.Order.ExecuteOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.dao.OrderDao;
import data.dao.impl.OrderDaoImpl;
import po.OrderPO;
import service.Hotel.ProvidedService.HotelProvidedServiceForOrderImpl;
import service.Order.CreateOrder.AllRooms;
import service.Order.InteractWithHotel.HotelProvidedServiceForOrder;
import vo.OrderVO;

/**
 * 主要职责是 完成与改变订单相关的操作
 * @see OrderDao
 * @see HelpExecuteOrder
 * @see AllRooms
 * */
public class ChangeOrder {

	private OrderPO po;
	private OrderDao orderDao;
	private HotelProvidedServiceForOrder hotelService;
	private HelpExecuteOrder help;
	private AllRooms allrooms;
	private String hotelID;
	private Map<String,Integer> roomPeople;//每个房间对应的入住人数
	private Map<String,String> roomChild;//每个房间对应的有无儿童
	
	public ChangeOrder(String hotelID){
		
		orderDao = OrderDaoImpl.getInstance();
		hotelService = new HotelProvidedServiceForOrderImpl();
		help = new HelpExecuteOrder();
		allrooms = new AllRooms(hotelID);
		this.hotelID = hotelID;
	}
	
	public List<OrderVO> getUnexecutedOrders(String clientID) {
		
	    List<OrderPO> polist = orderDao.getClientOrdersInaHotel(clientID, hotelID);
	    List<OrderVO> result = new ArrayList<OrderVO>();
	    
	    for(OrderPO po:polist){
			//遍历所有的客户在酒店的订单
			if("未执行".equals(po.getOrderStatus())){
				//把所有的未执行订单加入到result
				String hotelID = po.getHotelID();
				OrderVO vo = new OrderVO(po,hotelService.getHotelInfo(hotelID));//完成了po向vo的转化
				result.add(vo);
			}
		}
	    
	    return result;
	}

	public List<OrderVO> getAbnormalOrders(String clientID) {
		
		List<OrderPO> polist = orderDao.getClientOrdersInaHotel(clientID, hotelID);
		List<OrderVO> result = new ArrayList<OrderVO>();
		
		for(OrderPO po:polist){
			//遍历订单
			if("异常".equals(po.getOrderStatus())){
				//把所有的异常订单加到result
				String hotelID = po.getHotelID();
				OrderVO vo = new OrderVO(po,hotelService.getHotelInfo(hotelID));//完成了po向vo的转化
				result.add(vo);
			}
		}
		return result;
	}

	/**
	 * @param 客户编号
	 * @return 得到客户在酒店预订的所有房间类型
	 * */
	public String getAllRoomType(String orderID) {
	
		initOrderPO(orderID);
		if(po!=null){
			return po.getRoomType();
		}
		return null;
	}

	/**
	 * @param 客户编号
	 * @return 返回客户的订单的所有的房间号码
	 * */
	public String getAllRoomNumber(String orderID){
		
		initOrderPO(orderID);
		
        if(po!=null){
    		String numbers[] = po.getRoomNumber().split("/");
    		roomPeople = new HashMap<String,Integer>();
    		roomChild = new HashMap<String,String>();
    		for(int i=0;i<numbers.length;i++){
    			roomPeople.put(numbers[i], -1);
    			roomChild.put(numbers[i], "");
    		}
    		
    		return po.getRoomNumber();
        }
        return null;
	}

	/**
	 * @param 订单编号
	 * @return 返回客户可用的所有的房间号码
	 * */
	public String getDelayRoomNumber(String orderID){
		
		initOrderPO(orderID);
		
		//完成酒店房间的更改
		String types[] = po.getRoomType().split("/");
		String numbers[] =po.getRoomNumber().split("/");
	    for(int i=0;i<types.length;i++){
	    	boolean isContain = false;
	    	String type=types[i];
	        String roomNumber[] = allrooms.getAllRoomNumber(type).split("/");
	        if(roomNumber.length==0){
	        	numbers[i]="无空闲房间";
	        	continue;
	        }//如果没有房间的话，就是直接设置房间号码为“无空闲房间”
	        
	        for(int j=0;j<roomNumber.length;j++){
	        	//遍历所有的同一类型的房间
	        	if(numbers[i].equals(roomNumber[j])){
	        		isContain = true;
	        		continue;
	        	}
	        }
	        if(!isContain){
	        	//没有包含的话,用第一个房间
	        	numbers[i]=roomNumber[0];
	        }
	    }
	    
	    String result ="";
	    roomPeople = new HashMap<String,Integer>();
	    roomChild = new HashMap<String,String>();
	    for(int i=0;i<numbers.length;i++){
	    	roomPeople.put(numbers[i], -1);
	    	roomChild.put(numbers[i], "");
	    	result=result+numbers[i]+"/";
	    }//初始化 roomPeople,roomChild两个map
	    
	    return result.substring(0,result.length()-1);
	}

	/**
	 * @return 完成了设置房间人数
	 * */
	public void serRoomPeople(String number,int i){
		
		roomPeople.replace(number, i);
	}
	
	/**
	 * @return 完成了设置有无儿童
	 * */
	public void setRoomChild(String number,boolean hasChild){
		
		if(hasChild==true){
			roomChild.replace(number, "true");
		}else{
			roomChild.replace(number, "false");
		}
	}
	
	/**
	 * @return 执行订单
	 * */
	public boolean executeOrder(){
		
		if(!setOrder()){
			return false;
		}//设置订单的相关信息,并且把订单写入到数据库
        
		String clientID = po.getClientID();
		String orderID = po.getOrderID();
		double price = po.getPrice();
		if(!help.addCreditPoint(clientID, price)){
			return false;
		}//增加客户信用点
		
		if(!help.insertCredit(clientID, orderID, price)){
			return false;
		}//生成信用记录
		
		for(String number:roomPeople.keySet()){
			if(!help.changeRoomState(hotelID, number, "已入住")){
				return false;
			}
			if(!help.setBookDate(hotelID, number, "")){
				return false;
			}
		}//改变房间状态,设置预订时间为空
		
		return true;
	}

	private void initOrderPO(String orderID) {
		
		po=orderDao.getOrderPO(orderID);
	}

	private boolean setOrder() {
	
        po.setOrderStatus("已执行");//在客户入住的时候就改变订单状态，如果在退房时才改变的话可能会有被置为异常的可能
		
		StringBuilder roomPeople1 = new StringBuilder();//入住房间的人数
		StringBuilder roomChild1 = new StringBuilder();//入住房间有无儿童
		StringBuilder roomId1 = new StringBuilder();//房间号码
		
		int roomNumber =0;
		
		for(int i:roomPeople.values()){
			if(i!=-1){
				roomNumber++;
				roomPeople1.append(i+"/");
			}
		}
		
		for(String str:roomChild.values()){
			if(!"".equals(str)) roomChild1.append(str+"/");
		}
		
		for(String str:roomPeople.keySet()){
			roomId1.append(str+"/");
		}
		
		String roomPeople2 = roomPeople1.toString().substring(0, roomPeople1.length()-1);
		String roomChild2 = roomChild1.toString().substring(0, roomChild1.length()-1);
		String roomId2 = roomId1.toString().substring(0, roomId1.length()-1);
		
		po.setRoomNumber(roomId2);//改变房间的号码
		po.setPeopleNumber(roomPeople2);//改变订单的入住人数
		po.setHasChild(roomChild2);//改变订单的有无儿童
		po.setRoomTotal(roomNumber);//改变订单的房间人数
		
		if(!orderDao.change(po)){
			return false;
		}
		return true;
	}
}
