package uidriver.client;

import service.Client.ApplyForVip.ApplyForVipService;
import service.Client.ApplyForVip.ApplyForVipServiceImpl;
import vo.ClientVO;

public class ApplyForVipDriver {

	static ApplyForVipService service = new ApplyForVipServiceImpl();
	
	public static void main(String args[]){
		
		String clientID = "0000001";
		boolean isNormalVip = service.checkNormalVip(clientID);
		boolean isBusinessVip = service.checkBusinessVip(clientID);
		
		if(isNormalVip){
			ClientVO vo = service.getClientVO(clientID);
			System.out.println("����:"+vo.getName());
			System.out.println("���֤�ţ�"+vo.getIdentityID());
			System.out.println("��Ա���"+vo.getClientType());
		}
		
		if(service.applyNormalVip(clientID, "2016-10-20")){
			System.out.println("Apply for normal vip successfully!");
		}
		
		if(service.checkNormalVip(clientID)){
			
			ClientVO vo = service.getClientVO(clientID);
			System.out.println("����:"+vo.getName());
			System.out.println("���֤�ţ�"+vo.getIdentityID());
			System.out.println("��Ա���"+vo.getClientType());
		}//�����������ͨ��Ա
		
		if(isBusinessVip){
			  
		ClientVO vo = service.getClientVO(clientID);
		System.out.println("����:"+vo.getName());
		System.out.println("���֤�ţ�"+vo.getIdentityID());
		System.out.println("��Ա���"+vo.getClientType());
	}
		
		if(service.applyBusinessVip(clientID, "�㶫ʡ/ï����/����������", "�Ǻӹ�˾")){
			System.out.println("Apply for businessvip successfully!");
		}
	
		if(service.checkBusinessVip(clientID)){

			ClientVO vo = service.getClientVO(clientID);
			System.out.println("����:"+vo.getName());
			System.out.println("���֤�ţ�"+vo.getIdentityID());
			System.out.println("��Ա���"+vo.getClientType());
		
		}
	}
}
