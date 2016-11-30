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

	//���õ���ģʽ ������ص�ʱ����ɳ�ʼ�����������߳�ͬ������
	private CreditDaoImpl() {
		
		dataFactory=new DataFactoryImpl();
		creditDataHelper=dataFactory.getCreditDataHelper();
	}
	
	public static CreditDaoImpl getInstance(){
		return INSTANCE;
	} //ͨ������static���������CreditDaoImpl��ʵ��
	
	@Override
	public List<CreditPO> getAllClientCreditPO(String clientID) {
		
		return creditDataHelper.getAllClientCreditPO(clientID);
	}

	@Override
	public boolean insert(CreditPO po) {
	
		return creditDataHelper.insert(po);
	}

}
