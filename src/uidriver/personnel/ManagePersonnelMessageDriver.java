package uidriver.personnel;

import java.rmi.RemoteException;
import java.util.List;

import service.Personnel.ManagePersonnelMessage.ManagePersonnelMessageService;
import service.Personnel.ManagePersonnelMessage.ManagePersonnelMessageServiceImpl;
import vo.PersonnelVO;

public class ManagePersonnelMessageDriver {

	//注意一下返回对象为空，和返回的list长度为0的情况,其他没有什么问题
	public static void main(String args[]) throws RemoteException{
		
		ManagePersonnelMessageService service = new ManagePersonnelMessageServiceImpl();
		PersonnelVO per1 = new PersonnelVO(null, null, "邓聪", "男", "132546879", null);
		PersonnelVO per2 = new PersonnelVO(null, null, "陈远志", "男", "132645", null);
		
		//增加网站营销人员
		String per1Id = service.addNewWebsalers(per1);
		if("".equals(per1Id)||per1Id==null){
			System.out.println("An error occured!");
		}else{
			String password = "123";
			System.out.println(per1Id);
			System.out.println(service.savePassword(per1Id, password));
		}
		
		String per2Id = service.addNewWebsalers(per2);
		if("".equals(per2Id)||per2Id==null){
			System.out.println("An error occured!");
		}else{
			String password = "123";
			System.out.println(per2Id);
			System.out.println(service.savePassword(per2Id, password));
		}
		
	    //显示所有的网站营销人员
		List<PersonnelVO> volist = service.getAllWebSalers();
		System.out.println(volist.size());
		for(PersonnelVO vo:volist){
			show(vo);
		}
		
	    volist = service.getAllHotelWorkers();
		for(PersonnelVO vo:volist){
			show(vo);
		}//显示所有的酒店工作人员
		
		PersonnelVO vobyid = service.getHotelWorkerByHotelID("00002");//按酒店id来搜索酒店工作人员
		if(vobyid==null){
			System.out.println("工作人员不存在！");
		}else{
			show(vobyid);
		}
		
		volist = service.getHotelWorkersByHotelName("星河大酒店");//按酒店名称来搜索酒店工作人员
		for(PersonnelVO vo:volist){
			show(vo);
		}
		
		volist = service.getPersonnelVOByPersonnelName("陈远志");//按工作人员名称进行查找
		for(PersonnelVO vo:volist){
			show(vo);
		}
		
		PersonnelVO vobypid = service.getPersonnelVO("100005");//
		if(vobypid==null){
			System.out.println("工作人员不存在！");
		}else{
			show(vobypid);
		}
		
		vobypid = service.getPersonnelVO("100004");//按照工作人员id进行查找
		show(vobypid);
		vobypid.setPhoneNumber("asdqew");//进行修改
		System.out.println(service.modifyPersonnel(vobypid));
		show(vobypid);
		
	}
	
	public static void show(PersonnelVO vo){
		
		System.out.println(vo.getpersonnelID());
		System.out.println(vo.getname());
		System.out.println(vo.getsex());
		System.out.println(vo.getphoneNumber());
		System.out.println(vo.getType());
		System.out.println(vo.gethotelID());
		System.out.println("-----------------");
	}
}
