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
			//改变房间状态
			return false;
		}
		
		return orderService.setEndTime(clientID, hotelID, roomNumber);
	}

	@Override
	public List<RoomVO> getAllRooms(String clientID, String hotelID) throws RemoteException {
	
		List<RoomVO> rooms = new ArrayList<RoomVO>();
		List<String> allrooms = orderService.getRoomNumber(clientID, hotelID);
		
		for(String str:allrooms){
			//遍历所有房间号码
			RoomVO vo = new RoomVO(roomDao.getRoomByNum(hotelID, str));
			rooms.add(vo);
		}
		return rooms;
	}

}
