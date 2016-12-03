package uidriver.order;

import service.Order.EvaluateOrder.EvaluateOrderService;
import service.Order.EvaluateOrder.EvaluateOrderServiceImpl;

public class EvaluateOrderDriver {

	public static void main(String args[]){
		
		demo1();
		demo2();
		demo3();
		demo4();
	}

	private static void demo4() {
		
		//�Զ���201612020001׷������
		String orderID = "201612020001";
		EvaluateOrderService service = new EvaluateOrderServiceImpl(orderID);
		String comment = "׷�ӾƵ깤����Ա�ķ���̬�Ⱥܲ���";
		System.out.println(service.addExtraComment(comment)?"׷�����۳ɹ���":"����ʧ�ܣ�");
	}

	private static void demo3() {
		
		//�Զ������Ϊ��201612020004��De������������
		String orderID = "201612020004";
		EvaluateOrderService service = new EvaluateOrderServiceImpl(orderID);
		String comment = "�Ƶ���񲻴����ǲ��ܴ�绰!";
		int ps = 3;
		int psur = 3;
		int pf = 2;
		System.out.println(service.addComment(comment, pf, ps, psur)?"���۳ɹ���":"����ʧ�ܣ�");
	}

	private static void demo2() {
		
		//�Զ������Ϊ"201612020002"�Ķ�����������
		String orderID = "201612020002";
		EvaluateOrderService service = new EvaluateOrderServiceImpl(orderID);
		String comment = "˫�˼�ܲ����������˸�Ů���ѣ�";
		int ps = 3;
		int psur = 2;
		int pf = 1;
		System.out.println(service.addComment(comment, pf, ps, psur)?"���۳ɹ���":"����ʧ�ܣ�");
	}

	private static void demo1() {
		
		//�Զ������λ"201612020001"�Ķ�����������
		String orderID = "201612020001";
		EvaluateOrderService service = new EvaluateOrderServiceImpl(orderID);
		String comment = "�Ƶ�����аɣ����Ǹо����˵�ʲô!";
		int ps = 4;
		int psur = 5;
		int pf = 4;
		System.out.println(service.addComment(comment, pf, ps, psur)?"���۳ɹ���":"����ʧ�ܣ�");
		
	}
}
