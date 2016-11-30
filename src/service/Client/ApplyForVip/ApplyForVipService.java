package service.Client.ApplyForVip;

import vo.ClientVO;

/**
 * ��Ӧ�����Ա�����Ľӿ�
 * */
public interface ApplyForVipService {

	/**
	 * @param clientId �ͻ����
	 * @return �ڿͻ��Ѿ��ǻ�Ա��ʱ��,������ʾ�ͻ�����ϸ��Ϣ
	 * */
	public ClientVO getClientVO(String clientID);

	/**
	 * @param clientID �ͻ����
	 * @param birthday �ͻ����� �����ʽΪ(yyyy-MM-dd)
	 * @return ������ͨ��Ա
	 * */
	public boolean applyNormalVip(String clientID,String birthday);
	
	/**
	 * @param clientID �ͻ����,companyAddress ��ҵ��ַ(ʡ��+��/��+��+��/��+��ϸ��ַ),companyName ��ҵ����
	 * @return ������ҵ��Ա
	 * */
    public boolean applyBusinessVip(String clientID,String companyAddress,String companyName);
    
    /**
     * @param clientID �ͻ����
     * @return �жϿͻ��ǲ�����ͨ��Ա
     * */
    public boolean checkNormalVip(String clientID);
    
    /**
     * @param clientID �ͻ����
     * @return �жϿͻ��ǲ�����ҵ��Ա
     * */
    public boolean checkBusinessVip(String clientID);
}
