package uidriver.room;

import java.text.SimpleDateFormat;
import java.util.Date;

import service.Order.InteractWithRoom.RoomProvidedServiceForOrder;
import service.Room.ProvidedService.RoomProvidedServiceForOrderImpl;

public class RoomProvidedServiceForOrderDriver {

	public static void main(String args[]){
		
		RoomProvidedServiceForOrder service = new RoomProvidedServiceForOrderImpl();
	    String hotelID = "00001";
	    String roomNumber = "110";
	    System.out.println(service.changeRoomState(hotelID, roomNumber, "��Ԥ��")?"����Ԥ���ɹ�!":"����Ԥ��ʧ�ܣ�");
		
	    System.out.println(service.setBookDate(hotelID, roomNumber, new SimpleDateFormat("yyyy-MM-dd HH:MM:ss").format(new Date()))?"�ɹ��ı�Ԥ��ʱ�䣡":"�ı�Ԥ��ʱ��ʧ�ܣ�");
	}
}
