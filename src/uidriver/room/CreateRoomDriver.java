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
	    
	    RoomVO vo1 = new RoomVO(hotelID, typeAndPrice.split("[|]")[0], Double.valueOf(typeAndPrice.split("[|]")[1]), "空闲", null, "106", "房间很不错！");
	    RoomVO vo2 = new RoomVO(hotelID, typeAndPrice2.split("[|]")[0], Double.valueOf(typeAndPrice2.split("[|]")[1]), "空闲", null, "107", "房间很不错！");
	    RoomVO vo3 = new RoomVO(hotelID, typeAndPrice3.split("[|]")[0], Double.valueOf(typeAndPrice3.split("[|]")[1]), "空闲", null, "108", "房间很不错！");
	    RoomVO vo4 = new RoomVO(hotelID, typeAndPrice4.split("[|]")[0], Double.valueOf(typeAndPrice4.split("[|]")[1]), "空闲", null, "109", "房间很不错！");
	    RoomVO vo5 = new RoomVO(hotelID, typeAndPrice5.split("[|]")[0], Double.valueOf(typeAndPrice5.split("[|]")[1]), "空闲", null, "110", "房间很不错！");
	    
	    System.out.println(service.CreateRoom(vo1)?"房间1创建成功！":"房间1创建失败！");
	    System.out.println(service.CreateRoom(vo2)?"房间2创建成功！":"房间2创建失败！");
	    System.out.println(service.CreateRoom(vo3)?"房间3创建成功！":"房间3创建失败！");
	    System.out.println(service.CreateRoom(vo4)?"房间4创建成功！":"房间4创建失败！");
	    System.out.println(service.CreateRoom(vo5)?"房间5创建成功！":"房间5创建失败！");
	    
	}
}
