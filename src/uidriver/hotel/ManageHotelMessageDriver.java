package uidriver.hotel;

import service.Hotel.MaintainHotelMessage.MaintainHotelMessageService;
import service.Hotel.MaintainHotelMessage.MaintainHotelMessageServiceImpl;
import vo.HotelVO;

public class ManageHotelMessageDriver {

	//������
	public static void main (String args[]){
		
		String hotelID = "00001";
		MaintainHotelMessageService service = new MaintainHotelMessageServiceImpl(hotelID);
		show(service.getHotelVO());//չʾһ�¾Ƶ���Ϣ
		
		HotelVO vo = service.getHotelVO();
		service.changeHotelInfo(vo.getHotelProvince(), vo.getHotelCity(), vo.getHotelCBD(), vo.getHotelAddress(), vo.getHotelName(), vo.getIntroduction(), vo.getFacilities(), vo.getHotelStar(), "��׼���˼�|20/��׼˫�˼�|50/�������˼�|100/����˫�˼�|150/��׼��ͥ��|200");
		show(service.getHotelVO());//�޸���Ϣ֮������ʾһ��
		
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
