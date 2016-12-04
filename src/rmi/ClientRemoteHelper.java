package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ClientRemoteHelper {

	public ClientRemoteHelper(){
		
		initServer();
	}

	private void initServer() {
		
		ClientDataRemoteObject clientData ;
		try {
			clientData = new ClientDataRemoteObject();
			LocateRegistry.createRegistry(8888);
			Naming.bind("rmi://localhost:8888/ClientDataRemoteObject",
					clientData);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}
