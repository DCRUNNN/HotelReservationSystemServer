package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class HotelWorkerRemoteHelper {



	public HotelWorkerRemoteHelper(){
		
		initServer();
	}

	private void initServer() {
		
		HotelWorkerDataRemoteObject hotelworkerData ;
		try {
			hotelworkerData = new HotelWorkerDataRemoteObject();
			LocateRegistry.createRegistry(7777);
			Naming.bind("rmi://localhost:7777/HotelWorkerDataRemoteObject",
					hotelworkerData);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}

}
