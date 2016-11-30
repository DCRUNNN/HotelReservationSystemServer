package service.Client.NewClient;

import data.dao.ClientDAO;
import data.dao.impl.ClientDaoImpl;
import po.ClientPO;
import service.Account.ProvidedService.AccountProvidedService;
import service.Account.ProvidedService.AccountProvidedServiceImpl;
import service.Client.CreateClientID.CreateClientID;
import vo.ClientVO;

public class NewClientServiceImpl implements NewClientService{

	private ClientDAO clientDao;
	private AccountProvidedService accountService;
	
	public NewClientServiceImpl(){
		
		clientDao = ClientDaoImpl.getInstance();
		accountService = new AccountProvidedServiceImpl();
	}
	
	@Override
	public String insert(ClientVO vo) {
		
		ClientPO po = new ClientPO();
		String clientID = new CreateClientID().nextID();
		if("".equals(clientID)){
			//达到上限或者插入数据库不成功
			return "";
		}
		po.setId(clientID);
		po.setIdentityID(vo.getIdentityID());
		po.setName(vo.getName());
		po.setPhoneNumber(vo.getPhoneNumber());
		po.setSex(vo.getSex());
		po.setClientType("普通客户");
		if(!clientDao.change(po)){
			return "";
		}
		return clientID;
	}

	@Override
	public boolean savePassword(String clientID, String pass) {
		
		return accountService.insert(clientID,pass);
	}

}
