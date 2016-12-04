package service.Client.ApplyForVip;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.ClientVO;

/**
 * ��Ӧ�����Ա�����Ľӿ�
 * */
public interface ApplyForVipService extends Remote{

	/**
	 * @param clientId �ͻ����
	 * @return �ڿͻ��Ѿ��ǻ�Ա��ʱ��,������ʾ�ͻ�����ϸ��Ϣ
	 * */
	public ClientVO getClientVO(String clientID)  throws RemoteException;

	/**
	 * @param clientID �ͻ����
	 * @param birthday �ͻ����� �����ʽΪ(MM-dd)
	 * @return ������ͨ��Ա
	 * */
	public boolean applyNormalVip(String clientID,String birthday)throws RemoteException;
	
	/**
	 * @param clientID �ͻ����
	 * @param companyAddress ��ҵ��ϸ��ַ�����Ƶ������
	 * @param hotelID ����ľƵ���
	 * @return ������ҵ��Ա
	 * */
    public boolean applyBusinessVip(String clientID,String companyAddress,String hotelID)throws RemoteException;
    
    /**
     * @param clientID �ͻ����
     * @return �жϿͻ��ǲ�����ͨ��Ա
     * */
    public boolean checkNormalVip(String clientID)throws RemoteException;
    
    /**
     * @param clientID �ͻ����
     * @return �жϿͻ��ǲ�����ҵ��Ա
     * */
    public boolean checkBusinessVip(String clientID)throws RemoteException;
}
