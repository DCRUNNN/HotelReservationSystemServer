package service.Credit.ShowCreditRecord;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.CreditVO;

public interface ShowCreditRecordService extends Remote{
	
/**
 * 
 * @param PersonnelId
 * @return ��ʾ�������ü�¼
 */
	public List<CreditVO> ShowAllCredit(String clientID)throws RemoteException;
	
	/**
	 *@param clientID �ͻ����
	 *@return �õ��ͻ���ʣ�����õ�
	 * */
	public double getCreditPoint(String clientID)throws RemoteException;
}
