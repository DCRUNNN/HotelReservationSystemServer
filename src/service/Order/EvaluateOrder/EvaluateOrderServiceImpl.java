package service.Order.EvaluateOrder;

import data.dao.OrderDao;
import data.dao.impl.OrderDaoImpl;
import po.OrderPO;
import service.Hotel.ProvidedService.HotelProvidedServiceForOrderImpl;
import service.Order.InteractWithHotel.HotelProvidedServiceForOrder;

/**
 * EvaluateOrderService��ʵ���� ��Ҫʵ�������۶�����׷�����۵Ĺ���
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
		po.setComment(comment);//�޸Ķ�����comment
		
		String hotelID = po.getHotelID();
		String clientID = po.getClientID();
		if(!hotelservice.addComment(hotelID, clientID, orderID,comment, point_facilities, point_service, surroundings)){
			return false;
		}//���Ƶ�����������������
		
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
		}//�ı䶩������
		
		String hotelID = po.getHotelID();
		if(!hotelservice.addComment(hotelID, orderID, comment)){
			return false;
		}//���ӾƵ��������Ϣ
		return true;
	}

	
}
