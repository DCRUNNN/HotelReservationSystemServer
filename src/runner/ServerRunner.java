package runner;

import rmi.ClientRemoteHelper;
import rmi.HotelWorkerRemoteHelper;
import rmi.WebManagerRemoteHelper;
import rmi.WebSalerRemoteHelper;
import service.Order.Thread.ChangeToAbnormal;

public class ServerRunner {

	public ServerRunner(){
	
		new ClientRemoteHelper();
		new HotelWorkerRemoteHelper();
		new WebSalerRemoteHelper();
		new WebManagerRemoteHelper();
		
	}
	public static void main(String args[]){
		

		new ServerRunner();
		System.out.println("·þÎñÆ÷Æô¶¯£¡");
		//Thread thread = new Thread(new ChangeToAbnormal());
		//thread.start();
	}
}
