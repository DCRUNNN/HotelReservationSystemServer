package uidriver.order;

import java.rmi.RemoteException;
import java.util.List;

import service.Order.MyOrder.MyOrderService;
import service.Order.MyOrder.MyOrderServiceImpl;
import service.Order.Thread.ChangeToAbnormal;
import vo.OrderVO;

public class ThreadDriver {

	public static void main(String args[]) throws RemoteException{

		Thread t1 = new Thread(new ChangeToAbnormal());
		t1.start();
		demo1();
		
	}
	

	private static void demo1() throws RemoteException {
		
		//对0000001客户的订单进行查看
		String clientID = "0000001";
		MyOrderService service = new MyOrderServiceImpl();
		List<OrderVO> volist = service.getAbnormalOrders(clientID);
		System.out.println(volist.size()==0?"暂时没有异常订单":"存在异常订单");
		volist = service.getUnexecutedOrders(clientID);
		System.out.println(volist.size()==0?"暂时没有未执行订单":"存在未执行订单");
		volist = service.getWithdrawnOrders(clientID);
		System.out.println(volist.size()==0?"暂时没有已撤销订单":"存在已撤销订单");
		volist = service.getExecutedOrders(clientID);
		for(OrderVO vo:volist){
			show(vo);
		}
	}
	

	private static void show(OrderVO vo){
		
		System.out.println("订单编号："+vo.getOrderID()+"\n"+"客户姓名:"+vo.getClientName()+"\n"+"酒店地址:"+vo.getHotelAddress()+"\n"+
		"订单生成时间:"+vo.getOrderCreatedDate()+"\n"+"预订房间:"+vo.getRoomNumber()+"\n"+"订单状态:"+vo.getOrderStatus()
		+"\n"+"入住日期:"+vo.getOrderBeginDate()+";退房时间："+vo.getOrderEndDate());
		
		System.out.println("客户评论："+vo.getComment());
		System.out.println("------------------------");
		
	}
}
