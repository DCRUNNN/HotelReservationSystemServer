package service.Account.ProvidedService;

import data.dao.AccountDao;
import data.dao.impl.AccountDaoImpl;
import service.Account.help.md5;

public class AccountProvidedServiceImpl implements AccountProvidedService{

	private AccountDao accountDao;
	
	public AccountProvidedServiceImpl(){
	 
		accountDao = AccountDaoImpl.getInstance();
	}
	
	@Override
	public boolean insert(String clientID, String pass) {
		
		String password = md5.getMD5(pass);//ʹ��MD5�㷨��������
		return accountDao.insert(clientID,password);
	}

}
