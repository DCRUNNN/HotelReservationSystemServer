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
			return false;//找不到订单的时候，返回false
		}else{
			for(OrderPO po:polist){
				if("已执行".equals(po.getOrderStatus())){
					//找到所有的已执行订单
					if("".equals(po.getOrderEndDate())||po.getOrderEndDate()==null){
						//找到还没有退房时间的
						if(po.getRoomNumber().contains(roomNumber)){
							//找到包含该房间的订单
							if(po.getCheckOutTotal()+1==po.getRoomTotal()){
								//退了这一间房 达到了预订的总数目
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								String outTime = sdf.format(new Date());
								int checkOutTotal = po.getCheckOutTotal();
							    po.setCheckOutTotal(checkOutTotal+1);
								po.setOrderEndDate(outTime);
								return orderDao.change(po);
							}else{
								//否则还是不改变退房时间，最后一间房才改变退房时间,退房数目加1
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
			return result;//找不到订单的时候，返回""
		}else{
			for(OrderPO po:polist){
				if("已执行".equals(po.getOrderStatus())){
					//找到所有的已执行订单
					if("".equals(po.getOrderEndDate())||po.getOrderEndDate()==null){
						//找到还没有退房时间的
						String rooms[] = po.getRoomNumber().split("/");
						for(String str:rooms){
							//把所有的房间加入到list中
							result.add(str);
						}
					}
				}
			}
		}
	
		return result;
	}

}
