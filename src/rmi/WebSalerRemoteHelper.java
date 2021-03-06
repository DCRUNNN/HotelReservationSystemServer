package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class WebSalerRemoteHelper {

	public WebSalerRemoteHelper(){
		
		initServer();
	}

	private void initServer() {
		
		WebSalerDataRemoteObject websaler ;
		try {
			websaler = new WebSalerDataRemoteObject();
			LocateRegistry.createRegistry(6666);
			Naming.bind("rmi://localhost:6666/WebSalerDataRemoteObject",
					websaler);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}

}
