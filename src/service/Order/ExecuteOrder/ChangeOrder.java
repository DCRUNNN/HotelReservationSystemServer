package service.Order.ExecuteOrder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.dao.OrderDao;
import data.dao.impl.OrderDaoImpl;
import po.OrderPO;
import service.Order.InteractWithRoom.RoomProvidedServiceForOrder;
import service.Order.help.CreateOrderVO;
import service.Room.ProvidedService.RoomProvidedServiceForOrderImpl;
import vo.OrderVO;

/**
 * ��Ҫְ���� �����ı䶩����صĲ���
 * @see OrderDao
 * @see HelpExecuteOrder
 * @see AllRooms
 * */
public class ChangeOrder {

	private OrderPO po;
	private OrderDao orderDao;
	private HelpExecuteOrder help;
	private RoomProvidedServiceForOrder roomservice;
	private String hotelID;
	private Map<String,Integer> roomPeople;//ÿ�������Ӧ����ס����
	private Map<String,String> roomChild;//ÿ�������Ӧ�����޶�ͯ
	
	public ChangeOrder(String hotelID){
		
		orderDao = OrderDaoImpl.getInstance();
		roomservice = new RoomProvidedServiceForOrderImpl();
		//new HotelProvidedServiceForOrderImpl();
		help = new HelpExecuteOrder();
		this.hotelID = hotelID;
	}
	
	public List<OrderVO> getUnexecutedOrders(String clientID) {
		
	    List<OrderPO> polist = orderDao.getClientOrdersInaHotel(clientID, hotelID);
	    List<OrderVO> result = new ArrayList<OrderVO>();
	    CreateOrderVO help = new CreateOrderVO();
	    
	    for(OrderPO po:polist){
			//�������еĿͻ��ھƵ�Ķ���
			if("δִ��".equals(po.getOrderStatus())){
				//�����е�δִ�ж������뵽result
				result.add(help.createOrderVO(po));
			}
		}
	    
	    return result;
	}

	public List<OrderVO> getAbnormalOrders(String clientID) {
		
	    List<OrderPO> polist = orderDao.getClientOrdersInaHotel(clientID, hotelID);
	    List<OrderVO> result = new ArrayList<OrderVO>();
	    CreateOrderVO help = new CreateOrderVO();
	    
	    for(OrderPO po:polist){
			//�������еĿͻ��ھƵ�Ķ���
			if("�쳣".equals(po.getOrderStatus())){
				//�����е��쳣�������뵽result
				result.add(help.createOrderVO(po));
			}
		}
	    
	    return result;
	}

	/**
	 * @param �������
	 * @return �õ��ͻ��ھƵ�Ԥ�������з�������
	 * */
	public String getAllRoomType(String orderID) {
	
		initOrderPO(orderID);
		if(po!=null){
			return po.getRoomType();
		}
		return null;
	}

	/**
	 * @param �������
	 * @return ���ؿͻ��Ķ��������еķ������
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
	 * @param �������
	 * @return ���ؿͻ����õ����еķ������
	 * */
	public String getDelayRoomNumber(String orderID){
		
		initOrderPO(orderID);
		
		//��ɾƵ귿��ĸ���
		String types[] = po.getRoomType().split("/");
		String numbers[] =po.getRoomNumber().split("/");
	    for(int i=0;i<types.length;i++){
	    	boolean isContain = false;
	    	String type=types[i];
	        String roomNumber[] = roomservice.getAvailableRoomNumbers(hotelID, type).split("/");
	        if(roomNumber.length==0){
	        	numbers[i]="�޿��з���";
	        	continue;
	        }//���û�з���Ļ�������ֱ�����÷������Ϊ���޿��з��䡱
	        
	        for(int j=0;j<roomNumber.length;j++){
	        	//�������е�ͬһ���͵ķ���
	        	if(numbers[i].equals(roomNumber[j])){
	        		isContain = true;
	        		continue;
	        	}
	        }
	        if(!isContain){
	        	//û�а����Ļ�,�õ�һ������
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
	    }//��ʼ�� roomPeople,roomChild����map
	    
	    return result.substring(0,result.length()-1);
	}

	/**
	 * @return ��������÷�������
	 * */
	public void serRoomPeople(String number,int i){
		
		roomPeople.replace(number, i);
	}
	
	/**
	 * @return ������������޶�ͯ
	 * */
	public void setRoomChild(String number,boolean hasChild){
		
		if(hasChild==true){
			roomChild.replace(number, "true");
		}else{
			roomChild.replace(number, "false");
		}
	}
	
	/**
	 * @return ִ�ж���
	 * */
	public boolean executeOrder(){
		
		if(!setOrder()){
			return false;
		}//���ö����������Ϣ,���ҰѶ���д�뵽���ݿ�
        
		String clientID = po.getClientID();
		String orderID = po.getOrderID();
		double price = po.getPrice();
		if(!help.addCreditPoint(clientID, price)){
			return false;
		}//���ӿͻ����õ�
		
		if(!help.insertCredit(clientID, orderID, price)){
			return false;
		}//�������ü�¼
		
		for(String number:roomPeople.keySet()){
			if(!help.changeRoomState(hotelID, number, "����ס")){
				return false;
			}
			if(!help.setBookDate(hotelID, number, "")){
				return false;
			}
		}//�ı䷿��״̬,����Ԥ��ʱ��Ϊ��
		
		return true;
	}

	private void initOrderPO(String orderID) {
		
		po=orderDao.getOrderPO(orderID);
	}

	private boolean setOrder() {
	
        po.setOrderStatus("��ִ��");//�ڿͻ���ס��ʱ��͸ı䶩��״̬��������˷�ʱ�Ÿı�Ļ����ܻ��б���Ϊ�쳣�Ŀ���
		
		StringBuilder roomPeople1 = new StringBuilder();//��ס���������
		StringBuilder roomChild1 = new StringBuilder();//��ס�������޶�ͯ
		StringBuilder roomId1 = new StringBuilder();//�������
		
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
		
		po.setRoomNumber(roomId2);//�ı䷿��ĺ���
		po.setPeopleNumber(roomPeople2);//�ı䶩������ס����
		po.setHasChild(roomChild2);//�ı䶩�������޶�ͯ
		po.setRoomTotal(roomNumber);//�ı䶩���ķ�������
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		po.setOrderBeginDate(sdf.format(new Date()));//���ÿͻ���סʱ��
		
		if(!orderDao.change(po)){
			return false;
		}
		return true;
	}
}
