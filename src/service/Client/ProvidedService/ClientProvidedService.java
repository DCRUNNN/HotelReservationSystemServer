package service.Client.ProvidedService;

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
	 * @return �õ���ҵ��Ա��Ӧ����ҵ��ַ
	 * */
	public String getCompanyAddress(String clientID);
	
	/**
	 * @param clientID �ͻ����
	 * @return �õ���ҵ��Ա��Ӧ����ҵ����
	 * */
	public String getCompanyName(String clientID);
}
