package uidriver.hotel;

import service.Hotel.MaintainHotelMessage.MaintainHotelMessageService;
import service.Hotel.MaintainHotelMessage.MaintainHotelMessageServiceImpl;
import vo.HotelVO;

public class ManageHotelMessageDriver {

	//可以了
	public static void main (String args[]){
		
		String hotelID = "00001";
		MaintainHotelMessageService service = new MaintainHotelMessageServiceImpl(hotelID);
		show(service.getHotelVO());//展示一下酒店信息
		
		HotelVO vo = service.getHotelVO();
		service.changeHotelInfo(vo.getHotelProvince(), vo.getHotelCity(), vo.getHotelCBD(), vo.getHotelAddress(), vo.getHotelName(), vo.getIntroduction(), vo.getFacilities(), vo.getHotelStar(), "标准单人间|20/标准双人间|50/豪华单人间|100/豪华双人间|150/标准家庭间|200");
		show(service.getHotelVO());//修改信息之后再显示一下
		
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
		//System.out.println(types.length);
		
		/*System.out.println(types[0]);
		String [] a = types[0].split("[|]");
		for(String str:a){
			System.out.println(str);
		}*/
		/*String roomTypeAndPrice [] = vo.getRoomTypeAndPrice().split("/");
		for(String str:roomTypeAndPrice){
			System.out.println(str.split("|")[0]+": "+str.split("|")[1]);
		}*/
	}
}
