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
			return false;//�Ҳ���������ʱ�򣬷���false
		}else{
			for(OrderPO po:polist){
				if("��ִ��".equals(po.getOrderStatus())){
					//�ҵ����е���ִ�ж���
					if("".equals(po.getOrderEndDate())||po.getOrderEndDate()==null){
						//�ҵ���û���˷�ʱ���
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
			return "";//�Ҳ���������ʱ�򣬷���""
		}else{
			for(OrderPO po:polist){
				if("��ִ��".equals(po.getOrderStatus())){
					//�ҵ����е���ִ�ж���
					if("".equals(po.getOrderEndDate())||po.getOrderEndDate()==null){
						//�ҵ���û���˷�ʱ���
						return po.getRoomNumber();
					}
				}
			}
		}
	
		return "";
	}

}
