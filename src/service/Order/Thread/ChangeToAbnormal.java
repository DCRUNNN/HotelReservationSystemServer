package service.Order.Thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import data.dao.OrderDao;
import data.dao.impl.OrderDaoImpl;
import po.OrderPO;

/**
 * 一个线程，负责在订单到了最晚执行时间的时候把订单的状态改变为异常订单
 * */
public class ChangeToAbnormal implements Runnable{
	
	@Override
	public void run() {
		
		OrderDao orderDao;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		while(true){
			orderDao = OrderDaoImpl.getInstance();//获得orderDao实例，但是会不会出现一直持有的情况的啊
			List<OrderPO> allorders = orderDao.getAllOrders();
			for(OrderPO po:allorders){
				if("未执行".equals(po.getOrderStatus())){		
					String orderLastDate = po.getOrderLastDate();
					boolean isOutTime = false;
					try{
						Date lastDate = sdf.parse(orderLastDate);
						long lastTime = lastDate.getTime();//最晚执行时间地毫秒数
						long currentTime = new Date().getTime();//当前时间地毫秒数
						if(lastTime>currentTime){
							isOutTime = true;
						}
					}catch(Exception e){
						e.printStackTrace();
					}
					
					if(isOutTime){//订单超时
						po.setOrderStatus("异常");
						orderDao.change(po);
					}
				}
			}
		}
	}

}
