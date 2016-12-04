package uidriver.order;

import java.rmi.RemoteException;

import service.Order.EvaluateOrder.EvaluateOrderService;
import service.Order.EvaluateOrder.EvaluateOrderServiceImpl;

public class EvaluateOrderDriver {

	public static void main(String args[]) throws RemoteException{
		
		demo1();
		demo2();
		demo3();
		demo4();
	}

	private static void demo4() throws RemoteException {
		
		//对订单201612020001追加评论
		String orderID = "201612020001";
		EvaluateOrderService service = new EvaluateOrderServiceImpl();
		String comment = "追加酒店工作人员的服务态度很不错！";
		System.out.println(service.addExtraComment(orderID,comment)?"追加评论成功！":"评论失败！");
	}

	private static void demo3() throws RemoteException {
		
		//对订单编号为“201612020004”De订单进行评价
		String orderID = "201612020004";
		EvaluateOrderService service = new EvaluateOrderServiceImpl();
		String comment = "酒店服务不错，就是不能打电话!";
		int ps = 3;
		int psur = 3;
		int pf = 2;
		System.out.println(service.addComment(orderID,comment, pf, ps, psur)?"评论成功！":"评论失败！");
	}

	private static void demo2() throws RemoteException {
		
		//对订单编号为"201612020002"的订单进行评价
		String orderID = "201612020002";
		EvaluateOrderService service = new EvaluateOrderServiceImpl();
		String comment = "双人间很不错，就是少了个女朋友！";
		int ps = 3;
		int psur = 2;
		int pf = 1;
		System.out.println(service.addComment(orderID,comment, pf, ps, psur)?"评论成功！":"评论失败！");
	}

	private static void demo1() throws RemoteException {
		
		//对订单编号位"201612020001"的订单进行评价
		String orderID = "201612020001";
		EvaluateOrderService service = new EvaluateOrderServiceImpl();
		String comment = "酒店服务还行吧，就是感觉少了点什么!";
		int ps = 4;
		int psur = 5;
		int pf = 4;
		System.out.println(service.addComment(orderID,comment, pf, ps, psur)?"评论成功！":"评论失败！");
		
	}
}
