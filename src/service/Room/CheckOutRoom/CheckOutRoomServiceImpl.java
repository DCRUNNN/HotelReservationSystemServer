package service.Room.CheckOutRoom;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import data.dao.RoomDao;
import data.dao.impl.RoomDaoImpl;
import service.Order.InteractWithRoom.OrderProvidedServiceForRoom;
import service.Order.InteractWithRoom.OrderProvidedServiceForRoomImpl;
import vo.RoomVO;

public class CheckOutRoomServiceImpl implements CheckOutRoomService{

	//完成退房流程，记录退房时间，更新订单退房时间，更新房间状态,
	private RoomDao roomDao;
	private OrderProvidedServiceForRoom orderService;
	
	public CheckOutRoomServiceImpl(){
		
		roomDao = RoomDaoImpl.getInstance();
		orderService = new OrderProvidedServiceForRoomImpl();
	}
	
	@Override
	public boolean checkOutRoom(String clientID,String hotelID,String roomNumber)throws RemoteException {
		
		if(!roomDao.changeRoomState(hotelID, roomNumber, "空闲")){
			return false;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String outTime = sdf.format(new Date());
		if(!orderService.setEndTime(clientID, hotelID, outTime)){
			return false;
		}//设置最晚退房时间
		
		return true;

	}

	@Override
	public List<RoomVO> getAllRooms(String clientID, String hotelID) throws RemoteException {
	
		List<RoomVO> rooms = new ArrayList<RoomVO>();
		String allRoom = orderService.getRoomNumber(clientID, hotelID);
		if("".equals(allRoom)){
			//没有房间
			return rooms;
		}
		
		String allRooms[] = allRoom.split("/");
		for(String str:allRooms){
			//遍历所有房间号码
			RoomVO vo = new RoomVO(roomDao.getRoomByNum(hotelID, str));
			rooms.add(vo);
		}
		return rooms;
	}

}
