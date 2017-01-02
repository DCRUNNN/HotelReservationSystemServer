package service.Client.NewClient;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.ClientVO;

public interface NewClientService extends Remote{

	/**
	 * @param �ͻ�������Ϣ
	 * @return ע��ɹ��Ļ����ؿͻ���id�����ɹ�����"" ����������ͻ���Ϣ���ܲ��ܵõ���ţ��õ���ŵĻ�������������
	 * */
	public String insert(ClientVO vo)throws RemoteException;
	
	/**
	 * @param clientID
	 * @param pass ����
	 * @return ��������
	 * */
	public boolean savePassword(String clientID,String pass) throws RemoteException;
	
	/**
	 * @param phoneNumber �ֻ�����
	 * @return �ֻ������Ѿ����ڵĻ�����true������false
	 * */
	public boolean isExistPhoneNumber(String phoneNumber) throws RemoteException;
	
}
