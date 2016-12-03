package uidriver.order;

import java.util.List;

import service.Order.BrowseOrder_hotelWorker.BrowseOrder_hotelWorkerService;
import service.Order.BrowseOrder_hotelWorker.BrowseOrder_hotelWorkerServiceImpl;
import vo.OrderVO;

public class BrowseOrder_hotelWorkerDriver {

	public static void main(String args[]){
		
		demo1();
	}

	private static void demo1() {
		
		String hotelID = "00001";
		BrowseOrder_hotelWorkerService service = new BrowseOrder_hotelWorkerServiceImpl(hotelID);
		
		List<OrderVO> volist = service.getExecutedOrders();
		for(OrderVO vo:volist){
			show(vo);
		}
	}

	private static void show(OrderVO vo){
		
		System.out.println("订单编号："+vo.getOrderID()+"\n"+"客户姓名:"+vo.getClientName()+"\n"+"酒店地址:"+vo.getHotelAddress()+"\n"+
		"订单生成时间:"+vo.getOrderCreatedDate()+"\n"+"预订房间:"+vo.getRoomNumber()+"\n"+"订单状态:"+vo.getOrderStatus()
		+"\n"+"入住日期:"+vo.getOrderBeginDate()+";退房时间："+vo.getOrderEndDate());
	}
}
