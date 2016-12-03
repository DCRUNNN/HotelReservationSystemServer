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
 * 一个线程，负责在订单到了最晚执行时间的时候把订单的状态改变为异常订单
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
			}//每一秒执行一次线程 减轻cpu的负担
			
			orderDao = OrderDaoImpl.getInstance();//获得orderDao实例
			List<OrderPO> allorders = orderDao.getAllOrders();
			for(OrderPO po:allorders){
				if("未执行".equals(po.getOrderStatus())){
					
					String orderLastDate = po.getOrderLastDate();
					//System.out.println(po.getOrderLastDate());
					boolean isOutTime = false;
					try{
						Date LastDate = sdf.parse(orderLastDate);//订单最晚执行时间
						long lastTime = LastDate.getTime();//最晚执行时间地毫秒数
						long currentTime = new Date().getTime();//当前时间地毫秒数
						if(lastTime<currentTime){
							isOutTime = true;
						}
					}catch(Exception e){
						e.printStackTrace();
					}
					
					if(isOutTime){//订单超时
						po.setOrderStatus("异常");
						orderDao.change(po);//改变订单状态
						
						double point = po.getPrice()/2;//减少客户订单价格一半的信用点
						String clientID = po.getClientID();
						ClientProvidedService clientservice = new ClientProvidedServiceImpl();
						clientservice.subClientCreditPoint(clientID, point);//完成了减少客户信用值
						
						CreditPO creditpo = new CreditPO();
						creditpo.setCause("订单异常");
						creditpo.setChange("-"+point);
						creditpo.setClientID(po.getClientID());
						creditpo.setOrderID(po.getOrderID());
						creditpo.setTime(sdf.format(new Date()));
						CreditProvidedService creditservice = new CreditProvidedServiceImpl();
						creditservice.insertCredit(creditpo);//完成了信用记录的增加
						
						String roomNumber = po.getRoomNumber();
						String rooms[] = roomNumber.split("/");
						String hotelID = po.getHotelID();
						RoomProvidedServiceForOrder roomservice = new RoomProvidedServiceForOrderImpl();
						for(String str:rooms){
							roomservice.changeRoomState(hotelID, str, "空闲");
							roomservice.setBookDate(hotelID, roomNumber, "");
						}//改变房间的相关信息
						
					}
				}
			}
		}
	}

}
