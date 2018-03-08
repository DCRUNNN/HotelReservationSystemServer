package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class LoginRemoteHelper {

	public LoginRemoteHelper(){
		initServer();
	}

	private void initServer() {
		
		LoginDataRemoteObject login;
		try {
			login = new LoginDataRemoteObject();
			LocateRegistry.createRegistry(9999);
			Naming.bind("rmi://localhost:9999/LoginDataRemoteObject",
					login);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}
