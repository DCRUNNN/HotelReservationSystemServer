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
		
		System.out.println("������ţ�"+vo.getOrderID()+"\n"+"�ͻ�����:"+vo.getClientName()+"\n"+"�Ƶ��ַ:"+vo.getHotelAddress()+"\n"+
		"��������ʱ��:"+vo.getOrderCreatedDate()+"\n"+"Ԥ������:"+vo.getRoomNumber()+"\n"+"����״̬:"+vo.getOrderStatus()
		+"\n"+"��ס����:"+vo.getOrderBeginDate()+";�˷�ʱ�䣺"+vo.getOrderEndDate());
	}
}
