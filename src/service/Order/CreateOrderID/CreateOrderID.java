package service.Order.CreateOrderID;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import data.dao.OrderDao;
import data.dao.impl.OrderDaoImpl;
import po.OrderPO;

public class CreateOrderID {

	/*
	 * ��������ţ���Ź��� ʱ���+��λ�����кţ���0��ʼ��
	 * */
	private OrderDao orderDao;
	
	public CreateOrderID(){
		orderDao = OrderDaoImpl.getInstance();//�����dao��ʵ����
	}
	
	public String nextId(){
		
		synchronized(this){
			
			OrderPO po = new OrderPO();
			
			List<String> allIds = orderDao.getAllIDs();
			String today = new SimpleDateFormat("yyyyMMdd").format(new Date());//�������д
			if(allIds.size()==0){
				//��û�б�ŵĻ�
				po.setOrderID(today+"0001");
				if(!orderDao.insertNewOrder(po)){
					return "";
				}
				return today+"0001";//ֱ�ӷ��ؽ������д+���
			}
			
			List<Integer> allTodayID = new ArrayList<Integer>();
			for(String str:allIds){
				String date = str.substring(0,8);
				if(today.equals(date)){
					//�������ж�����,�ҵ����н���Ķ�����
					allTodayID.add(Integer.valueOf(str.substring(8)));//�ѽ����id��¼����
				}
			}
			
			if(allTodayID.size()==0){
				//����û�ж���
				po.setOrderID(today+"0001");
				if(!orderDao.insertNewOrder(po)){
					return "";
				}
				return today+"0001";
			}
			
			int max = 0;
			for(int i:allTodayID){
				if(i>max){
					max=i;
				}
			}//�ҳ����ֵ�����ǽ������󶩵���
			
			if(max==9999){
				return "";//�����Ŵﵽ������
			}else{
				int value = max+1;
				po.setOrderID(today+value);
				if(!orderDao.insertNewOrder(po)){
					return "";
				}
				return today+value;
			}
		}
	}
}
