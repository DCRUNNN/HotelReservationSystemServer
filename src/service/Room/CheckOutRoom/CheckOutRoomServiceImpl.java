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

	//����˷����̣���¼�˷�ʱ�䣬���¶����˷�ʱ�䣬���·���״̬,
	private RoomDao roomDao;
	private OrderProvidedServiceForRoom orderService;
	
	public CheckOutRoomServiceImpl(){
		
		roomDao = RoomDaoImpl.getInstance();
		orderService = new OrderProvidedServiceForRoomImpl();
	}
	
	@Override
	public boolean checkOutRoom(String clientID,String hotelID,String roomNumber)throws RemoteException {
		
		if(!roomDao.changeRoomState(hotelID, roomNumber, "����")){
			return false;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String outTime = sdf.format(new Date());
		if(!orderService.setEndTime(clientID, hotelID, outTime)){
			return false;
		}//���������˷�ʱ��
		
		return true;

	}

	@Override
	public List<RoomVO> getAllRooms(String clientID, String hotelID) throws RemoteException {
	
		List<RoomVO> rooms = new ArrayList<RoomVO>();
		String allRoom = orderService.getRoomNumber(clientID, hotelID);
		if("".equals(allRoom)){
			//û�з���
			return rooms;
		}
		
		String allRooms[] = allRoom.split("/");
		for(String str:allRooms){
			//�������з������
			RoomVO vo = new RoomVO(roomDao.getRoomByNum(hotelID, str));
			rooms.add(vo);
		}
		return rooms;
	}

}
