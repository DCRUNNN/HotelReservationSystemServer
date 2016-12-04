package uidriver.hotel;

import java.rmi.RemoteException;

import service.Hotel.MaintainHotelMessage.MaintainHotelMessageService;
import service.Hotel.MaintainHotelMessage.MaintainHotelMessageServiceImpl;
import vo.HotelVO;

public class ManageHotelMessageDriver {

	//可以了
	public static void main (String args[]) throws RemoteException{
		
		String hotelID = "00001";
		MaintainHotelMessageService service = new MaintainHotelMessageServiceImpl();
		show(service.getHotelVO(hotelID));//展示一下酒店信息
		
		HotelVO vo = service.getHotelVO(hotelID);
		service.changeHotelInfo(hotelID,vo.getHotelProvince(), vo.getHotelCity(), vo.getHotelCBD(), vo.getHotelAddress(), vo.getHotelName(), vo.getIntroduction(), vo.getFacilities(), vo.getHotelStar(), "标准单人间|20/标准双人间|50/豪华单人间|100/豪华双人间|150/标准家庭间|200");
		show(service.getHotelVO(hotelID));//修改信息之后再显示一下
		
	}
	
	public static void show(HotelVO vo){
		
		System.out.println("HotelProvince:"+vo.getHotelProvince());
		System.out.println("hotelCity:"+vo.getHotelCity());
		System.out.println("HotelCBD:"+vo.getHotelCBD());
		System.out.println("hotelAddress:"+vo.getHotelAddress());
		System.out.println("HotelName:"+vo.getHotelName());
		System.out.println(vo.getRoomTypeAndPrice());
		
		String roomtypeAndPrice = vo.getRoomTypeAndPrice();
		String [] types = roomtypeAndPrice.split("/");
		for(String str:types){
			String [] type = str.split("[|]");
			System.out.println(type[0]+":"+type[1]);
		}
		
	}
}
