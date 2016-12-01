package data.dao;

import java.util.List;

import po.ClientPO;

public interface ClientDAO {
	
	/**
	 * @param client_id �ͻ����
	 * @return �õ��ͻ��ĳ־û�����
	 * */
	public ClientPO getClientPO(String client_id);


	/**
	 * @param clientID �ͻ����
	 * @return ��ɵõ��ͻ��ĵ�ǰ���õ�
	 * */
	public double getClientPoint(String clientID);

	/**
	 * @param clientID �ͻ����
	 * @param vip�ȼ�
	 * @return ������ÿͻ���vip�ȼ�
	 * */
	public boolean setVipGrade(String clientID, int grade);

	/**
	 * @param clientID �ͻ����
	 * @param left �۳�֮���ʣ�����õ�
	 * @return ���ؿ۳����õ��Ƿ�ɹ�
	 * */
	public boolean subClientCreditPoint(String clientID, double left);

	/**
	 * @param clientID �ͻ����
	 * @param left ����֮������õ�
	 * @return �����������õ��Ƿ�ɹ�
	 * */
	public boolean addClientCreditPoint(String clientID, double left);

	/**
	 * @param clientID
	 * @return �õ��ͻ����û�����
	 * */
	public String getUserType(String clientID);

	/**
	 * @param �ͻ��ĳ־û�����
	 * @return �����Ƿ�ɹ��ı�ͻ�����Ϣ
	 * */
	public boolean change(ClientPO po);

	/**
	 * @return �õ����еĿͻ���Ϣ
	 * */
	public List<ClientPO> getAllClient();

	/**
	 * @return �õ����еĿͻ����
	 * */
	public List<String> getAllIds();


	/**
	 * @param �ͻ���Ϣ
	 * @return ����ͻ���Ϣ
	 * */
	public boolean insert(ClientPO po);

    /**
     * @param phoneNumber �ֻ�����
     * @return ���ڷ���true�������ڷ���false
     * */
	public boolean isExistPhoneNumber(String phoneNumber);
}
