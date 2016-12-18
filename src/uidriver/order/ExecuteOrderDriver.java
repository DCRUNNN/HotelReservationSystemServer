package uidriver.order;

import java.rmi.RemoteException;
import java.util.List;

import rmi.HotelWorkerDataRemoteObject;
import service.Order.ExecuteOrder.ExecuteOrderService;
import service.Order.ExecuteOrder.ExecuteOrderServiceImpl;
import vo.OrderVO;

public class ExecuteOrderDriver {

	public static void main(String args[]) throws RemoteException{
		
		//demo1();
		//demo2();
		demo3();
		//demo4();
	}

	private static void demo3() {
		
		//�ͻ�������ʱ���ڽ�����ס ��������һ��ִ��
		String clientID = "0000001";
		String hotelID = "00001";
		HotelWorkerDataRemoteObject service;
		try {
			service = new HotelWorkerDataRemoteObject();
           
			List<OrderVO> volist = service.getUnexecutedOrders(hotelID, clientID);
			for(OrderVO vo:volist){
				//���ȵõ��ͻ����ھƵ������δִ�ж���
				show(vo);
			}
			
			String orderID = volist.get(0).getOrderID();
			
			System.out.println(service.getAllRoomType(orderID,hotelID));//�ѿͻ������з�������չʾ
			System.out.println(service.getAllRoomNumber(orderID,hotelID));//�ѷ����չʾ
			
			String roomNumber[] = service.getAllRoomNumber(orderID,hotelID).split("/");
			for(int i=0;i<roomNumber.length;i++){
				//������ס
			    service.setRoomPeople(roomNumber[i], i+1);//������ס����
			    service.setRoomChild(roomNumber[i], false);//�������޶�ͯ
			}
			
			System.out.println(service.executeOrder()?"����1ִ�гɹ���":"����ִ��ʧ�ܣ�");
			
			orderID = volist.get(1).getOrderID();
			System.out.println(service.getAllRoomType(orderID,hotelID));//�ѿͻ������з�������չʾ
			System.out.println(service.getAllRoomNumber(orderID,hotelID));//�ѷ����չʾ
			
			 roomNumber = service.getAllRoomNumber(orderID,hotelID).split("/");
			for(int i=0;i<roomNumber.length;i++){
				//������ס
			    service.setRoomPeople(roomNumber[i], i+1);//������ס����
			    service.setRoomChild(roomNumber[i], false);//�������޶�ͯ
			}
			
			System.out.println(service.executeOrder()?"����2ִ�гɹ���":"����ִ��ʧ�ܣ�");
			
		
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	private static void demo2() {
		
		//�ͻ��ӳ���ס
		String clientID = "0000001";
		String hotelID = "00001";
	}

	private static void demo1() throws RemoteException {
	
		//�ͻ�������ʱ���ڽ�����ס
		String clientID = "0000001";
		String hotelID = "00001";
		ExecuteOrderService service = new ExecuteOrderServiceImpl();
		List<OrderVO> volist = service.getUnexecutedOrders(hotelID, clientID);//���ȵõ��ͻ����ھƵ������δִ�ж���
		for(OrderVO vo:volist){
			show(vo);
		}
		//�ͻ�ѡ�����е�һ������
		String orderID = volist.get(0).getOrderID();
		
		System.out.println(service.getAllRoomType(orderID,hotelID));//�ѿͻ������з�������չʾ
		System.out.println(service.getAllRoomNumber(orderID,hotelID));//�ѷ����չʾ
		
		String roomNumber[] = service.getAllRoomNumber(orderID,hotelID).split("/");
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
		System.out.println("�˷���Ŀ��"+vo.getCheckOutTotal());
		System.out.println("------------------------");
	}
}
