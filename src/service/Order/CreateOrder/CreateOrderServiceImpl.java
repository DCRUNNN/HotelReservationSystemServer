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
 * CreateOrderService ��ʵ���� ��Ҫʵ�������ɶ�����ְ��, ������ģ��Ľ����󲿷ݷ�ί�и���AllRooms��ȥʵ��
 * ע���ڹ���impl��ʱ�� ����clientId��hotelIDҪȷ������
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
	 * @param clientID �ͻ����
	 * @param hotelID �Ƶ���
	 * @return ����clientID��hotelID��Ϊ���캯���Ĳ���
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
		
		double price = this.getPriceByStrategy(hotelID,clientID,roomNumber);
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
	    	if(!roomservice.changeRoomState(hotelID,numbers[i],"��Ԥ��")){
		    	return false;
		    }
	    	if(!roomservice.setBookDate(hotelID,numbers[i], orderCreatedDate)){
	    		return false;
	    	}
	    }//�ı䷿��״̬,����Ԥ��ʱ��
	    
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
