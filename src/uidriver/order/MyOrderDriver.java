package uidriver.order;

import java.rmi.RemoteException;
import java.util.List;

import service.Order.MyOrder.MyOrderService;
import service.Order.MyOrder.MyOrderServiceImpl;
import vo.OrderVO;

public class MyOrderDriver {

	public static void main(String args[]) throws RemoteException{
		
		demo1();
		//demo2();
	}

	private static void demo1() throws RemoteException {
		
		//��0000001�ͻ��Ķ������в鿴
		String clientID = "0000001";
		MyOrderService service = new MyOrderServiceImpl();
		List<OrderVO> volist = service.getAbnormalOrders(clientID);
		System.out.println(volist.size()==0?"��ʱû���쳣����":"�����쳣����");
		volist = service.getUnexecutedOrders(clientID);
		System.out.println(volist.size()==0?"��ʱû��δִ�ж���":"����δִ�ж���");
		volist = service.getWithdrawnOrders(clientID);
		System.out.println(volist.size()==0?"��ʱû���ѳ�������":"�����ѳ�������");
		volist = service.getExecutedOrders(clientID);
		for(OrderVO vo:volist){
			show(vo);
		}
	}

	private static void demo2() throws RemoteException {
		
		//��0000001��δִ�ж������г���
		String clientID = "0000001";
		MyOrderService service = new MyOrderServiceImpl();
		List<OrderVO> volist = service.getUnexecutedOrders(clientID);
		if(volist.size()==0){
			System.out.println("��ʱû��δִ�ж�����");
			System.exit(0);
		}
		
		String orderID = volist.get(0).getOrderID();
		System.out.println(service.withdraw(clientID, orderID)?"���������ɹ�!":"��������ʧ�ܣ�");
	}
	
	private static void show(OrderVO vo){
		
		System.out.println("������ţ�"+vo.getOrderID()+"\n"+"�ͻ�����:"+vo.getClientName()+"\n"+"�Ƶ��ַ:"+vo.getHotelAddress()+"\n"+
		"��������ʱ��:"+vo.getOrderCreatedDate()+"\n"+"Ԥ������:"+vo.getRoomNumber()+"\n"+"����״̬:"+vo.getOrderStatus()
		+"\n"+"��ס����:"+vo.getOrderBeginDate()+";�˷�ʱ�䣺"+vo.getOrderEndDate());
		
		System.out.println("�ͻ����ۣ�"+vo.getComment());
		System.out.println("------------------------");
		
	}
}
