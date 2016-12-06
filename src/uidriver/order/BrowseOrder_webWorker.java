package uidriver.order;

import java.rmi.RemoteException;
import java.util.List;

import rmi.WebSalerDataRemoteObject;
import service.Order.BrowseOrder_webWorker.BrowseOrder_webWorkerService;
import service.Order.BrowseOrder_webWorker.BrowseOrder_webWorkerServiceImpl;
import vo.OrderVO;

public class BrowseOrder_webWorker {

	public static void main(String args[]) throws RemoteException{
		
		demo1();
	}

	private static void demo1() throws RemoteException {
		
		String cientID = "0000001";
		//BrowseOrder_webWorkerService service = new BrowseOrder_webWorkerServiceImpl();
		WebSalerDataRemoteObject service = new WebSalerDataRemoteObject();
		
		List<OrderVO> volist = service.getAllAbnormalOrders();//�õ����е��쳣����������ʾ
		for(OrderVO vo:volist){
			show(vo);
		}
		volist = service.getAllUnexecutedOrders();//�õ����е�δִ�ж���������ʾ
		for(OrderVO vo:volist){
			show(vo);
		}
		
		volist = service.getClientAbnormalOrders(cientID);
		for(OrderVO vo:volist){
			show(vo);
		}//�õ��ͻ��������쳣����������ʾ
		
		//String orderID = volist.get(0).getOrderID();
		//System.out.println(service.withdrawAbnormalOrder(orderID)?"�����쳣�ɹ���":"�����쳣ʧ�ܣ�");
		
	}
	

	private static void show(OrderVO vo){
		
		System.out.println("������ţ�"+vo.getOrderID()+"\n"+"�ͻ�����:"+vo.getClientName()+"\n"+"�Ƶ��ַ:"+vo.getHotelAddress()+"\n"+
		"��������ʱ��:"+vo.getOrderCreatedDate()+"\n"+"Ԥ������:"+vo.getRoomNumber()+"\n"+"����״̬:"+vo.getOrderStatus()
		+"\n"+"��ס����:"+vo.getOrderBeginDate()+";�˷�ʱ�䣺"+vo.getOrderEndDate());
		
		System.out.println("�ͻ����ۣ�"+vo.getComment());
		System.out.println("------------------------");
		
	}
}
