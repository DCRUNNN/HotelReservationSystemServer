package service.Credit.ShowCreditRecord;

import java.util.List;

import vo.CreditVO;

public interface ShowCreditRecordService {
	
/**
 * 
 * @param PersonnelId
 * @return ��ʾ�������ü�¼
 */
	public List<CreditVO> ShowAllCredit(String clientID);
	
	/**
	 *@param clientID �ͻ����
	 *@return �õ��ͻ���ʣ�����õ�
	 * */
	public double getCreditPoint(String clientID);
}
