package uidriver.room;

import java.rmi.RemoteException;
import java.util.List;

import service.Room.ChangeRoomInfo.ChangeRoomInfoService;
import service.Room.ChangeRoomInfo.ChangeRoomInfoServiceImpl;
import service.Room.CreateRoom.CreateRoomInfoServiceImpl;
import vo.RoomVO;

public class ChangeRoomInfoDriver {

	public static void main(String args[]) throws RemoteException{
		
		String hotelID = "00001";
		ChangeRoomInfoService service = new ChangeRoomInfoServiceImpl();
		
		//改变某一类型的房间的价格
		String roomTypeAndPrice = new CreateRoomInfoServiceImpl().getAllRoomTypeAndPrice(hotelID);
		String types[] = roomTypeAndPrice.split("/");//改变房间价格的同时还需要更新酒店对应的信息
		String type = types[0].split("[|]")[0];//得到的就是第一个房间类型
		System.out.println(type);//输出房间类型
		
		System.out.println(service.changeRoomPrice(type, 100, hotelID)?"成功改变房间价格！":"改变房间价格失败！");
	    
		List<RoomVO> volist = service.getAllRoomList(hotelID);
		for(RoomVO vo:volist){
			show(vo);
		}//展示所有的房间信息
		
	    List<RoomVO> temp = service.getRoomByState(hotelID,"空闲");
	    for(RoomVO vo:temp){
	    	show(vo);
	    }//展示所有的空闲房间信息
	    
	    List<RoomVO> typeRoom = service.getRoomByType(hotelID,"豪华单人间");
	    for(RoomVO vo:typeRoom){
	    	show(vo);
	    }//展示所有的豪华单人间信息
	    
	    RoomVO vo1 = volist.get(2);
	    String roomID = vo1.getRoomNumber();
	    System.out.println(service.changeRoomState(hotelID, roomID, "已入住")?"成功改变状态！":"改变状态失败！");
		show(service.getRoomByNum(hotelID,roomID));//展示修改后的房间信息
		
		System.out.println(service.deleteRoom(hotelID, roomID)?"成功删除房间！":"删除房间失败！");//删除房间
		volist = service.getAllRoomList(hotelID);
		for(RoomVO vo:volist){
			show(vo);
		}
		
	}
	
	public static void show(RoomVO vo){
		
		System.out.println("酒店编号:"+vo.getHotelID());
		System.out.println("房间号码:"+vo.getRoomNumber());
		System.out.println("房间类型:"+vo.getRoomType());
		System.out.println("房间状态:"+vo.getRoomState());
		System.out.println("房间被预订时间:"+vo.getBookDate());
		System.out.println("房间简介:"+vo.getRoomIntroduction());
		System.out.println("-----------------");
	}
}
