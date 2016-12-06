package uidriver.client;

import java.rmi.RemoteException;

import rmi.ClientDataRemoteObject;
import service.Client.ApplyForVip.ApplyForVipService;
import service.Client.ApplyForVip.ApplyForVipServiceImpl;
import vo.ClientVO;

public class ApplyForVipDriver {
	
	//ok
	
	public static void main(String args[]) throws RemoteException{
		
        ClientDataRemoteObject data = new ClientDataRemoteObject();
		String clientID = "0000001";
		String hotelID = "00001";
		boolean isNormalVip = data.checkNormalVip(clientID);
		boolean isBusinessVip = data.checkBusinessVip(clientID);
		
		if(isNormalVip){
			ClientVO vo = data.getClientVO(clientID);
			System.out.println("����:"+vo.getName());
			System.out.println("���֤�ţ�"+vo.getIdentityID());
			System.out.println("��Ա���"+vo.getClientType());
		}
		
		/*if(data.applyNormalVip(clientID, "10-20")){
			System.out.println("Apply for normal vip successfully!");
		}
		
		if(data.checkNormalVip(clientID)){
			
			ClientVO vo = data.getClientVO(clientID);
			System.out.println("����:"+vo.getName());
			System.out.println("���֤�ţ�"+vo.getIdentityID());
			System.out.println("��Ա���"+vo.getClientType());
		}//�����������ͨ��Ա
		
		if(isBusinessVip){
			  
		ClientVO vo = data.getClientVO(clientID);
		System.out.println("����:"+vo.getName());
		System.out.println("���֤�ţ�"+vo.getIdentityID());
		System.out.println("��Ա���"+vo.getClientType());
	}
		
		if(data.applyBusinessVip(clientID,"�㶫ʡï���л�����Ȧ����һ�����Ǻӹ�˾",hotelID)){
			System.out.println("Apply for businessvip successfully!");
		}//������ҵ��Ա
	
		if(data.checkBusinessVip(clientID)){

			ClientVO vo = data.getClientVO(clientID);
			System.out.println("����:"+vo.getName());
			System.out.println("���֤�ţ�"+vo.getIdentityID());
			System.out.println("��Ա���"+vo.getClientType());
			System.out.println("��ҵ��ַ:"+vo.getCompanyAddress());
			System.out.println("��ҵ�����ľƵ�id��"+vo.getHotelIDS());
			System.out.println("��ҵ�����ľƵ���Ϣ:"+vo.getHotelInfos());
		
		}
		
		if(data.applyBusinessVip(clientID, "�㶫ʡï���л�����Ȧ����һ�����Ǻӹ�˾", "00002")){
			
			System.out.println("�ٴ�����Ƶ���ҵ��Ա�ɹ���");
			ClientVO vo = data.getClientVO(clientID);
			System.out.println("����:"+vo.getName());
			System.out.println("���֤�ţ�"+vo.getIdentityID());
			System.out.println("��Ա���"+vo.getClientType());
			System.out.println("��ҵ��ַ:"+vo.getCompanyAddress());
			System.out.println("��ҵ�����ľƵ�id��"+vo.getHotelIDS());
			System.out.println("��ҵ�����ľƵ���Ϣ:"+vo.getHotelInfos());
		}
		
		if(data.applyBusinessVip("0000002", "����ʡ�Ͼ���������Ȧ�Ͼ���ѧ�Դ��ٹ�˾", hotelID)){
			
			System.out.println("�ͻ�2����Ƶ���ҵ��Ա�ɹ���");
			ClientVO vo = data.getClientVO(clientID);
			System.out.println("����:"+vo.getName());
			System.out.println("���֤�ţ�"+vo.getIdentityID());
			System.out.println("��Ա���"+vo.getClientType());
			System.out.println("��ҵ��ַ:"+vo.getCompanyAddress());
			System.out.println("��ҵ�����ľƵ�id��"+vo.getHotelIDS());
			System.out.println("��ҵ�����ľƵ���Ϣ:"+vo.getHotelInfos());
		}*/
	}
}
