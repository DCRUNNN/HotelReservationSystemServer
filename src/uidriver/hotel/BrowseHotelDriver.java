package uidriver.hotel;

import java.rmi.RemoteException;
import java.util.List;

import service.Hotel.BrowseHotel.BrowseHotelService;
import service.Hotel.BrowseHotel.BrowseHotelServiceImpl;
import vo.HotelVO;
import vo.OrderVO;

public class BrowseHotelDriver {

	public static void main(String args[])  throws RemoteException{
		
		demo1();
	}

	private static void demo1() throws RemoteException {
	
		String hotelProvince = "广东省";
		String hotelCity = "茂名市";
		String hotelCBD = "化州商圈";
		String clientID = "0000001";
		String hotelID = "00001";
		BrowseHotelService service = new BrowseHotelServiceImpl();
		
		System.out.println(service.getProvinces());//输出所有的省份
		System.out.println(service.getCities(hotelProvince));//输出所有的城市
		System.out.println(service.getCBDS(hotelProvince, hotelCity));//输出所有的商圈
		
		List<HotelVO> volist = service.getAllHotels(clientID,hotelProvince, hotelCity, hotelCBD);//展示某个商圈内的酒店
		for(HotelVO vo:volist){
			show(vo);
		}
		
		List<OrderVO> ordervo = service.getAllOrders(clientID,hotelID);
		for(OrderVO vo:ordervo){
			show(vo);
		}
	}
	

	private static void show(OrderVO vo){
		
		System.out.println("订单编号："+vo.getOrderID()+"\n"+"客户姓名:"+vo.getClientName()+"\n"+"酒店地址:"+vo.getHotelAddress()+"\n"+
		"订单生成时间:"+vo.getOrderCreatedDate()+"\n"+"预订房间:"+vo.getRoomNumber()+"\n"+"订单状态:"+vo.getOrderStatus()
		+"\n"+"入住日期:"+vo.getOrderBeginDate()+";退房时间："+vo.getOrderEndDate());
		
		System.out.println("客户评论："+vo.getComment());
		System.out.println("------------------------");
		
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
