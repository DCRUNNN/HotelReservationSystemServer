package uidriver.order;

import service.Order.CreateOrder.CreateOrderService;
import service.Order.CreateOrder.CreateOrderServiceImpl;

// ok

public class CreateOrderDriver {

	public static void main(String args[]){
		
	    demo1();
	    demo2();
	    demo3();
		demo4();
		demo5();
		demo6();
	}

	private static void demo6() {
		
		String clientID = "0000001";
		String hotelID = "00001";
		CreateOrderService service = new CreateOrderServiceImpl(clientID,hotelID);
		
		String type = "��׼��ͥ��";
		String rooms[] = service.getAllRoomNumber(type).split("/");
		for(String str:rooms){
			System.out.println(str);
		}//���һ�±�׼��ͥ��ĺ���
		
		String room = rooms[0];
		System.out.println(service.createOrder(type, room)?"���ɶ����ɹ���":"���ɶ���ʧ�ܣ�");
	}

	private static void demo5() {
	
		//�ͻ�������һ��Ƶ����ɶ���
		String clientID = "0000001";
		String hotelID = "00002";
		CreateOrderService service = new CreateOrderServiceImpl(clientID,hotelID);
		
		String type = "��׼���˼�";
		String rooms[] = service.getAllRoomNumber(type).split("/");
		for(String str:rooms){
			System.out.println(str);
		}//���һ�µ��˼�ķ������
		
		String room = rooms[0];
		System.out.println(service.createOrder(type, room)?"���ɶ����ɹ���":"���ɶ���ʧ�ܣ�");
	}

	private static void demo4() {
		
		//���ͻ������õ����0��ʱ�� ����ʾ���ɶ���ʧ��
		String clientID = "0000002";
		String hotelID = "00001";
		CreateOrderService service = new CreateOrderServiceImpl(clientID,hotelID);
		
		System.out.println(service.checkCreditPoint());
	}

	private static void demo3() {
		
		//�ھƵ�����û�к���Ķ���
		String clientID = "0000001";
		String hotelID = "00001";
	    CreateOrderService service = new CreateOrderServiceImpl(clientID,hotelID);
		
	    String type = "����˫�˼�";
	    String rooms[] = service.getAllRoomNumber(type).split("/");
	    System.out.println(rooms[0]);
	    System.out.println(rooms.length);
	    System.out.println(rooms.length==0?"û���ʺϵķ���":"��ѡ�񷿼䣡");
	}

	private static void demo2() {
		
		//�ھƵ�����һ����������Ķ���
		String clientID = "0000001";
		String hotelID = "00001";
	    CreateOrderService service = new CreateOrderServiceImpl(clientID,hotelID);
		
	    String type = "����˫�˼�";
	    String rooms[] = service.getAllRoomNumber(type).split("/");
	    String roomNumber = rooms[0]+"/"+rooms[1];
	    
	    System.out.println(service.checkCreditPoint()?"����ֵ����0":"����ֵС��0");
	    System.out.println("��ͼ۸�:"+service.getPriceByStrategy(roomNumber));
	    
	    System.out.println(service.createOrder( type, roomNumber)?"���ɶ����ɹ���":"���ɶ���ʧ�ܣ�");
	    
	}

	private static void demo1() {
		
		//�ھƵ�����һ����һ����Ķ��� 
		String clientID = "0000001";
		String hotelID = "00001";
		CreateOrderService service = new CreateOrderServiceImpl(clientID, hotelID);
		
		String typeAndPrice = service.getRoomTypeAndPrice();
		String types [] = typeAndPrice.split("/");
		for(String str:types){
			System.out.println(str.split("[|]")[0]+":"+str.split("[|]")[1]);
		}//�ѷ�����������ͺͼ۸����
		
		String type = types[1].split("[|]")[0];
		String rooms[] = service.getAllRoomNumber(type).split("/");
		for(String str:rooms){
			System.out.println(str);//�����еķ������
		}
		
		String room = rooms[0];//ѡ���һ�䷿
		
		System.out.println(service.checkCreditPoint()?"����ֵ����0":"����ֵС��0");
		double discount = service.getPriceByStrategy(room);
		System.out.println("��ͼ۸�"+discount);
		
		System.out.println(service.createOrder( type, room)?"���ɶ����ɹ���":"���ɶ���ʧ�ܣ�");
		
	}
}
