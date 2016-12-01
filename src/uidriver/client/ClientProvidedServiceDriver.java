package uidriver.client;

import service.Client.ProvidedService.ClientProvidedService;
import service.Client.ProvidedService.ClientProvidedServiceImpl;

public class ClientProvidedServiceDriver {

	public static void main(String args[]){
		
		ClientProvidedService service = new ClientProvidedServiceImpl();
		String clientID = "0000001";
		System.out.println(service.getUserType(clientID));
		System.out.println(service.getVipBirthday(clientID));
		System.out.println(service.getCompanyAddress(clientID));
		System.out.println(service.getCompanyName(clientID));
		System.out.println(service.addClientCreditPoint(clientID, 20000)?"成功增加信用点！":"增加信用点失败！");
		System.out.println(service.subClientCreditPoint(clientID, 10000)?"成功扣除信用点!":"扣除信用点失败！");
		System.out.println(service.getVipGrade(clientID));
		System.out.println(service.checkCreditPoint(clientID)?"信用点大于0":"信用点小于0");
		
	}
}

