package service.Order.EvaluateOrder;

import data.dao.OrderDao;
import data.dao.impl.OrderDaoImpl;
import po.OrderPO;
import service.Hotel.ProvidedService.HotelProvidedServiceForOrderImpl;
import service.Order.InteractWithHotel.HotelProvidedServiceForOrder;

/**
 * EvaluateOrderService的实现类 主要实现了评论订单和追加评论的功能
 * @see OrderDao
 * @see HotelProvidedServiceForOrder
 * */
public class EvaluateOrderServiceImpl implements EvaluateOrderService{

	private OrderDao orderDao;
	private HotelProvidedServiceForOrder hotelservice;
	private String orderID;
	
	public EvaluateOrderServiceImpl(String orderID){
		
		this.orderID = orderID;
		orderDao = OrderDaoImpl.getInstance();
		hotelservice = new HotelProvidedServiceForOrderImpl();
	}
	
	@Override
	public boolean addComment(String comment, int point_facilities, int point_service, int surroundings) {
		
		OrderPO po = orderDao.getOrderPO(orderID);
		if(po==null){
			return false;
		}
		po.setComment(comment);//修改订单的comment
		
		String hotelID = po.getHotelID();
		String clientID = po.getClientID();
		if(!hotelservice.addComment(hotelID, clientID, orderID,comment, point_facilities, point_service, surroundings)){
			return false;
		}//往酒店里面增加评论内容
		
		if(!orderDao.change(po)){
			return false;
		}
		return true;
	}

	@Override
	public boolean addExtraComment(String comment) {
		
		OrderPO po = orderDao.getOrderPO(orderID);
		String comment1 = po.getComment();
		comment1 = comment1+"|"+comment;
		po.setComment(comment1);
		if(!orderDao.change(po)){
			return false;
		}//改变订单内容
		
		String hotelID = po.getHotelID();
		if(!hotelservice.addComment(hotelID, orderID, comment)){
			return false;
		}//增加酒店的评论信息
		return true;
	}

	
}
