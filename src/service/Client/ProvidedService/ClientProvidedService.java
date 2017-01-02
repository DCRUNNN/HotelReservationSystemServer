package service.Client.ProvidedService;

import vo.ClientVO;

public interface ClientProvidedService {

	/**
	 * @param  �ͻ����,Ҫ�۳������õ�
	 * @return ��ɿ۳��ͻ������õ�
	 * */
	public boolean subClientCreditPoint(String clientID,double point);
	
	/**
	 * @param �ͻ���ţ�Ҫ���ӵ����õ�
	 * @return ������ӿͻ������õ�
	 * */
	public boolean addClientCreditPoint(String clientID,double point);
	
	/**
	 * @param �ͻ����
	 * @return ���ؿͻ�����
	 * */
	public String getUserType(String clientID);

	/**
	 * @param �ͻ����
	 * @return ����ֵ����0����true������ֵС��0����false
	 * */
	public boolean checkCreditPoint(String clientID);
	
	/**
	 * @param clientID �ͻ���Ű�
	 * @return �õ��ͻ���ʣ�����õ�
	 * */
	public double getCreditPoint(String clientID);

	/**
	 * @param clientID �ͻ����
	 * @return �õ��ͻ�������
	 * */
	public String getVipBirthday(String clientID);

	/**
	 * @param clientID �ͻ����
	 * @return �õ��ͻ���vip�ȼ�
	 * */
	public int getVipGrade(String clientID);

	/**
	 * @param clientID �ͻ����
	 * @return �õ���ҵ��Ա��Ӧ����ҵ��ϸ��ַ ���clientID����Ļ�����""
	 * */
	public String getCompanyAddress(String clientID);
	
	/**
	 * @param clientID �ͻ����
	 * @return �õ���ҵ��Ա���еĺ����Ƶ�ı�� ���clientID����Ļ�����""
	 * */
	public String getHotelIDs(String clientID);

	/**
	 * @param clientID �ͻ����
	 * @param hotelID �Ƶ���
	 * @return ��ҵ��Ա�Ķ�Ӧ�Ƶ����hotelID�Ļ�������true���������false
	 * */
	public boolean isCorrectCompanyVip(String clientID, String hotelID);

	/**
	 * @param clientID �ͻ����
	 * @return ���ؿͻ�������
	 * */
	public String getClientName(String clientID);
	
	/**
	 * @return ���ؿͻ����Ա�
	 * */
	public String getSex(String clientID);
	
	/**
	 * @return ���ؿͻ������֤��
	 * */
	public String getIdentityID(String clientID);
	
	/**
	 * @return ���ؿͻ����ֻ�����
	 * */
	public String getPhoneNumber(String clientID);
	
	/**
	 * @param clientID �ͻ����
	 * @return ���ؿͻ���vip��Ϣ
	 * */
	public String getVIPInfo(String clientID);
	
	/**
	 * @param clientID �ͻ����
	 * @return ���ؿͻ������õ�
	 * */
	public double getCredit(String clientID);

	/**
	 * @param clientID �ͻ����
	 * @return ���ؿͻ���Ϣ
	 * */
	public ClientVO getClientVO(String clientID);

	/**
	 * @param clientID �ͻ����
	 * @return �ж�id�Ƿ����
	 * */
	public boolean checkID(String clientID);
}
