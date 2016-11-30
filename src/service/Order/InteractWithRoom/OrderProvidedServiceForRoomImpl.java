package service.Order.InteractWithRoom;

import java.util.List;

import data.dao.OrderDao;
import data.dao.impl.OrderDaoImpl;
import po.OrderPO;

public class OrderProvidedServiceForRoomImpl implements OrderProvidedServiceForRoom{

	private OrderDao orderDao;
	public OrderProvidedServiceForRoomImpl(){
		
		orderDao = OrderDaoImpl.getInstance();
	}
	@Override
	public boolean setEndTime(String clientID, String hotelID, String outTime) {
		
		List<OrderPO> polist = orderDao.getClientOrdersInaHotel(clientID, hotelID);
		if(polist.size()==0){
			return false;//找不到订单的时候，返回false
		}else{
			for(OrderPO po:polist){
				if("已执行".equals(po.getOrderStatus())){
					//找到所有的已执行订单
					if("".equals(po.getOrderEndDate())||po.getOrderEndDate()==null){
						//找到还没有退房时间的
						po.setOrderEndDate(outTime);
						return orderDao.change(po);
					}
				}
			}
		}
		
		return false;
	}
	@Override
	public String getRoomNumber(String clientID, String hotelID) {
	
		List<OrderPO> polist = orderDao.getClientOrdersInaHotel(clientID, hotelID);
		if(polist.size()==0){
			return "";//找不到订单的时候，返回""
		}else{
			for(OrderPO po:polist){
				if("已执行".equals(po.getOrderStatus())){
					//找到所有的已执行订单
					if("".equals(po.getOrderEndDate())||po.getOrderEndDate()==null){
						//找到还没有退房时间的
						return po.getRoomNumber();
					}
				}
			}
		}
	
		return "";
	}

}
