package uidriver.order;

import java.util.List;

import service.Order.MyOrder.MyOrderService;
import service.Order.MyOrder.MyOrderServiceImpl;
import service.Order.Thread.ChangeToAbnormal;
import vo.OrderVO;

public class ThreadDriver {

	public static void main(String args[]){

		Thread t1 = new Thread(new ChangeToAbnormal());
		t1.start();
		demo1();
		
	}
	

	private static void demo1() {
		
		//��0000001�ͻ��Ķ������в鿴
		String clientID = "0000001";
		MyOrderService service = new MyOrderServiceImpl(clientID);
		List<OrderVO> volist = service.getAbnormalOrders();
		System.out.println(volist.size()==0?"��ʱû���쳣����":"�����쳣����");
		volist = service.getUnexecutedOrders();
		System.out.println(volist.size()==0?"��ʱû��δִ�ж���":"����δִ�ж���");
		volist = service.getWithdrawnOrders();
		System.out.println(volist.size()==0?"��ʱû���ѳ�������":"�����ѳ�������");
		volist = service.getExecutedOrders();
		for(OrderVO vo:volist){
			show(vo);
		}
	}
	

	private static void show(OrderVO vo){
		
		System.out.println("������ţ�"+vo.getOrderID()+"\n"+"�ͻ�����:"+vo.getClientName()+"\n"+"�Ƶ��ַ:"+vo.getHotelAddress()+"\n"+
		"��������ʱ��:"+vo.getOrderCreatedDate()+"\n"+"Ԥ������:"+vo.getRoomNumber()+"\n"+"����״̬:"+vo.getOrderStatus()
		+"\n"+"��ס����:"+vo.getOrderBeginDate()+";�˷�ʱ�䣺"+vo.getOrderEndDate());
		
		System.out.println("�ͻ����ۣ�"+vo.getComment());
		System.out.println("------------------------");
		
	}
}