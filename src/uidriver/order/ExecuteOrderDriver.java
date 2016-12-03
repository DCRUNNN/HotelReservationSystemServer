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
		
		//�ͻ��ӳ���ס
		String clientID = "0000001";
		String hotelID = "00001";
	}

	private static void demo1() {
	
		//�ͻ�������ʱ���ڽ�����ס
		String clientID = "0000001";
		String hotelID = "00001";
		ExecuteOrderService service = new ExecuteOrderServiceImpl(hotelID);
		List<OrderVO> volist = service.getUnexecutedOrders(clientID);//���ȵõ��ͻ����ھƵ������δִ�ж���
		for(OrderVO vo:volist){
			show(vo);
		}
		//�ͻ�ѡ�����е�һ������
		String orderID = volist.get(0).getOrderID();
		
		System.out.println(service.getAllRoomType(orderID));//�ѿͻ������з�������չʾ
		System.out.println(service.getAllRoomNumber(orderID));//�ѷ����չʾ
		
		String roomNumber[] = service.getAllRoomNumber(orderID).split("/");
		for(int i=0;i<roomNumber.length;i++){
			//������ס
		    service.setRoomPeople(roomNumber[i], i+1);//������ס����
		    service.setRoomChild(roomNumber[i], false);//�������޶�ͯ
		}
		
		System.out.println(service.executeOrder()?"����ִ�гɹ���":"����ִ��ʧ�ܣ�");
	}
	
	private static void show(OrderVO vo){
		
		System.out.println("������ţ�"+vo.getOrderID()+"\n"+"�ͻ�����:"+vo.getClientName()+"\n"+"�Ƶ��ַ:"+vo.getHotelAddress()+"\n"+
		"��������ʱ��:"+vo.getOrderCreatedDate()+"\n"+"Ԥ������:"+vo.getRoomNumber()+"\n"+"����״̬:"+vo.getOrderStatus()
		+"\n"+"��ס����:"+vo.getOrderBeginDate()+";�˷�ʱ�䣺"+vo.getOrderEndDate());
	}
}
