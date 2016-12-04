package uidriver.client;

import java.rmi.RemoteException;

import service.Client.ManageClientMessage_client.ManageClientMessage_clientService;
import service.Client.ManageClientMessage_client.ManageClientMessage_clientServiceImpl;
import vo.ClientVO;

public class ManageClientMessage_clientDriver {

	public static void main(String args[]) throws RemoteException{
		
		ManageClientMessage_clientService service = new ManageClientMessage_clientServiceImpl();
		
		String clientID = "0000002";
		ClientVO vo = service.getClientVO(clientID);
		
		System.out.println(vo.getClientType());
		System.out.println(vo.getIdentityID());
		System.out.println(vo.getName());
		System.out.println(vo.getPhoneNumber());
		
		vo.setName("ºÀ");
		vo.setPhoneNumber("13456879");
		if(service.changeClientMessage(vo)){
			System.out.println("Change Info successfully!");
		}
		
		
	}
}
