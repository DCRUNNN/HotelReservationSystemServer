package uidriver.hotel;

import service.Hotel.AddHotel.AddHotelService;
import service.Hotel.AddHotel.AddHotelServiceImpl;
import vo.HotelVO;
import vo.PersonnelVO;

public class AddHotelDriver {

	public static void main(String args[]){
		
		HotelVO vo1 = new HotelVO("����ʡ", "�Ͼ���", "������Ȧ", "�Ͼ���ѧ����У����", "���پƵ�", 5, "�Ƶ�ܺ�", "��ʩ��ȫ", "���˷�|50/˫�˷�|100");
		HotelVO vo2 = new HotelVO("����ʡ","������","������Ȧ","���ݴ�ѧ��","־��Ƶ�",5,"�Ƶ겻����������",
				"��ʩ����һ�����ȫ","���˷�|20/˫�˷�|50");
		HotelVO vo3 = new HotelVO("����ʡ","������","�ô���Ȧ","���Ŵ�ѧ��","�F�پƵ�",5,"˵�Ƶ겻������ƭ�˵�",
				"��������������","���˷�|5/˫�˷�|20");
		
		AddHotelService service = new AddHotelServiceImpl();
		String hotelid1 = service.addHotel(vo1);
		if("".equals(hotelid1)){
			System.out.println("An error occured!");
		}else{
			String hotelworkerid1 = '1'+hotelid1;
			PersonnelVO vo = new PersonnelVO(null, null, "�˴�", "��", "1314520",hotelid1);
			String pass1 = "123";
			System.out.println(service.addHotelWorker(vo)?"�ɹ���ӾƵ�1�Ĺ�����Ա��":"��ӾƵ�1�Ĺ�����Աʧ�ܣ�");
			System.out.println(service.savePassword(hotelworkerid1, pass1)?"�ɹ�����˻����룡":"����˻�ʧ�ܣ�");
		    System.out.println("-------------");
		}
		
		String hotelid2 = service.addHotel(vo2);
		if("".equals(hotelid2)){
			System.out.println("An error occured!");
		}else{
			PersonnelVO vo = new PersonnelVO(null, null, "��Զ־", "��", "1314520",hotelid2);
			String hotelworkerid2 = '1'+hotelid2;
			String pass2 = "123";
			System.out.println(service.addHotelWorker(vo)?"�ɹ���ӾƵ�2�Ĺ�����Ա��":"��ӾƵ�2�Ĺ�����Աʧ�ܣ�");
			System.out.println(service.savePassword(hotelworkerid2, pass2)?"�ɹ�����˻����룡":"����˻�ʧ�ܣ�");
		    System.out.println("-------------");
		}
		
		String hotelid3 = service.addHotel(vo3);
		if("".equals(hotelid3)){
			System.out.println("An error occured!");
		}else{
			PersonnelVO vo = new PersonnelVO(null, null, "����F", "��", "1314520",hotelid3);
			String hotelworkerid3 = '1'+hotelid3;
			String pass3 = "123";
			System.out.println(service.addHotelWorker(vo)?"�ɹ���ӾƵ�3�Ĺ�����Ա��":"��ӾƵ�3�Ĺ�����Աʧ�ܣ�");
			System.out.println(service.savePassword(hotelworkerid3, pass3)?"�ɹ�����˻����룡":"����˻�ʧ�ܣ�");
		    System.out.println("-------------");
		}
		
	}
}
