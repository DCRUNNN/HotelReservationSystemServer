package service.Order.InteractWithHotel;

import java.util.ArrayList;
import java.util.List;

import data.dao.OrderDao;
import data.dao.impl.OrderDaoImpl;
import po.OrderPO;

public class OrderProvidedServiceForHotelImpl implements OrderProvidedServiceForHotel{

	private OrderDao orderDao;
	
	public OrderProvidedServiceForHotelImpl(){
		
		orderDao = OrderDaoImpl.getInstance();
	}
	
	@Override
	public List<String> getAllClientOrderInfo(String clientID) {
		
		List<String> result = new ArrayList<String>();
		List<OrderPO> polist = orderDao.getOrderPOList(clientID);//得到客户的所有相关订单
		if(polist==null||polist.size()==0){
			//返回的是空的话
			return result;
		}
		
		for(OrderPO po:polist){
			String orderInfo = po.getOrderCreatedDate()+"/"+po.getOrderStatus()+"/"+po.getOrderID()+"/"+po.getPrice()+"/"+po.getHotelID();
			result.add(orderInfo);
		}
		return result;
	}

	@Override
	public List<OrderPO> getAllOrdersOfClientInaHotel(String clientID, String hotelID) {
		
		List<OrderPO> polist = orderDao.getHotelOrderPOList(hotelID);//得到酒店的所有订单
		if(polist==null){
			//酒店没有订单的时候，返回空
			return null;
		}
		List<OrderPO> poClientList = new ArrayList<OrderPO>();
		for(OrderPO po:polist){
			if(clientID.equals(po.getClientID())){
				poClientList.add(po);
			}
		}
		return poClientList;
	}

}
