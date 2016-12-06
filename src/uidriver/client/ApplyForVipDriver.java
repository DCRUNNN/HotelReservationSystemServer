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
			System.out.println("姓名:"+vo.getName());
			System.out.println("身份证号："+vo.getIdentityID());
			System.out.println("会员类别："+vo.getClientType());
		}
		
		/*if(data.applyNormalVip(clientID, "10-20")){
			System.out.println("Apply for normal vip successfully!");
		}
		
		if(data.checkNormalVip(clientID)){
			
			ClientVO vo = data.getClientVO(clientID);
			System.out.println("姓名:"+vo.getName());
			System.out.println("身份证号："+vo.getIdentityID());
			System.out.println("会员类别："+vo.getClientType());
		}//完成了申请普通会员
		
		if(isBusinessVip){
			  
		ClientVO vo = data.getClientVO(clientID);
		System.out.println("姓名:"+vo.getName());
		System.out.println("身份证号："+vo.getIdentityID());
		System.out.println("会员类别："+vo.getClientType());
	}
		
		if(data.applyBusinessVip(clientID,"广东省茂名市化州商圈化州一中旁星河公司",hotelID)){
			System.out.println("Apply for businessvip successfully!");
		}//申请企业会员
	
		if(data.checkBusinessVip(clientID)){

			ClientVO vo = data.getClientVO(clientID);
			System.out.println("姓名:"+vo.getName());
			System.out.println("身份证号："+vo.getIdentityID());
			System.out.println("会员类别："+vo.getClientType());
			System.out.println("企业地址:"+vo.getCompanyAddress());
			System.out.println("企业合作的酒店id："+vo.getHotelIDS());
			System.out.println("企业合作的酒店信息:"+vo.getHotelInfos());
		
		}
		
		if(data.applyBusinessVip(clientID, "广东省茂名市化州商圈化州一中旁星河公司", "00002")){
			
			System.out.println("再次申请酒店企业会员成功！");
			ClientVO vo = data.getClientVO(clientID);
			System.out.println("姓名:"+vo.getName());
			System.out.println("身份证号："+vo.getIdentityID());
			System.out.println("会员类别："+vo.getClientType());
			System.out.println("企业地址:"+vo.getCompanyAddress());
			System.out.println("企业合作的酒店id："+vo.getHotelIDS());
			System.out.println("企业合作的酒店信息:"+vo.getHotelInfos());
		}
		
		if(data.applyBusinessVip("0000002", "江苏省南京市仙林商圈南京大学旁聪少公司", hotelID)){
			
			System.out.println("客户2申请酒店企业会员成功！");
			ClientVO vo = data.getClientVO(clientID);
			System.out.println("姓名:"+vo.getName());
			System.out.println("身份证号："+vo.getIdentityID());
			System.out.println("会员类别："+vo.getClientType());
			System.out.println("企业地址:"+vo.getCompanyAddress());
			System.out.println("企业合作的酒店id："+vo.getHotelIDS());
			System.out.println("企业合作的酒店信息:"+vo.getHotelInfos());
		}*/
	}
}
