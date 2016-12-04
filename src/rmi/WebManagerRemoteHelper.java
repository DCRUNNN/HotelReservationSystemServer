package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class WebManagerRemoteHelper {


	public WebManagerRemoteHelper(){
		
		initServer();
	}

	private void initServer() {
		
		WebManagerDataRemoteObject webManager ;
		try {
			webManager = new WebManagerDataRemoteObject();
			LocateRegistry.createRegistry(5555);
			Naming.bind("rmi://localhost:5555/WebManagerDataRemoteObject",
					webManager);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}


}
