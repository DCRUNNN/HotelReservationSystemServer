package service.Account.Login;

import data.dao.AccountDao;
import data.dao.impl.AccountDaoImpl;
import service.Account.help.md5;

public class LoginServiceImpl implements LoginService{

	private AccountDao accountDao;
	
	public LoginServiceImpl(){
		
		accountDao = AccountDaoImpl.getInstance();
	}
	@Override
	public boolean check(String id, String password) {
		
		String pass = md5.getMD5(password);
		
		return accountDao.check(id,pass);//登录时比对的是加密之后的字符串
	}

}
