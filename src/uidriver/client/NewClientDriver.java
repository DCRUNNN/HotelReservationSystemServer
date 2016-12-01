package uidriver.client;

import service.Client.NewClient.NewClientService;
import service.Client.NewClient.NewClientServiceImpl;
import vo.ClientVO;

public class NewClientDriver {

	//���ֻ�������ΪΨһ��ʶ��ֻ����һ���ֻ�������ע��һ���˻�
	static NewClientService service = new NewClientServiceImpl();
	
	public static void main(String args[]){
		
		ClientVO c1 = new ClientVO(null, "��", "��", "440982", "13927501605", 0, null, null, 0, null, null);
		String id1 = service.insert(c1);//ע�����û�
		if("".equals(id1)){
			System.out.println("An error has occured!");
			System.exit(0);
		}
		
		String pass1 = "123";
		service.savePassword(id1, pass1);
		
		ClientVO c2 = new ClientVO(null, "��", "Ů", "11231465", "1234567898", 0, null, null, 0, null, null);
		String id2 = service.insert(c2);
		if("".equals(id2)||id2==null){
			System.out.println("An error has occured!");
			System.exit(0);
		}
		
		String pass2 = "123";
		service.savePassword(id2, pass2);
		
		String phoneNumber = "13927501";
		ClientVO c3 = new ClientVO(null,"������","��","123456789",phoneNumber,0,null,null,0,null,null);
		if(service.isExistPhoneNumber(phoneNumber)){
			System.out.println("The phoneNumber has existed!");
		}else{
			System.out.println(!"".equals(service.insert(c3))?"�ɹ�����c3��":"ע��ʧ�ܣ�");
		}
		
		
	}
}
