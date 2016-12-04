package service.Client.ManageClientMessage_webManager;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.ClientVO;

public interface ClientMessage_webManagerService extends Remote{

	public List<ClientVO> getAllClients() throws RemoteException;
	
	public List<ClientVO> getClientsByName(String name)throws RemoteException;
	
	public List<ClientVO> getClientByPhoneNumber(String phoneNumber)throws RemoteException;
	
	public ClientVO getClientMessage(String clientID)throws RemoteException;
	
	public boolean modifyClientMessage(ClientVO vo)throws RemoteException;
}
