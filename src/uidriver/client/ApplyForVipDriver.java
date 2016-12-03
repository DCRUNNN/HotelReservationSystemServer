package uidriver.client;

import service.Client.ApplyForVip.ApplyForVipService;
import service.Client.ApplyForVip.ApplyForVipServiceImpl;
import vo.ClientVO;

public class ApplyForVipDriver {
	
	//ok
	
	public static void main(String args[]){
		
		ApplyForVipService service = new ApplyForVipServiceImpl();
		String clientID = "0000001";
		String hotelID = "00001";
		boolean isNormalVip = service.checkNormalVip(clientID);
		boolean isBusinessVip = service.checkBusinessVip(clientID);
		
		if(isNormalVip){
			ClientVO vo = service.getClientVO(clientID);
			System.out.println("����:"+vo.getName());
			System.out.println("���֤�ţ�"+vo.getIdentityID());
			System.out.println("��Ա���"+vo.getClientType());
		}
		
		if(service.applyNormalVip(clientID, "10-20")){
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
		
		if(service.applyBusinessVip(clientID,"�㶫ʡï���л�����Ȧ����һ�����Ǻӹ�˾",hotelID)){
			System.out.println("Apply for businessvip successfully!");
		}//������ҵ��Ա
	
		if(service.checkBusinessVip(clientID)){

			ClientVO vo = service.getClientVO(clientID);
			System.out.println("����:"+vo.getName());
			System.out.println("���֤�ţ�"+vo.getIdentityID());
			System.out.println("��Ա���"+vo.getClientType());
			System.out.println("��ҵ��ַ:"+vo.getCompanyAddress());
			System.out.println("��ҵ�����ľƵ�id��"+vo.getHotelIDS());
			System.out.println("��ҵ�����ľƵ���Ϣ:"+vo.getHotelInfos());
		
		}
		
		if(service.applyBusinessVip(clientID, "�㶫ʡï���л�����Ȧ����һ�����Ǻӹ�˾", "00002")){
			
			System.out.println("�ٴ�����Ƶ���ҵ��Ա�ɹ���");
			ClientVO vo = service.getClientVO(clientID);
			System.out.println("����:"+vo.getName());
			System.out.println("���֤�ţ�"+vo.getIdentityID());
			System.out.println("��Ա���"+vo.getClientType());
			System.out.println("��ҵ��ַ:"+vo.getCompanyAddress());
			System.out.println("��ҵ�����ľƵ�id��"+vo.getHotelIDS());
			System.out.println("��ҵ�����ľƵ���Ϣ:"+vo.getHotelInfos());
		}
		
		if(service.applyBusinessVip("0000002", "����ʡ�Ͼ���������Ȧ�Ͼ���ѧ�Դ��ٹ�˾", hotelID)){
			
			System.out.println("�ͻ�2����Ƶ���ҵ��Ա�ɹ���");
			ClientVO vo = service.getClientVO(clientID);
			System.out.println("����:"+vo.getName());
			System.out.println("���֤�ţ�"+vo.getIdentityID());
			System.out.println("��Ա���"+vo.getClientType());
			System.out.println("��ҵ��ַ:"+vo.getCompanyAddress());
			System.out.println("��ҵ�����ľƵ�id��"+vo.getHotelIDS());
			System.out.println("��ҵ�����ľƵ���Ϣ:"+vo.getHotelInfos());
		}
	}
}
