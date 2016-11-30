package service.Order.ExecuteOrder;

import java.text.SimpleDateFormat;

import po.CreditPO;
import service.Client.ProvidedService.ClientProvidedService;
import service.Client.ProvidedService.ClientProvidedServiceImpl;
import service.Credit.ProvidedService.CreditProvidedService;
import service.Credit.ProvidedService.CreditProvidedServiceImpl;
import service.Order.InteractWithRoom.RoomProvidedServiceForOrder;
import service.Room.ProvidedService.RoomProvidedServiceForOrderImpl;

/**
 * �������ִ�ж���ʱ�� ������ģ��Ľ����������ͻ�ģ�飬����ģ�飬����ģ�飩
 * @see ClientProvidedService
 * @see CreditProvidedService
 * @see RoomProvidedServiceForOrder
 * */
public class HelpExecuteOrder {

	private ClientProvidedService clientservice;
	private CreditProvidedService creditservice;
	private RoomProvidedServiceForOrder roomservice;
	
	public HelpExecuteOrder(){
		
		clientservice = new ClientProvidedServiceImpl();
		creditservice = new CreditProvidedServiceImpl();
		roomservice = new RoomProvidedServiceForOrderImpl();
		
	}
	
	public boolean addCreditPoint(String clientID,double price){
		
		double point = price/2;
		if(!clientservice.addClientCreditPoint(clientID, point)){
			return false;
		}
		return true;
	}
	
	public boolean insertCredit(String clientID,String orderID,double price){
		
		CreditPO po = new CreditPO();
		double point = price/2;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		String currentTime = sdf.format(new java.util.Date());
		po.setCause("����ִ��");
		po.setChange("+"+point);
		po.setClientID(clientID);
		po.setOrderID(orderID);
		po.setTime(currentTime);
		
		if(!creditservice.insertCredit(po)){
			return false;
		}
		return true;
	}
	
	public boolean changeRoomState(String hotelID,String roomNumber,String state){
		return roomservice.changeRoomState(hotelID, roomNumber, state);
	}
	
	public boolean setBookDate(String hotelID,String roomNumber,String bookDate){
		return roomservice.setBookDate(hotelID, roomNumber, bookDate);
	}
}
