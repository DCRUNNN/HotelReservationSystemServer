package rmi;

import java.io.File;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import data.datahelper.xmlhelper.XMLHelper;
import service.Account.Login.LoginService;
import service.Client.NewClient.NewClientService;
import vo.ClientVO;

public class LoginDataRemoteObject extends UnicastRemoteObject implements LoginService,NewClientService  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginService login;
	private NewClientService newClient;
	
	public LoginDataRemoteObject() throws RemoteException {
		
		super();
		String filePath = "./xml/servicexml/loginservice.xml";
		try {
			login =(LoginService) Class.forName(XMLHelper.getClass(filePath, "login")).newInstance();
			newClient = (NewClientService) Class.forName(XMLHelper.getClass(filePath, "addNewClient")).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String insert(ClientVO vo) throws RemoteException {
		
		return newClient.insert(vo);
	}

	@Override
	public boolean savePassword(String clientID, String pass) throws RemoteException {
		
		return newClient.savePassword(clientID, pass);
	}

	@Override
	public boolean isExistPhoneNumber(String phoneNumber) throws RemoteException {
		
		return newClient.isExistPhoneNumber(phoneNumber);
	}

	@Override
	public boolean check(String id, String password) throws RemoteException {
		
		return login.check(id, password);
	}

	@Override
	public String getType(String ID) throws RemoteException {
		
		return login.getType(ID);
	}

	@Override
	public byte[] getClientPicture(String clientID) throws RemoteException {
		
		return login.getClientPicture(clientID);
	}

}
