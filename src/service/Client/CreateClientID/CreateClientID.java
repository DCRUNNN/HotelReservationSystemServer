package service.Client.CreateClientID;

import java.util.List;

import data.dao.ClientDAO;
import data.dao.impl.ClientDaoImpl;
import po.ClientPO;

public class CreateClientID {

	/*
	 *�ͻ���ţ���Ź�����λ���к�(��0000001��ʼ) 
	 * */
	private ClientDAO clientDao;
	private int length = 7;
	public CreateClientID(){
		
		clientDao = ClientDaoImpl.getInstance();
	}
	
	public String nextID(){
		
		synchronized(this){
			
			List<String> allids = clientDao.getAllIds();
			int max=0;
			for(String str:allids){
				int value = Integer.valueOf(str);
				if(value>max){
					max=value;
				}
			}//�ҵ���ǰ���ֵ
			if(max==9999999){
				return "";
			}
			
			max++;
			String newID = String.valueOf(max);
			String zero = "";
			for(int i=0;i<length-newID.length();i++){
				zero+="0";
			}
			String ID = zero+newID;//���ֵ��һ�����µ�ID
			
			ClientPO po = new ClientPO();
			po.setId(ID);
			if(!clientDao.insert(po)){
				//�����ݲ����һ�����к�ΪID�ĳ־û�����
				return "";
			}
			return ID;
		}
	}
}
