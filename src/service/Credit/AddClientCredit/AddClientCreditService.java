package service.Credit.AddClientCredit;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.ClientVO;

public interface AddClientCreditService extends Remote{

	public boolean addCredit(String clientID,double point)throws RemoteException;
	
	public ClientVO getClientVO(String clientID) throws RemoteException;
	
	public boolean checkID (String clientID) throws RemoteException;
	
}
