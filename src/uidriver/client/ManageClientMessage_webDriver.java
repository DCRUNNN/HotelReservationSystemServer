package uidriver.client;

import java.rmi.RemoteException;
import java.util.List;

import service.Client.ManageClientMessage_webManager.ClientMessage_webManagerService;
import service.Client.ManageClientMessage_webManager.ClientMessage_webManagerServiceImpl;
import vo.ClientVO;

public class ManageClientMessage_webDriver {

	public static void main(String args[]) throws RemoteException{
		
		ClientMessage_webManagerService service = new ClientMessage_webManagerServiceImpl();
		
		List<ClientVO> volist = service.getAllClients();//�õ����еĿͻ���Ϣ
		for(ClientVO vo:volist){
			show(vo);
		}//��ʾ���еĿͻ���Ϣ
		
		volist = service.getClientByPhoneNumber("123");
		if(volist.size()==0){
			System.out.println("Can not Find!");
		}
		
		volist = service.getClientByPhoneNumber("13927501605");//���绰��������
		for(ClientVO vo:volist){
			show(vo);
		}
		
		volist = service.getClientsByName("��");//����������
		for(ClientVO vo:volist){
			show(vo);
		}
		
		show(service.getClientMessage("0000001"));//��id����
		
		ClientVO vo = service.getClientMessage("0000001");
		vo.setIdentityID("440982199610202336");
		service.modifyClientMessage(vo);//�޸Ŀͻ���Ϣ
		show(service.getClientMessage("0000001"));
		
	}
	
	public static void show(ClientVO vo){
		

		System.out.println("id:"+vo.getId());
		System.out.println("name:"+vo.getName());
		System.out.println("sex:"+vo.getSex());
		System.out.println("identityID:"+vo.getIdentityID());
		System.out.println("phoneNumber:"+vo.getPhoneNumber());
		System.out.println("credit_point:"+vo.getCredit_point());
		System.out.println("clientType:"+vo.getClientType());
		System.out.println("birthday:"+vo.getBirthday());
		System.out.println("vipGrade:"+vo.getVipGrade());
		//System.out.println("companyName:"+vo.getCompanyName());
		System.out.println("companyAddress:"+vo.getCompanyAddress());
		System.out.println("-----------------------");
	}
}
