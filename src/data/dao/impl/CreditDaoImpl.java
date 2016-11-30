package data.dao.impl;

import java.util.List;

import data.dao.CreditDAO;
import data.datahelper.CreditDataHelper;
import data.datahelper.DataFactory;
import data.datahelper.impl.DataFactoryImpl;
import po.CreditPO;

public class CreditDaoImpl implements CreditDAO{
	
private CreditDataHelper creditDataHelper;
	
	private DataFactory dataFactory;
	
	private static final CreditDaoImpl INSTANCE=new CreditDaoImpl();

	//运用单例模式 在类加载的时候完成初始化，不存在线程同步问题
	private CreditDaoImpl() {
		
		dataFactory=new DataFactoryImpl();
		creditDataHelper=dataFactory.getCreditDataHelper();
	}
	
	public static CreditDaoImpl getInstance(){
		return INSTANCE;
	} //通过调用static方法来获得CreditDaoImpl的实例
	
	@Override
	public List<CreditPO> getAllClientCreditPO(String clientID) {
		
		return creditDataHelper.getAllClientCreditPO(clientID);
	}

	@Override
	public boolean insert(CreditPO po) {
	
		return creditDataHelper.insert(po);
	}

}
