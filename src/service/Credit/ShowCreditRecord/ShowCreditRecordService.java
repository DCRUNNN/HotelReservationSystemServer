package service.Credit.ShowCreditRecord;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.CreditVO;

public interface ShowCreditRecordService extends Remote{
	
/**
 * 
 * @param PersonnelId
 * @return 显示所有信用记录
 */
	public List<CreditVO> ShowAllCredit(String clientID)throws RemoteException;
	
	/**
	 *@param clientID 客户编号
	 *@return 得到客户的剩余信用点
	 * */
	public double getCreditPoint(String clientID)throws RemoteException;
}
