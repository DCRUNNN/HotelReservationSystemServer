package data.datahelper;

import java.util.List;

import po.ClientPO;

public interface ClientDataHelper {
	
	public ClientPO getClientPO(String client_id);
	
	public double getClientPoint(String client_id);
	
	public boolean setVipGrade(String client_id,int grade);
	
	public boolean subClientCreditPoint(String client_id,double left);
	
	public boolean addClientCreditPoint(String client_id,double left);
	
	public boolean change(ClientPO po);
	
	public String getUserType(String client_id);
	
	public List<ClientPO> getAllClient();

	public List<String> getAllIds();

	public boolean insert(ClientPO po);

	public boolean isExistPhoneNumber(String phoneNumber);

}
