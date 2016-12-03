package uidriver.hotel;

import service.Hotel.SearchHotel.SearchHotelService;
import service.Hotel.SearchHotel.SearchHotelServiceImpl;
import vo.SearchVO;

public class SearchDriver {

	public static void main(String args[]){
		
		demo1();
	}

	private static void demo1() {
		
		String clientID = "0000001";
		SearchHotelService service = new SearchHotelServiceImpl(clientID);
		String hotelProvince = "广东省";
		String hotelCity = "茂名市";
		String hotelCBD = "化州商圈";
		
		System.out.println(service.getAllProvinces());//输出所有的省份
		System.out.println(service.getCities(hotelProvince));//输出所有的城市
		System.out.println(service.getCBDS(hotelProvince, hotelCity));//输出所有的商圈
		
		service.getAllHotels(hotelProvince, hotelCity, hotelCBD);//对list进行初始化了
		SearchVO search = new SearchVO(hotelCBD, hotelCBD, 0, 0, 0, hotelCBD, 0, 0, 0, 0, false);
	}
}
