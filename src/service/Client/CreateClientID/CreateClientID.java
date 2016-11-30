package service.Client.CreateClientID;

import java.util.List;

import data.dao.ClientDAO;
import data.dao.impl.ClientDaoImpl;
import po.ClientPO;

public class CreateClientID {

	/*
	 *客户编号，编号规则七位序列号(从0000001开始) 
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
			}//找到当前最大值
			if(max==9999999){
				return "";
			}
			
			max++;
			String newID = String.valueOf(max);
			String zero = "";
			for(int i=0;i<length-newID.length();i++){
				zero+="0";
			}
			String ID = zero+newID;//最大值加一创建新的ID
			
			ClientPO po = new ClientPO();
			po.setId(ID);
			if(!clientDao.insert(po)){
				//往数据层插入一个序列号为ID的持久化对象
				return "";
			}
			return ID;
		}
	}
}
