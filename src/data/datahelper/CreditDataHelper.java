package data.datahelper;

import java.util.List;

import po.CreditPO;

public interface CreditDataHelper {
	public List<CreditPO> getAllClientCreditPO(String clientID);
	
	public boolean insert(CreditPO po);
}
