package service.Order.MyOrder;

import java.text.SimpleDateFormat;
import java.util.Date;
import data.dao.OrderDao;
import data.dao.impl.OrderDaoImpl;
import po.CreditPO;
import po.OrderPO;
import service.Client.ProvidedService.ClientProvidedService;
import service.Client.ProvidedService.ClientProvidedServiceImpl;
import service.Credit.ProvidedService.CreditProvidedService;
import service.Credit.ProvidedService.CreditProvidedServiceImpl;
import service.Order.InteractWithRoom.RoomProvidedServiceForOrder;
import service.Room.ProvidedService.RoomProvidedServiceForOrderImpl;

/**
 * ���������ݲ㽻������ͻ������ã�����ģ����н���
 * ��Ҫ��ɳ�����������ز���
 * @see OrderDao
 * @see ClientProvidedService
 * @see RoomProvidedServiceForOrder
 * */
public class Withdraw {

	private String clientID;
	private OrderDao orderDao;
	private ClientProvidedService clientservice;
	private CreditProvidedService creditservice;
	private RoomProvidedServiceForOrder roomservice;
	
	public Withdraw(String clientID){
		
		this.clientID = clientID;
		orderDao = OrderDaoImpl.getInstance();
		clientservice = new ClientProvidedServiceImpl();
		creditservice = new CreditProvidedServiceImpl();
	    roomservice = new RoomProvidedServiceForOrderImpl();
	}
	
	public boolean withdraw(String orderID){
		
		OrderPO po = orderDao.getOrderPO(orderID);
		
		//���г���֮ǰҪ��ֹ���̸߳պøı䶩����״̬
		String orderStatus = po.getOrderStatus();
		if("�쳣".equals(orderStatus)){
			//����״̬�Ѿ����ı�Ϊ�쳣�ˣ���ô���ܳ�����
			return false;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String withdrawTime = sdf.format(new Date());
		String hotelID = po.getHotelID();
		String roomNumber[] = po.getRoomNumber().split("/");
		po.setWithdrawTime(withdrawTime);
		po.setOrderStatus("�ѳ���");
		if(!orderDao.change(po)){
			return false;
		}//�����ݲ�ĳ־û���������޸�
		
		//����ʱ���������ִ��ʱ�䲻������Сʱ�Ļ�������Ҫ�۳����õ�
		String orderLastDate = po.getOrderLastDate();
		boolean isOutTime  = false;
		Date date1 = null;
		Date date2 = null;
		try{
			date1 = sdf.parse(withdrawTime);//d1��ʾ���ǳ���ʱ��
		    date2 = sdf.parse(orderLastDate);//d2��ʾ������ִ��ʱ��
		    long d1Time = date1.getTime();
		    long d2Time = date2.getTime();//��������ִ��ʱ��Ļ����Զ���δִ�ж���ת��Ϊ�쳣����
		    if(d2Time-d1Time<1000*60*60*6){
		    	//��������ִ��ʱ�䲻��6Сʱ
		    	isOutTime = true;
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
		if(isOutTime){
			//���ʱ��С��6Сʱ�Ļ�
			double price = po.getPrice();
			double point = price/2;//��ʱ���ÿ۳������õ�Ϊprice����2
			clientservice.subClientCreditPoint(clientID, point);//�۳��ͻ����õ�
			
			CreditPO creditpo = new CreditPO();
			creditpo.setTime(withdrawTime);
			creditpo.setClientID(clientID);
			creditpo.setOrderID(po.getOrderID());
			creditpo.setCause("��������");
			String change = "-"+point;
			creditpo.setChange(change);
			if(!creditservice.insertCredit(creditpo)){
				return false;
			}//�������ü�¼
		}
		
		for(int i=0;i<roomNumber.length;i++){
			if(!roomNumber[i].equals("")&&roomNumber[i]!=null){
				//ȡ����Ϊ�յķ����
				if(!roomservice.changeRoomState(hotelID, roomNumber[i], "����")){
					return false;
				}
				if(!roomservice.setBookDate(hotelID, roomNumber[i], "")){
					return false;
				}
			}
		}//�ı䷿��״̬,����Ԥ��ʱ��Ϊ����
		
		return true;
	}
}
