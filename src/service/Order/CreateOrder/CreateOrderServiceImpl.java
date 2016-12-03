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
 * CreateOrderService ��ʵ���� ��Ҫʵ�������ɶ�����ְ��, ������ģ��Ľ����󲿷ݷ�ί�и���AllRooms��ȥʵ��
 * ע���ڹ���impl��ʱ�� ����clientId��hotelIDҪȷ������
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
	 * @param clientID �ͻ����
	 * @param hotelID �Ƶ���
	 * @return ����clientID��hotelID��Ϊ���캯���Ĳ���
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
		
		//��ö�������ʱ��
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date current = new Date();
		String orderCreatedDate = formatter.format(current);
		
		//ʹ��calendar���� ʵ�ֻ�õ�ǰ�������������� ���Ƕ�������ִ��ʱ��
		Calendar c = Calendar.getInstance();
		c.setTime(current);
		c.add(Calendar.DAY_OF_YEAR, 7);
		String orderLastDate = formatter.format(c.getTime());
		
		//��ʱȱ���˱�ŵĹ��� �������
		String orderID =new CreateOrderID().nextId();
		if("".equals(orderID)){
			//�����Ŵﵽ����
			return false;
		}
		
		String orderBeginDate = "";//������סʱ��Ϊ��
		String orderEndDate = "";//�����˷�ʱ��Ϊ��
		
		String hotelProvince = hotelservice.getHotelProvince(hotelID);
		String hotelCity = hotelservice.getHotelCity(hotelID);
		String hotelCBD = hotelservice.getHotelCBD(hotelID);
		double price = allrooms.getPriceByStrategy(clientID,hotelID,roomNumber,hotelProvince,hotelCity,hotelCBD);
		String peopleNumber = "";//��ס����Ϊ��
	    String hasChild ="";//���޶�ͯΪ��
	    String orderStatus = "δִ��";
	    
	    String withdrawTime = "";//����ʱ��Ϊ��
	    String comment = "";//����Ϊ��
	    
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
	    	if(!allrooms.changeRoomState(numbers[i],"��Ԥ��")){
		    	return false;
		    }
	    	if(!allrooms.setBookDate(numbers[i], orderCreatedDate)){
	    		return false;
	    	}
	    }//�ı䷿��״̬,����Ԥ��ʱ��
	    
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
