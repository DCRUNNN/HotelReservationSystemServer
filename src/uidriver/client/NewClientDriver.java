package uidriver.client;

import service.Client.NewClient.NewClientService;
import service.Client.NewClient.NewClientServiceImpl;
import vo.ClientVO;

public class NewClientDriver {

	//用手机号码作为唯一标识，只能用一个手机号码来注册一个账户
	static NewClientService service = new NewClientServiceImpl();
	
	public static void main(String args[]){
		
		ClientVO c1 = new ClientVO(null, "曾", "男", "440982", "13927501605", 0, null, null, 0, null, null);
		String id1 = service.insert(c1);//注册新用户
		if("".equals(id1)){
			System.out.println("An error has occured!");
			System.exit(0);
		}
		
		String pass1 = "123";
		service.savePassword(id1, pass1);
		
		ClientVO c2 = new ClientVO(null, "锡", "女", "11231465", "1234567898", 0, null, null, 0, null, null);
		String id2 = service.insert(c2);
		if("".equals(id2)||id2==null){
			System.out.println("An error has occured!");
			System.exit(0);
		}
		
		String pass2 = "123";
		service.savePassword(id2, pass2);
		
		String phoneNumber = "13927501";
		ClientVO c3 = new ClientVO(null,"黄泽鹏","男","123456789",phoneNumber,0,null,null,0,null,null);
		if(service.isExistPhoneNumber(phoneNumber)){
			System.out.println("The phoneNumber has existed!");
		}else{
			System.out.println(!"".equals(service.insert(c3))?"成功插入c3！":"注册失败！");
		}
		
		
	}
}
