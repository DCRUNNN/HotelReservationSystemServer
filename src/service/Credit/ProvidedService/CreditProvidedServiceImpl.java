package service.Credit.ProvidedService;

import data.dao.CreditDAO;
import data.dao.impl.CreditDaoImpl;
import po.CreditPO;

public class CreditProvidedServiceImpl implements CreditProvidedService{

	private CreditDAO creditDao;
	
	public CreditProvidedServiceImpl(){
		
		creditDao = CreditDaoImpl.getInstance();
	}
	@Override
	public boolean insertCredit(CreditPO creditpo) {
		
		return creditDao.insert(creditpo);
	}

}
