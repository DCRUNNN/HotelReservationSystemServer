package service.Account.Login;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginService extends Remote{

	
	public boolean check(String id,String password) throws RemoteException;
	
	/**
	 * @param �û����
	 * @return �����û������� ���ܱ�𷵻�""
	 * */
	public String getType(String ID) throws RemoteException;
	
	/**
	 * @param clientID �ͻ����
	 * @return ���ؿͻ���ͷ���ļ�,�����ڵĻ�����null
	 * */
	public byte[] getClientPicture(String clientID) throws RemoteException;
}
