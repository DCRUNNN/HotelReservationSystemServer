package service.Client.InteractWithHotel;

import data.dao.ClientDAO;
import data.dao.impl.ClientDaoImpl;
import po.ClientPO;

public class ClientProvidedServiceForHotelImpl implements ClientProvidedServiceForHotel{

	private ClientDAO clientDao;
	
	public ClientProvidedServiceForHotelImpl(){
		
		clientDao = ClientDaoImpl.getInstance();
	}
	
	@Override
	public String getClientName(String clientID) {
		
		ClientPO po = clientDao.getClientPO(clientID);
		if(po==null){
			return "";
		}
		return po.getName();
	}

	@Override
	public String getSex(String clientID) {
		
		ClientPO po = clientDao.getClientPO(clientID);
		if(po==null){
			return "";
		}
		return po.getSex();
	}

	@Override
	public String getIdentityID(String clientID) {
		
		ClientPO po = clientDao.getClientPO(clientID);
		if(po==null){
			return "";
		}
		return po.getIdentityID();
	}

	@Override
	public String getPhoneNumber(String clientID) {
		
		ClientPO po = clientDao.getClientPO(clientID);
		if(po==null){
			return "";
		}
		return po.getPhoneNumber();
	}

}
