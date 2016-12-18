package service.Order.InteractWithRoom;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	public boolean setEndTime(String clientID, String hotelID,String roomNumber) {
		
		List<OrderPO> polist = orderDao.getClientOrdersInaHotel(clientID, hotelID);
		if(polist.size()==0){
			return false;//�Ҳ���������ʱ�򣬷���false
		}else{
			for(OrderPO po:polist){
				if("��ִ��".equals(po.getOrderStatus())){
					//�ҵ����е���ִ�ж���
					if("".equals(po.getOrderEndDate())||po.getOrderEndDate()==null){
						//�ҵ���û���˷�ʱ���
						if(po.getRoomNumber().contains(roomNumber)){
							//�ҵ������÷���Ķ���
							if(po.getCheckOutTotal()+1==po.getRoomTotal()){
								//������һ�䷿ �ﵽ��Ԥ��������Ŀ
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								String outTime = sdf.format(new Date());
								int checkOutTotal = po.getCheckOutTotal();
							    po.setCheckOutTotal(checkOutTotal+1);
								po.setOrderEndDate(outTime);
								return orderDao.change(po);
							}else{
								//�����ǲ��ı��˷�ʱ�䣬���һ�䷿�Ÿı��˷�ʱ��,�˷���Ŀ��1
							    int checkOutTotal = po.getCheckOutTotal();
							    po.setCheckOutTotal(checkOutTotal+1);
								return orderDao.change(po);
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	@Override
	public List<String> getRoomNumber(String clientID, String hotelID) {
	
		List<String> result = new ArrayList<String>();
		
		List<OrderPO> polist = orderDao.getClientOrdersInaHotel(clientID, hotelID);
		if(polist.size()==0){
			return result;//�Ҳ���������ʱ�򣬷���""
		}else{
			for(OrderPO po:polist){
				if("��ִ��".equals(po.getOrderStatus())){
					//�ҵ����е���ִ�ж���
					if("".equals(po.getOrderEndDate())||po.getOrderEndDate()==null){
						//�ҵ���û���˷�ʱ���
						String rooms[] = po.getRoomNumber().split("/");
						for(String str:rooms){
							//�����еķ�����뵽list��
							result.add(str);
						}
					}
				}
			}
		}
	
		return result;
	}

}
