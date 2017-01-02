package service.Account.Login;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginService extends Remote{

	
	public boolean check(String id,String password) throws RemoteException;
	
	/**
	 * @param 用户编号
	 * @return 返回用户的类型 不能辨别返回""
	 * */
	public String getType(String ID) throws RemoteException;
	
	/**
	 * @param clientID 客户编号
	 * @return 返回客户的头像文件,不存在的话返回null
	 * */
	public byte[] getClientPicture(String clientID) throws RemoteException;
}
