package uidriver.room;

import service.Room.CreateRoom.CreateRoomInfoService;
import service.Room.CreateRoom.CreateRoomInfoServiceImpl;
import vo.RoomVO;

public class CreateRoomDriver {

	public static void main(String args[]){
		
		CreateRoomInfoService service = new CreateRoomInfoServiceImpl();
		
		String hotelID = "00001";
	    String []roomTypeAndPrice = service.getAllRoomTypeAndPrice(hotelID).split("/");
	    for(String str:roomTypeAndPrice){
	    	System.out.println(str.split("[|]")[0]+":"+str.split("[|]")[1]);
	    }
	    
	    String typeAndPrice = roomTypeAndPrice[0];
	    String typeAndPrice2 = roomTypeAndPrice[1];
	    String typeAndPrice3 = roomTypeAndPrice[2];
	    String typeAndPrice4 = roomTypeAndPrice[3];
	    String typeAndPrice5 = roomTypeAndPrice[4];
	    
	    RoomVO vo1 = new RoomVO(hotelID, typeAndPrice.split("[|]")[0], Double.valueOf(typeAndPrice.split("[|]")[1]), "����", null, "106", "����ܲ���");
	    RoomVO vo2 = new RoomVO(hotelID, typeAndPrice2.split("[|]")[0], Double.valueOf(typeAndPrice2.split("[|]")[1]), "����", null, "107", "����ܲ���");
	    RoomVO vo3 = new RoomVO(hotelID, typeAndPrice3.split("[|]")[0], Double.valueOf(typeAndPrice3.split("[|]")[1]), "����", null, "108", "����ܲ���");
	    RoomVO vo4 = new RoomVO(hotelID, typeAndPrice4.split("[|]")[0], Double.valueOf(typeAndPrice4.split("[|]")[1]), "����", null, "109", "����ܲ���");
	    RoomVO vo5 = new RoomVO(hotelID, typeAndPrice5.split("[|]")[0], Double.valueOf(typeAndPrice5.split("[|]")[1]), "����", null, "110", "����ܲ���");
	    
	    System.out.println(service.CreateRoom(vo1)?"����1�����ɹ���":"����1����ʧ�ܣ�");
	    System.out.println(service.CreateRoom(vo2)?"����2�����ɹ���":"����2����ʧ�ܣ�");
	    System.out.println(service.CreateRoom(vo3)?"����3�����ɹ���":"����3����ʧ�ܣ�");
	    System.out.println(service.CreateRoom(vo4)?"����4�����ɹ���":"����4����ʧ�ܣ�");
	    System.out.println(service.CreateRoom(vo5)?"����5�����ɹ���":"����5����ʧ�ܣ�");
	    
	}
}
