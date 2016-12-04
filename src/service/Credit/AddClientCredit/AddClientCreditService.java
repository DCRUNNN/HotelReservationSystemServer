package service.Credit.AddClientCredit;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddClientCreditService extends Remote{

	public boolean addCredit(String clientID,double point)throws RemoteException;
}
