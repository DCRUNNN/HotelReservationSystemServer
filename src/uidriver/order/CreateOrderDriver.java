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
		
		//客户生成一个房间的订单
		String clientID = "0000001";
		String hotelID ="00001";
		try {
			ClientDataRemoteObject service = new ClientDataRemoteObject();
			String roomType = "标准家庭间";
			String roomNumber = service.getAllRoomNumber(hotelID, roomType).split("/")[0];
			System.out.println(service.createOrder(hotelID, clientID, roomType, roomNumber)?"生成订单成功！":"生成订单失败！");
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		
	}

	private static void demo7() {
		
		//客户生成两个房间的订单
		String clientID = "0000001";
		String hotelID = "00001";
		try {
			ClientDataRemoteObject service = new ClientDataRemoteObject();
			System.out.println(service.getRoomTypeAndPrice(hotelID));
			String roomType = "标准单人间/标准双人间";
			String roomNumber1 = service.getAllRoomNumber(hotelID, "标准单人间").split("/")[0];
			String roomNumber2 = service.getAllRoomNumber(hotelID, "标准双人间").split("/")[0];
			String roomNumber = roomNumber1+"/"+roomNumber2;
			System.out.println("房间号码："+roomNumber);
			
			System.out.println(service.createOrder(hotelID, clientID, roomType, roomNumber)?"生成订单成功！":"生成订单失败！");
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	private static void demo6() throws RemoteException {
		
		String clientID = "0000001";
		String hotelID = "00001";
		CreateOrderService service = new CreateOrderServiceImpl();
		
		String type = "标准家庭间";
		String rooms[] = service.getAllRoomNumber(hotelID,type).split("/");
		for(String str:rooms){
			System.out.println(str);
		}//输出一下标准家庭间的号码
		
		String room = rooms[0];
		System.out.println(service.createOrder(hotelID,clientID,type, room)?"生成订单成功！":"生成订单失败！");
	}

	private static void demo5() throws RemoteException {
	
		//客户在另外一间酒店生成订单
		String clientID = "0000001";
		String hotelID = "00002";
		CreateOrderService service = new CreateOrderServiceImpl();
		
		String type = "标准单人间";
		String rooms[] = service.getAllRoomNumber(hotelID,type).split("/");
		for(String str:rooms){
			System.out.println(str);
		}//输出一下单人间的房间号码
		
		String room = rooms[0];
		System.out.println(service.createOrder(hotelID,clientID,type, room)?"生成订单成功！":"生成订单失败！");
	}

	private static void demo4() throws RemoteException {
		
		//当客户的信用点低于0的时候 会提示生成订单失败
		String clientID = "0000002";
		String hotelID = "00001";
		//CreateOrderService service = new CreateOrderServiceImpl();
		 ClientDataRemoteObject service = new ClientDataRemoteObject();
		System.out.println(service.checkCreditPoint(clientID));
	}

	private static void demo3() throws RemoteException {
		
		//在酒店生成没有号码的订单
		String clientID = "0000001";
		String hotelID = "00001";
	    CreateOrderService service = new CreateOrderServiceImpl();
		
	    String type = "豪华双人间";
	    String rooms[] = service.getAllRoomNumber(hotelID,type).split("/");
	    System.out.println(rooms[0]);
	    System.out.println(rooms.length);
	    System.out.println(rooms.length==0?"没有适合的房间":"请选择房间！");
	}

	private static void demo2() throws RemoteException {
		
		//在酒店生成一个两个房间的订单
		String clientID = "0000001";
		String hotelID = "00001";
	    CreateOrderService service = new CreateOrderServiceImpl();
		
	    String type = "豪华双人间";
	    String rooms[] = service.getAllRoomNumber(hotelID,type).split("/");
	    String roomNumber = rooms[0]+"/"+rooms[1];
	    
	    System.out.println(service.checkCreditPoint(clientID)?"信用值大于0":"信用值小于0");
	    System.out.println("最低价格:"+service.getPriceByStrategy(hotelID,clientID,roomNumber));
	    
	    System.out.println(service.createOrder( hotelID,clientID,type, roomNumber)?"生成订单成功！":"生成订单失败！");
	    
	}

	private static void demo1() throws RemoteException {
		
		//在酒店生成一个单一房间的订单 
		String clientID = "0000001";
		String hotelID = "00001";
		CreateOrderService service = new CreateOrderServiceImpl();
		
		String typeAndPrice = service.getRoomTypeAndPrice(hotelID);
		String types [] = typeAndPrice.split("/");
		for(String str:types){
			System.out.println(str.split("[|]")[0]+":"+str.split("[|]")[1]);
		}//把房间的所有类型和价格输出
		
		String type = types[1].split("[|]")[0];
		String rooms[] = service.getAllRoomNumber(hotelID,type).split("/");
		for(String str:rooms){
			System.out.println(str);//把所有的房间输出
		}
		
		String room = rooms[0];//选择第一间房
		
		System.out.println(service.checkCreditPoint(clientID)?"信用值大于0":"信用值小于0");
		double discount = service.getPriceByStrategy(hotelID,clientID,room);
		System.out.println("最低价格："+discount);
		
		System.out.println(service.createOrder(hotelID,clientID, type, room)?"生成订单成功！":"生成订单失败！");
		
	}
}
