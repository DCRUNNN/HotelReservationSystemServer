package uidriver.room;

import java.rmi.RemoteException;

import service.Room.CheckOutRoom.CheckOutRoomService;
import service.Room.CheckOutRoom.CheckOutRoomServiceImpl;

public class CheckOutRoomDriver {

	public static void main(String args[]) throws RemoteException{
		
		demo1();
	}

	private static void demo1() throws RemoteException {
		
		CheckOutRoomService service = new CheckOutRoomServiceImpl();
		String clientID = "0000001";
		String hotelID = "00001";
		//System.out.println(service.checkOutRoom(clientID, hotelID));
	}
}
