package uidriver.hotel;

import java.util.List;

import service.Hotel.MyHotel.MyHotelService;
import service.Hotel.MyHotel.MyHotelServiceImpl;
import vo.HotelVO;

public class MyHotelDriver {

	public static void main(String args[]){
		
		demo1();
		demo2();
	}

	private static void demo2() {
		
		String clientID = "0000002";
	}

	private static void demo1() {
		
		String clientID = "0000001";
		MyHotelService service = new MyHotelServiceImpl(clientID);
		List<HotelVO> volist = service.getAbnormalHotels();
		System.out.println(volist.size()==0?"暂时没有异常酒店！":"存在异常订单的酒店");
		volist = service.getUnexecutedHotels();
		System.out.println(volist.size()==0?"暂时没有未执行酒店！":"存在未执行的酒店！");
		volist = service.getWithdrawnHotels();
		for(HotelVO vo:volist){
			show(vo);
		}
		
		volist = service.getExecutedHotels();
		System.out.println(volist.size()==0?"暂时没有已执行酒店！":"存在已执行订单的酒店");
		for(HotelVO vo:volist){
			show(vo);
		}
	}
	

	public static void show(HotelVO vo){
		
		System.out.println(vo.getOrderID());
		System.out.println(vo.getOrderCreateDate());
		System.out.println(vo.getOrderStatus());
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
		
		System.out.println("----------------------");
	}
}
