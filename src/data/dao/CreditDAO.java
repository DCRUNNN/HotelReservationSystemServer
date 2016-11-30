package data.dao;

import java.util.List;

import po.CreditPO;

public interface CreditDAO {
	
	public List<CreditPO> getAllClientCreditPO(String clientID);
	
	public boolean insert(CreditPO po);
}
