package uidriver.order;

import java.util.List;

import service.Order.BrowseOrder_webWorker.BrowseOrder_webWorkerService;
import service.Order.BrowseOrder_webWorker.BrowseOrder_webWorkerServiceImpl;
import vo.OrderVO;

public class BrowseOrder_webWorker {

	public static void main(String args[]){
		
		demo1();
	}

	private static void demo1() {
		
		String cientID = "0000001";
		BrowseOrder_webWorkerService service = new BrowseOrder_webWorkerServiceImpl();
		List<OrderVO> volist = service.getAllAbnormalOrders();//得到所有的异常订单并且显示
		for(OrderVO vo:volist){
			show(vo);
		}
		volist = service.getAllUnexecutedOrders();//得到所有的未执行订单并且显示
		for(OrderVO vo:volist){
			show(vo);
		}
		
		volist = service.getClientAbnormalOrders(cientID);
		for(OrderVO vo:volist){
			show(vo);
		}//得到客户的所有异常订单并且显示
		
		String orderID = volist.get(0).getOrderID();
		System.out.println(service.withdrawAbnormalOrder(orderID)?"撤销异常成功！":"撤销异常失败！");
		
	}
	

	private static void show(OrderVO vo){
		
		System.out.println("订单编号："+vo.getOrderID()+"\n"+"客户姓名:"+vo.getClientName()+"\n"+"酒店地址:"+vo.getHotelAddress()+"\n"+
		"订单生成时间:"+vo.getOrderCreatedDate()+"\n"+"预订房间:"+vo.getRoomNumber()+"\n"+"订单状态:"+vo.getOrderStatus()
		+"\n"+"入住日期:"+vo.getOrderBeginDate()+";退房时间："+vo.getOrderEndDate());
		
		System.out.println("客户评论："+vo.getComment());
		System.out.println("------------------------");
		
	}
}
