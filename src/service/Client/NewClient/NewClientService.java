package service.Client.NewClient;

import vo.ClientVO;

public interface NewClientService {

	/**
	 * @param �ͻ�������Ϣ
	 * @return ע��ɹ��Ļ����ؿͻ���id�����ɹ�����"" ����������ͻ���Ϣ���ܲ��ܵõ���ţ��õ���ŵĻ�������������
	 * */
	public String insert(ClientVO vo);
	
	/**
	 * @param clientID
	 * @param pass ����
	 * @return ��������
	 * */
	public boolean savePassword(String clientID,String pass);
	
}
