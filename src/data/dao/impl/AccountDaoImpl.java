package data.dao.impl;

import data.dao.AccountDao;
import data.datahelper.AccountDataHelper;
import data.datahelper.DataFactory;
import data.datahelper.impl.DataFactoryImpl;

public class AccountDaoImpl implements AccountDao{

	private static final AccountDaoImpl INSTANCE = new AccountDaoImpl();
	private DataFactory dataFactory;
	private AccountDataHelper datahelper;
	
	private AccountDaoImpl(){
		
		dataFactory = new DataFactoryImpl();
		datahelper = dataFactory.getAccountDataHelper();
	}
	
	public static AccountDaoImpl getInstance (){
		return INSTANCE;
	}
	
	@Override
	public boolean insert(String clientID, String pass) {

		return datahelper.insert(clientID,pass);
	}

	@Override
	public boolean check(String id, String password) {
		
		return datahelper.check(id,password);
	}

}
