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
 * 负责与数据层交互，与客户，信用，房间模块进行交互
 * 主要完成撤销订单的相关操作
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
		
		//进行撤销之前要防止多线程刚好改变订单的状态
		String orderStatus = po.getOrderStatus();
		if("异常".equals(orderStatus)){
			//订单状态已经被改变为异常了，那么不能撤销了
			return false;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String withdrawTime = sdf.format(new Date());
		String hotelID = po.getHotelID();
		String roomNumber[] = po.getRoomNumber().split("/");
		po.setWithdrawTime(withdrawTime);
		po.setOrderStatus("已撤销");
		if(!orderDao.change(po)){
			return false;
		}//对数据层的持久化对象进行修改
		
		//撤销时间距离最晚执行时间不足六个小时的话，就需要扣除信用点
		String orderLastDate = po.getOrderLastDate();
		boolean isOutTime  = false;
		Date date1 = null;
		Date date2 = null;
		try{
			date1 = sdf.parse(withdrawTime);//d1表示的是撤销时间
		    date2 = sdf.parse(orderLastDate);//d2表示是最晚执行时间
		    long d1Time = date1.getTime();
		    long d2Time = date2.getTime();//过了最晚执行时间的话会自动把未执行订单转换为异常订单
		    if(d2Time-d1Time<1000*60*60*6){
		    	//距离最晚执行时间不足6小时
		    	isOutTime = true;
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
		if(isOutTime){
			//如果时间小于6小时的话
			double price = po.getPrice();
			double point = price/2;//暂时设置扣除的信用点为price除以2
			clientservice.subClientCreditPoint(clientID, point);//扣除客户信用点
			
			CreditPO creditpo = new CreditPO();
			creditpo.setTime(withdrawTime);
			creditpo.setClientID(clientID);
			creditpo.setOrderID(po.getOrderID());
			creditpo.setCause("订单撤销");
			String change = "-"+point;
			creditpo.setChange(change);
			if(!creditservice.insertCredit(creditpo)){
				return false;
			}//生成信用记录
		}
		
		for(int i=0;i<roomNumber.length;i++){
			if(!roomNumber[i].equals("")&&roomNumber[i]!=null){
				//取到不为空的房间号
				if(!roomservice.changeRoomState(hotelID, roomNumber[i], "空闲")){
					return false;
				}
				if(!roomservice.setBookDate(hotelID, roomNumber[i], "")){
					return false;
				}
			}
		}//改变房间状态,设置预订时间为“”
		
		return true;
	}
}
