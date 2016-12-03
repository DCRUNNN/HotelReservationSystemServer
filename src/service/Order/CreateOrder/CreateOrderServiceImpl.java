package service.Order.CreateOrder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import data.dao.OrderDao;
import data.dao.impl.OrderDaoImpl;
import po.OrderPO;
import service.Hotel.ProvidedService.HotelProvidedServiceForOrderImpl;
import service.Order.CreateOrderID.CreateOrderID;
import service.Order.InteractWithHotel.HotelProvidedServiceForOrder;

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

	private String clientID;
	private String hotelID;
	private HotelProvidedServiceForOrder hotelservice;
	private OrderDao orderDao;
	private AllRooms allrooms;
	
	/**
	 * @param clientID 客户编号
	 * @param hotelID 酒店编号
	 * @return 传递clientID，hotelID作为构造函数的参数
	 * */
	public CreateOrderServiceImpl(String clientID,String hotelID){
		
		this.clientID = clientID;
		this.hotelID = hotelID;
		hotelservice = new HotelProvidedServiceForOrderImpl();
		orderDao = OrderDaoImpl.getInstance();
		allrooms = new AllRooms(hotelID);
	}
	@Override
	public String getRoomTypeAndPrice() {
		return hotelservice.getRoomTypeAndPrice(hotelID);
	}

	@Override
	public String getAllRoomNumber(String roomType) {
		return allrooms.getAllRoomNumber(roomType);
	}

	@Override
	public boolean createOrder( String roomType, String roomNumber) {
		
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
		
		String hotelProvince = hotelservice.getHotelProvince(hotelID);
		String hotelCity = hotelservice.getHotelCity(hotelID);
		String hotelCBD = hotelservice.getHotelCBD(hotelID);
		double price = allrooms.getPriceByStrategy(clientID,hotelID,roomNumber,hotelProvince,hotelCity,hotelCBD);
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
	    	if(!allrooms.changeRoomState(numbers[i],"已预订")){
		    	return false;
		    }
	    	if(!allrooms.setBookDate(numbers[i], orderCreatedDate)){
	    		return false;
	    	}
	    }//改变房间状态,设置预订时间
	    
		return orderDao.change(po);
	}

	@Override
	public double getPriceByStrategy(String roomNumber) {
		
		String hotelProvince = hotelservice.getHotelProvince(hotelID);
		String hotelCity = hotelservice.getHotelCity(hotelID);
		String hotelCBD = hotelservice.getHotelCBD(hotelID);
		return allrooms.getPriceByStrategy(clientID,hotelID,roomNumber,hotelProvince,hotelCity,hotelCBD);
	}
	@Override
	public boolean checkCreditPoint() {
		return new AboutStrategy().checkCreditPoint(clientID);
	}

}
