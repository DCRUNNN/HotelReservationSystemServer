package service.Account.ProvidedService;

import data.dao.AccountDao;
import data.dao.impl.AccountDaoImpl;

public class AccountProvidedServiceImpl implements AccountProvidedService{

	private AccountDao accountDao;
	
	public AccountProvidedServiceImpl(){
	 
		accountDao = AccountDaoImpl.getInstance();
	}
	
	@Override
	public boolean insert(String clientID, String pass) {
		
		return accountDao.insert(clientID,pass);
	}

}
