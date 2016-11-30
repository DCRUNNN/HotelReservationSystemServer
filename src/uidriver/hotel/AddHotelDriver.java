package uidriver.hotel;

import service.Hotel.AddHotel.AddHotelService;
import service.Hotel.AddHotel.AddHotelServiceImpl;
import vo.HotelVO;
import vo.PersonnelVO;

public class AddHotelDriver {

	public static void main(String args[]){
		
		HotelVO vo1 = new HotelVO("江苏省", "南京市", "仙林商圈", "南京大学仙林校区旁", "聪少酒店", 5, "酒店很好", "设施齐全", "单人房|50/双人房|100");
		HotelVO vo2 = new HotelVO("江苏省","苏州市","北区商圈","苏州大学旁","志哥酒店",5,"酒店不好你来打我",
				"设施不是一般的齐全","单人房|20/双人房|50");
		HotelVO vo3 = new HotelVO("福建省","厦门市","厦大商圈","厦门大学旁","旻少酒店",5,"说酒店不好那是骗人的",
				"神马都可以满足你","单人房|5/双人房|20");
		
		AddHotelService service = new AddHotelServiceImpl();
		String hotelid1 = service.addHotel(vo1);
		if("".equals(hotelid1)){
			System.out.println("An error occured!");
		}else{
			String hotelworkerid1 = '1'+hotelid1;
			PersonnelVO vo = new PersonnelVO(null, null, "邓聪", "男", "1314520",hotelid1);
			String pass1 = "123";
			System.out.println(service.addHotelWorker(vo)?"成功添加酒店1的工作人员！":"添加酒店1的工作人员失败！");
			System.out.println(service.savePassword(hotelworkerid1, pass1)?"成功添加账户密码！":"添加账户失败！");
		    System.out.println("-------------");
		}
		
		String hotelid2 = service.addHotel(vo2);
		if("".equals(hotelid2)){
			System.out.println("An error occured!");
		}else{
			PersonnelVO vo = new PersonnelVO(null, null, "陈远志", "男", "1314520",hotelid2);
			String hotelworkerid2 = '1'+hotelid2;
			String pass2 = "123";
			System.out.println(service.addHotelWorker(vo)?"成功添加酒店2的工作人员！":"添加酒店2的工作人员失败！");
			System.out.println(service.savePassword(hotelworkerid2, pass2)?"成功添加账户密码！":"添加账户失败！");
		    System.out.println("-------------");
		}
		
		String hotelid3 = service.addHotel(vo3);
		if("".equals(hotelid3)){
			System.out.println("An error occured!");
		}else{
			PersonnelVO vo = new PersonnelVO(null, null, "蔡其旻", "男", "1314520",hotelid3);
			String hotelworkerid3 = '1'+hotelid3;
			String pass3 = "123";
			System.out.println(service.addHotelWorker(vo)?"成功添加酒店3的工作人员！":"添加酒店3的工作人员失败！");
			System.out.println(service.savePassword(hotelworkerid3, pass3)?"成功添加账户密码！":"添加账户失败！");
		    System.out.println("-------------");
		}
		
	}
}
