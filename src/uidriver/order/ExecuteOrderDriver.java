package uidriver.order;

import java.rmi.RemoteException;
import java.util.List;

import rmi.HotelWorkerDataRemoteObject;
import service.Order.ExecuteOrder.ExecuteOrderService;
import service.Order.ExecuteOrder.ExecuteOrderServiceImpl;
import vo.OrderVO;

public class ExecuteOrderDriver {

	public static void main(String args[]) throws RemoteException{
		
		//demo1();
		//demo2();
		demo3();
		//demo4();
	}

	private static void demo3() {
		
		//客户在正常时间内进行入住 两个订单一起执行
		String clientID = "0000001";
		String hotelID = "00001";
		HotelWorkerDataRemoteObject service;
		try {
			service = new HotelWorkerDataRemoteObject();
           
			List<OrderVO> volist = service.getUnexecutedOrders(hotelID, clientID);
			for(OrderVO vo:volist){
				//首先得到客户的在酒店的所有未执行订单
				show(vo);
			}
			
			String orderID = volist.get(0).getOrderID();
			
			System.out.println(service.getAllRoomType(orderID,hotelID));//把客户的所有房间类型展示
			System.out.println(service.getAllRoomNumber(orderID,hotelID));//把房间号展示
			
			String roomNumber[] = service.getAllRoomNumber(orderID,hotelID).split("/");
			for(int i=0;i<roomNumber.length;i++){
				//有人入住
			    service.setRoomPeople(roomNumber[i], i+1);//设置入住人数
			    service.setRoomChild(roomNumber[i], false);//设置有无儿童
			}
			
			System.out.println(service.executeOrder()?"订单1执行成功！":"订单执行失败！");
			
			orderID = volist.get(1).getOrderID();
			System.out.println(service.getAllRoomType(orderID,hotelID));//把客户的所有房间类型展示
			System.out.println(service.getAllRoomNumber(orderID,hotelID));//把房间号展示
			
			 roomNumber = service.getAllRoomNumber(orderID,hotelID).split("/");
			for(int i=0;i<roomNumber.length;i++){
				//有人入住
			    service.setRoomPeople(roomNumber[i], i+1);//设置入住人数
			    service.setRoomChild(roomNumber[i], false);//设置有无儿童
			}
			
			System.out.println(service.executeOrder()?"订单2执行成功！":"订单执行失败！");
			
		
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	private static void demo2() {
		
		//客户延迟入住
		String clientID = "0000001";
		String hotelID = "00001";
	}

	private static void demo1() throws RemoteException {
	
		//客户在正常时间内进行入住
		String clientID = "0000001";
		String hotelID = "00001";
		ExecuteOrderService service = new ExecuteOrderServiceImpl();
		List<OrderVO> volist = service.getUnexecutedOrders(hotelID, clientID);//首先得到客户的在酒店的所有未执行订单
		for(OrderVO vo:volist){
			show(vo);
		}
		//客户选择其中的一个订单
		String orderID = volist.get(0).getOrderID();
		
		System.out.println(service.getAllRoomType(orderID,hotelID));//把客户的所有房间类型展示
		System.out.println(service.getAllRoomNumber(orderID,hotelID));//把房间号展示
		
		String roomNumber[] = service.getAllRoomNumber(orderID,hotelID).split("/");
		for(int i=0;i<roomNumber.length;i++){
			//有人入住
		    service.setRoomPeople(roomNumber[i], i+1);//设置入住人数
		    service.setRoomChild(roomNumber[i], false);//设置有无儿童
		}
		
		System.out.println(service.executeOrder()?"订单执行成功！":"订单执行失败！");
	}
	
	private static void show(OrderVO vo){
		
		System.out.println("订单编号："+vo.getOrderID()+"\n"+"客户姓名:"+vo.getClientName()+"\n"+"酒店地址:"+vo.getHotelAddress()+"\n"+
		"订单生成时间:"+vo.getOrderCreatedDate()+"\n"+"预订房间:"+vo.getRoomNumber()+"\n"+"订单状态:"+vo.getOrderStatus()
		+"\n"+"入住日期:"+vo.getOrderBeginDate()+";退房时间："+vo.getOrderEndDate());
		System.out.println("退房数目："+vo.getCheckOutTotal());
		System.out.println("------------------------");
	}
}
