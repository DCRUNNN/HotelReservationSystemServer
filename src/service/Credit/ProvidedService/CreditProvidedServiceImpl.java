package service.Credit.ProvidedService;

import data.dao.CreditDAO;
import po.CreditPO;

public class CreditProvidedServiceImpl implements CreditProvidedService{

	private CreditDAO creditDao;
	
	public CreditProvidedServiceImpl(){
		//creditDao��ʵ����
	}
	@Override
	public boolean insertCredit(CreditPO creditpo) {
		
		return creditDao.insert(creditpo);
	}

}
