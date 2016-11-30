package service.Room.CheckOutRoom;

import java.text.SimpleDateFormat;
import java.util.Date;

import data.dao.RoomDao;
import data.dao.impl.RoomDaoImpl;
import service.Order.InteractWithRoom.OrderProvidedServiceForRoom;
import service.Order.InteractWithRoom.OrderProvidedServiceForRoomImpl;

public class CheckOutRoomServiceImpl implements CheckOutRoomService{

	//完成退房流程，记录退房时间，更新订单退房时间，更新房间状态,
	private RoomDao roomDao;
	private OrderProvidedServiceForRoom orderService;
	
	public CheckOutRoomServiceImpl(){
		
		roomDao = RoomDaoImpl.getInstance();
		orderService = new OrderProvidedServiceForRoomImpl();
	}
	
	@Override
	public boolean checkOutRoom(String clientID,String hotelID) {
		
		String roomNumbers[] = orderService.getRoomNumber(clientID, hotelID).split("/");
		if(roomNumbers.length==0){
			//客户在酒店没有合适的房间号码
			return false;
		}
		for(String str:roomNumbers){
			//遍历房间，改变房间状态为空闲
			if(!roomDao.changeBookDate(hotelID, str, "空闲")){
				return false;
			}
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		String outTime = sdf.format(new Date());
		return orderService.setEndTime(clientID,hotelID,outTime);//设置订单的退房时间
	}

}
