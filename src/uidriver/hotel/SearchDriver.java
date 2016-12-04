package uidriver.hotel;

import java.rmi.RemoteException;

import service.Hotel.SearchHotel.SearchHotelService;
import service.Hotel.SearchHotel.SearchHotelServiceImpl;
import vo.SearchVO;

public class SearchDriver {

	public static void main(String args[]) throws RemoteException{
		
		demo1();
	}

	private static void demo1() throws RemoteException {
		
		String clientID = "0000001";
		SearchHotelService service = new SearchHotelServiceImpl();
		String hotelProvince = "�㶫ʡ";
		String hotelCity = "ï����";
		String hotelCBD = "������Ȧ";
		
		System.out.println(service.getAllProvinces());//������е�ʡ��
		System.out.println(service.getCities(hotelProvince));//������еĳ���
		System.out.println(service.getCBDS(hotelProvince, hotelCity));//������е���Ȧ
		
		service.initAllHotel(clientID,hotelProvince, hotelCity, hotelCBD);//��list���г�ʼ����
		SearchVO search = new SearchVO(hotelCBD, hotelCBD, 0, 0, 0, hotelCBD, 0, 0, 0, 0, false);
	}
}
