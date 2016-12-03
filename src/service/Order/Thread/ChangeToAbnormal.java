package service.Order.Thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
 * һ���̣߳������ڶ�����������ִ��ʱ���ʱ��Ѷ�����״̬�ı�Ϊ�쳣����
 * */
public class ChangeToAbnormal implements Runnable{
	
	@Override
	public void run() {
		
		OrderDao orderDao;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		
		while(true){
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}//ÿһ��ִ��һ���߳� ����cpu�ĸ���
			
			orderDao = OrderDaoImpl.getInstance();//���orderDaoʵ��
			List<OrderPO> allorders = orderDao.getAllOrders();
			for(OrderPO po:allorders){
				if("δִ��".equals(po.getOrderStatus())){
					
					String orderLastDate = po.getOrderLastDate();
					//System.out.println(po.getOrderLastDate());
					boolean isOutTime = false;
					try{
						Date LastDate = sdf.parse(orderLastDate);//��������ִ��ʱ��
						long lastTime = LastDate.getTime();//����ִ��ʱ��غ�����
						long currentTime = new Date().getTime();//��ǰʱ��غ�����
						if(lastTime<currentTime){
							isOutTime = true;
						}
					}catch(Exception e){
						e.printStackTrace();
					}
					
					if(isOutTime){//������ʱ
						po.setOrderStatus("�쳣");
						orderDao.change(po);//�ı䶩��״̬
						
						double point = po.getPrice()/2;//���ٿͻ������۸�һ������õ�
						String clientID = po.getClientID();
						ClientProvidedService clientservice = new ClientProvidedServiceImpl();
						clientservice.subClientCreditPoint(clientID, point);//����˼��ٿͻ�����ֵ
						
						CreditPO creditpo = new CreditPO();
						creditpo.setCause("�����쳣");
						creditpo.setChange("-"+point);
						creditpo.setClientID(po.getClientID());
						creditpo.setOrderID(po.getOrderID());
						creditpo.setTime(sdf.format(new Date()));
						CreditProvidedService creditservice = new CreditProvidedServiceImpl();
						creditservice.insertCredit(creditpo);//��������ü�¼������
						
						String roomNumber = po.getRoomNumber();
						String rooms[] = roomNumber.split("/");
						String hotelID = po.getHotelID();
						RoomProvidedServiceForOrder roomservice = new RoomProvidedServiceForOrderImpl();
						for(String str:rooms){
							roomservice.changeRoomState(hotelID, str, "����");
							roomservice.setBookDate(hotelID, roomNumber, "");
						}//�ı䷿��������Ϣ
						
					}
				}
			}
		}
	}

}
