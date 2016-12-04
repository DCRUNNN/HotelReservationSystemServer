package service.Order.CreateOrder;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import data.dao.OrderDao;
import data.dao.impl.OrderDaoImpl;
import po.OrderPO;
import service.Hotel.ProvidedService.HotelProvidedServiceForOrderImpl;
import service.Order.InteractWithHotel.HotelProvidedServiceForOrder;
import service.Order.InteractWithRoom.RoomProvidedServiceForOrder;
import service.Order.help.CreateOrderID;
import service.Room.ProvidedService.RoomProvidedServiceForOrderImpl;

/**
 * CreateOrderService 的实现类 主要实现了生成订单的职责, 与其他模块的交互大部份分委托给了AllRooms类去实现
 * 注意在构造impl的时候 传递clientId，hotelID要确保存在
 * @see HotelProvidedServiceForOrder
 * @see OrderDao
 * @see AllRooms
 * @see AboutStrategy
 * @see CreateOrderID
 * */
public class CreateOrderServiceImpl implements CreateOrderService{

	private HotelProvidedServiceForOrder hotelservice;
    private RoomProvidedServiceForOrder roomservice;
	private OrderDao orderDao;
	
	/**
	 * @param clientID 客户编号
	 * @param hotelID 酒店编号
	 * @return 传递clientID，hotelID作为构造函数的参数
	 * */
	public CreateOrderServiceImpl(){
		
		hotelservice = new HotelProvidedServiceForOrderImpl();
		roomservice = new RoomProvidedServiceForOrderImpl();
		orderDao = OrderDaoImpl.getInstance();
	}
	@Override
	public String getRoomTypeAndPrice(String hotelID) throws RemoteException{
		return hotelservice.getRoomTypeAndPrice(hotelID);
	}

	@Override
	public String getAllRoomNumber(String hotelID,String roomType) throws RemoteException{
		
		return roomservice.getAvailableRoomNumbers(hotelID,roomType);
	}

	@Override
	public boolean createOrder(String hotelID,String clientID, String roomType, String roomNumber) throws RemoteException{
		
		OrderPO po = new OrderPO();
		
		//获得订单生成时间
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date current = new Date();
		String orderCreatedDate = formatter.format(current);
		
		//使用calendar类来 实现获得当前日期七天后的日期 就是订单最晚执行时间
		Calendar c = Calendar.getInstance();
		c.setTime(current);
		c.add(Calendar.DAY_OF_YEAR, 7);
		String orderLastDate = formatter.format(c.getTime());
		
		//暂时缺少了编号的规则 订单编号
		String orderID =new CreateOrderID().nextId();
		if("".equals(orderID)){
			//订单号达到上限
			return false;
		}
		
		String orderBeginDate = "";//订单入住时间为空
		String orderEndDate = "";//订单退房时间为空
		
		double price = this.getPriceByStrategy(hotelID,clientID,roomNumber);
		String peopleNumber = "";//入住人数为空
	    String hasChild ="";//有无儿童为空
	    String orderStatus = "未执行";
	    
	    String withdrawTime = "";//撤销时间为空
	    String comment = "";//评论为空
	    
	    po.setOrderID(orderID);
	    po.setClientID(clientID);
	    po.setHotelID(hotelID);
	    po.setOrderCreatedDate(orderCreatedDate);
	    po.setOrderBeginDate(orderBeginDate);
	    po.setOrderEndDate(orderEndDate);
	    po.setOrderLastDate(orderLastDate);
	    po.setPrice(price);
	    po.setRoomTotal(roomNumber.split("/").length);
	    po.setRoomType(roomType);
	    po.setRoomNumber(roomNumber);
	    po.setPeopleNumber(peopleNumber);
	    po.setHasChild(hasChild);
	    po.setOrderStatus(orderStatus);
	    po.setWithdrawTime(withdrawTime);
	    po.setComment(comment);
	    
	    String numbers[] = roomNumber.split("/");
	    for(int i=0;i<numbers.length;i++){
	    	if(!roomservice.changeRoomState(hotelID,numbers[i],"已预订")){
		    	return false;
		    }
	    	if(!roomservice.setBookDate(hotelID,numbers[i], orderCreatedDate)){
	    		return false;
	    	}
	    }//改变房间状态,设置预订时间
	    
		return orderDao.change(po);
	}

	@Override
	public double getPriceByStrategy(String hotelID,String clientID,String roomNumber)throws RemoteException {
	
    	double total1 = 0;
        String numbers[] = roomNumber.split("/");
        for(String number:numbers){
        	total1+=roomservice.getRoomPrice(hotelID,number);
        }
        
        String hotelProvince = hotelservice.getHotelProvince(hotelID);
		String hotelCity = hotelservice.getHotelCity(hotelID);
		String hotelCBD = hotelservice.getHotelCBD(hotelID);
		
        double discount = new AboutStrategy().getPriceByStrategy(clientID, hotelID,numbers.length,hotelProvince,hotelCity,hotelCBD);
        return total1*discount/10;
    
		
	}
	@Override
	public boolean checkCreditPoint(String clientID) throws RemoteException{
		return new AboutStrategy().checkCreditPoint(clientID);
	}

}
