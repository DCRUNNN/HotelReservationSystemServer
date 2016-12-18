package uidriver.room;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import service.Room.CheckOutRoom.CheckOutRoomService;
import service.Room.CheckOutRoom.CheckOutRoomServiceImpl;
import vo.RoomVO;

public class CheckOutRoomDriver {

	public static void main(String args[]) throws RemoteException{
		
		//demo1();
		demo2();
	}

	private static void demo2() throws RemoteException {
		// TODO Auto-generated method stub
		CheckOutRoomService service = new CheckOutRoomServiceImpl();
		String clientID = "0000001";
		String hotelID = "00001";
		//System.out.println(service.checkOutRoom(clientID, hotelID));
		List<String> numbers = new ArrayList<String>();
		
		List<RoomVO> volist = service.getAllRooms(clientID, hotelID);
		for(RoomVO vo:volist){
			show(vo);
			numbers.add(vo.getRoomNumber());
		}
		
		System.out.println(service.checkOutRoom(clientID, hotelID, "102"));
	}

	private static void demo1() throws RemoteException {
		
		//��һ������Ķ������ˣ���������Ķ���ֻ��һ��
		CheckOutRoomService service = new CheckOutRoomServiceImpl();
		String clientID = "0000001";
		String hotelID = "00001";
		//System.out.println(service.checkOutRoom(clientID, hotelID));
		List<String> numbers = new ArrayList<String>();
		
		List<RoomVO> volist = service.getAllRooms(clientID, hotelID);
		for(RoomVO vo:volist){
			show(vo);
			numbers.add(vo.getRoomNumber());
		}
		
		System.out.println(service.checkOutRoom(clientID, hotelID, "101"));
		System.out.println(service.checkOutRoom(clientID, hotelID, "105"));
	}
	
	public static void show(RoomVO vo){
		System.out.println("������룺"+vo.getRoomNumber()+"\n����״̬��"+vo.getRoomState());
	}
}
