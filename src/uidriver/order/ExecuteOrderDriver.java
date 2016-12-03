package uidriver.order;

import java.util.List;

import service.Order.ExecuteOrder.ExecuteOrderService;
import service.Order.ExecuteOrder.ExecuteOrderServiceImpl;
import vo.OrderVO;

public class ExecuteOrderDriver {

	public static void main(String args[]){
		
		demo1();
		demo2();
	}

	private static void demo2() {
		
		//客户延迟入住
		String clientID = "0000001";
		String hotelID = "00001";
	}

	private static void demo1() {
	
		//客户在正常时间内进行入住
		String clientID = "0000001";
		String hotelID = "00001";
		ExecuteOrderService service = new ExecuteOrderServiceImpl(hotelID);
		List<OrderVO> volist = service.getUnexecutedOrders(clientID);//首先得到客户的在酒店的所有未执行订单
		for(OrderVO vo:volist){
			show(vo);
		}
		//客户选择其中的一个订单
		String orderID = volist.get(0).getOrderID();
		
		System.out.println(service.getAllRoomType(orderID));//把客户的所有房间类型展示
		System.out.println(service.getAllRoomNumber(orderID));//把房间号展示
		
		String roomNumber[] = service.getAllRoomNumber(orderID).split("/");
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
	}
}
