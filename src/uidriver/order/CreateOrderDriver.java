package uidriver.order;

import java.rmi.RemoteException;

import rmi.ClientDataRemoteObject;
import service.Order.CreateOrder.CreateOrderService;
import service.Order.CreateOrder.CreateOrderServiceImpl;

// ok

public class CreateOrderDriver {

	public static void main(String args[]) throws RemoteException{
		
	    /*demo1();
	    demo2();
	    demo3();
		demo4();
		demo5();
		demo6();*/
		demo7();
		demo8();
		
	}

	private static void demo8() {
		
		//�ͻ�����һ������Ķ���
		String clientID = "0000001";
		String hotelID ="00001";
		try {
			ClientDataRemoteObject service = new ClientDataRemoteObject();
			String roomType = "��׼��ͥ��";
			String roomNumber = service.getAllRoomNumber(hotelID, roomType).split("/")[0];
			System.out.println(service.createOrder(hotelID, clientID, roomType, roomNumber)?"���ɶ����ɹ���":"���ɶ���ʧ�ܣ�");
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		
	}

	private static void demo7() {
		
		//�ͻ�������������Ķ���
		String clientID = "0000001";
		String hotelID = "00001";
		try {
			ClientDataRemoteObject service = new ClientDataRemoteObject();
			System.out.println(service.getRoomTypeAndPrice(hotelID));
			String roomType = "��׼���˼�/��׼˫�˼�";
			String roomNumber1 = service.getAllRoomNumber(hotelID, "��׼���˼�").split("/")[0];
			String roomNumber2 = service.getAllRoomNumber(hotelID, "��׼˫�˼�").split("/")[0];
			String roomNumber = roomNumber1+"/"+roomNumber2;
			System.out.println("������룺"+roomNumber);
			
			System.out.println(service.createOrder(hotelID, clientID, roomType, roomNumber)?"���ɶ����ɹ���":"���ɶ���ʧ�ܣ�");
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	private static void demo6() throws RemoteException {
		
		String clientID = "0000001";
		String hotelID = "00001";
		CreateOrderService service = new CreateOrderServiceImpl();
		
		String type = "��׼��ͥ��";
		String rooms[] = service.getAllRoomNumber(hotelID,type).split("/");
		for(String str:rooms){
			System.out.println(str);
		}//���һ�±�׼��ͥ��ĺ���
		
		String room = rooms[0];
		System.out.println(service.createOrder(hotelID,clientID,type, room)?"���ɶ����ɹ���":"���ɶ���ʧ�ܣ�");
	}

	private static void demo5() throws RemoteException {
	
		//�ͻ�������һ��Ƶ����ɶ���
		String clientID = "0000001";
		String hotelID = "00002";
		CreateOrderService service = new CreateOrderServiceImpl();
		
		String type = "��׼���˼�";
		String rooms[] = service.getAllRoomNumber(hotelID,type).split("/");
		for(String str:rooms){
			System.out.println(str);
		}//���һ�µ��˼�ķ������
		
		String room = rooms[0];
		System.out.println(service.createOrder(hotelID,clientID,type, room)?"���ɶ����ɹ���":"���ɶ���ʧ�ܣ�");
	}

	private static void demo4() throws RemoteException {
		
		//���ͻ������õ����0��ʱ�� ����ʾ���ɶ���ʧ��
		String clientID = "0000002";
		String hotelID = "00001";
		//CreateOrderService service = new CreateOrderServiceImpl();
		 ClientDataRemoteObject service = new ClientDataRemoteObject();
		System.out.println(service.checkCreditPoint(clientID));
	}

	private static void demo3() throws RemoteException {
		
		//�ھƵ�����û�к���Ķ���
		String clientID = "0000001";
		String hotelID = "00001";
	    CreateOrderService service = new CreateOrderServiceImpl();
		
	    String type = "����˫�˼�";
	    String rooms[] = service.getAllRoomNumber(hotelID,type).split("/");
	    System.out.println(rooms[0]);
	    System.out.println(rooms.length);
	    System.out.println(rooms.length==0?"û���ʺϵķ���":"��ѡ�񷿼䣡");
	}

	private static void demo2() throws RemoteException {
		
		//�ھƵ�����һ����������Ķ���
		String clientID = "0000001";
		String hotelID = "00001";
	    CreateOrderService service = new CreateOrderServiceImpl();
		
	    String type = "����˫�˼�";
	    String rooms[] = service.getAllRoomNumber(hotelID,type).split("/");
	    String roomNumber = rooms[0]+"/"+rooms[1];
	    
	    System.out.println(service.checkCreditPoint(clientID)?"����ֵ����0":"����ֵС��0");
	    System.out.println("��ͼ۸�:"+service.getPriceByStrategy(hotelID,clientID,roomNumber));
	    
	    System.out.println(service.createOrder( hotelID,clientID,type, roomNumber)?"���ɶ����ɹ���":"���ɶ���ʧ�ܣ�");
	    
	}

	private static void demo1() throws RemoteException {
		
		//�ھƵ�����һ����һ����Ķ��� 
		String clientID = "0000001";
		String hotelID = "00001";
		CreateOrderService service = new CreateOrderServiceImpl();
		
		String typeAndPrice = service.getRoomTypeAndPrice(hotelID);
		String types [] = typeAndPrice.split("/");
		for(String str:types){
			System.out.println(str.split("[|]")[0]+":"+str.split("[|]")[1]);
		}//�ѷ�����������ͺͼ۸����
		
		String type = types[1].split("[|]")[0];
		String rooms[] = service.getAllRoomNumber(hotelID,type).split("/");
		for(String str:rooms){
			System.out.println(str);//�����еķ������
		}
		
		String room = rooms[0];//ѡ���һ�䷿
		
		System.out.println(service.checkCreditPoint(clientID)?"����ֵ����0":"����ֵС��0");
		double discount = service.getPriceByStrategy(hotelID,clientID,room);
		System.out.println("��ͼ۸�"+discount);
		
		System.out.println(service.createOrder(hotelID,clientID, type, room)?"���ɶ����ɹ���":"���ɶ���ʧ�ܣ�");
		
	}
}
