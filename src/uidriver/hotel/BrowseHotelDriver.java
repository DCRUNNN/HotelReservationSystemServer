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
	
		String hotelProvince = "�㶫ʡ";
		String hotelCity = "ï����";
		String hotelCBD = "������Ȧ";
		String clientID = "0000001";
		String hotelID = "00001";
		BrowseHotelService service = new BrowseHotelServiceImpl();
		
		System.out.println(service.getProvinces());//������е�ʡ��
		System.out.println(service.getCities(hotelProvince));//������еĳ���
		System.out.println(service.getCBDS(hotelProvince, hotelCity));//������е���Ȧ
		
		List<HotelVO> volist = service.getAllHotels(clientID,hotelProvince, hotelCity, hotelCBD);//չʾĳ����Ȧ�ڵľƵ�
		for(HotelVO vo:volist){
			show(vo);
		}
		
		List<OrderVO> ordervo = service.getAllOrders(clientID,hotelID);
		for(OrderVO vo:ordervo){
			show(vo);
		}
	}
	

	private static void show(OrderVO vo){
		
		System.out.println("������ţ�"+vo.getOrderID()+"\n"+"�ͻ�����:"+vo.getClientName()+"\n"+"�Ƶ��ַ:"+vo.getHotelAddress()+"\n"+
		"��������ʱ��:"+vo.getOrderCreatedDate()+"\n"+"Ԥ������:"+vo.getRoomNumber()+"\n"+"����״̬:"+vo.getOrderStatus()
		+"\n"+"��ס����:"+vo.getOrderBeginDate()+";�˷�ʱ�䣺"+vo.getOrderEndDate());
		
		System.out.println("�ͻ����ۣ�"+vo.getComment());
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
