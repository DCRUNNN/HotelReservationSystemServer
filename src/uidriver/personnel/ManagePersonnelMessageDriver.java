package uidriver.personnel;

import java.rmi.RemoteException;
import java.util.List;

import service.Personnel.ManagePersonnelMessage.ManagePersonnelMessageService;
import service.Personnel.ManagePersonnelMessage.ManagePersonnelMessageServiceImpl;
import vo.PersonnelVO;

public class ManagePersonnelMessageDriver {

	//ע��һ�·��ض���Ϊ�գ��ͷ��ص�list����Ϊ0�����,����û��ʲô����
	public static void main(String args[]) throws RemoteException{
		
		ManagePersonnelMessageService service = new ManagePersonnelMessageServiceImpl();
		PersonnelVO per1 = new PersonnelVO(null, null, "�˴�", "��", "132546879", null);
		PersonnelVO per2 = new PersonnelVO(null, null, "��Զ־", "��", "132645", null);
		
		//������վӪ����Ա
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
		
	    //��ʾ���е���վӪ����Ա
		List<PersonnelVO> volist = service.getAllWebSalers();
		System.out.println(volist.size());
		for(PersonnelVO vo:volist){
			show(vo);
		}
		
	    volist = service.getAllHotelWorkers();
		for(PersonnelVO vo:volist){
			show(vo);
		}//��ʾ���еľƵ깤����Ա
		
		PersonnelVO vobyid = service.getHotelWorkerByHotelID("00002");//���Ƶ�id�������Ƶ깤����Ա
		if(vobyid==null){
			System.out.println("������Ա�����ڣ�");
		}else{
			show(vobyid);
		}
		
		volist = service.getHotelWorkersByHotelName("�ǺӴ�Ƶ�");//���Ƶ������������Ƶ깤����Ա
		for(PersonnelVO vo:volist){
			show(vo);
		}
		
		volist = service.getPersonnelVOByPersonnelName("��Զ־");//��������Ա���ƽ��в���
		for(PersonnelVO vo:volist){
			show(vo);
		}
		
		PersonnelVO vobypid = service.getPersonnelVO("100005");//
		if(vobypid==null){
			System.out.println("������Ա�����ڣ�");
		}else{
			show(vobypid);
		}
		
		vobypid = service.getPersonnelVO("100004");//���չ�����Աid���в���
		show(vobypid);
		vobypid.setPhoneNumber("asdqew");//�����޸�
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
