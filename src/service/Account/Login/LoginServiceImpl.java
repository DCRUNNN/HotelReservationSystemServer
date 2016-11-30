package service.Account.Login;

import data.dao.AccountDao;
import data.dao.impl.AccountDaoImpl;

public class LoginServiceImpl implements LoginService{

	private AccountDao accountDao;
	
	public LoginServiceImpl(){
		
		accountDao = AccountDaoImpl.getInstance();
	}
	@Override
	public boolean check(String id, String password) {
		
		return accountDao.check(id,password);
	}

}
