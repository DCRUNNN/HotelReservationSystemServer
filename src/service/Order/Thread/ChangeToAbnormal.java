package service.Order.Thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import data.dao.OrderDao;
import data.dao.impl.OrderDaoImpl;
import po.OrderPO;

/**
 * һ���̣߳������ڶ�����������ִ��ʱ���ʱ��Ѷ�����״̬�ı�Ϊ�쳣����
 * */
public class ChangeToAbnormal implements Runnable{
	
	@Override
	public void run() {
		
		OrderDao orderDao;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		while(true){
			orderDao = OrderDaoImpl.getInstance();//���orderDaoʵ�������ǻ᲻�����һֱ���е�����İ�
			List<OrderPO> allorders = orderDao.getAllOrders();
			for(OrderPO po:allorders){
				if("δִ��".equals(po.getOrderStatus())){		
					String orderLastDate = po.getOrderLastDate();
					boolean isOutTime = false;
					try{
						Date lastDate = sdf.parse(orderLastDate);
						long lastTime = lastDate.getTime();//����ִ��ʱ��غ�����
						long currentTime = new Date().getTime();//��ǰʱ��غ�����
						if(lastTime>currentTime){
							isOutTime = true;
						}
					}catch(Exception e){
						e.printStackTrace();
					}
					
					if(isOutTime){//������ʱ
						po.setOrderStatus("�쳣");
						orderDao.change(po);
					}
				}
			}
		}
	}

}
