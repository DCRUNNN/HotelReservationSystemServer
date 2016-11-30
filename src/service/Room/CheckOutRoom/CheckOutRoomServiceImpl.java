package service.Room.CheckOutRoom;

import java.text.SimpleDateFormat;
import java.util.Date;

import data.dao.RoomDao;
import data.dao.impl.RoomDaoImpl;
import service.Order.InteractWithRoom.OrderProvidedServiceForRoom;
import service.Order.InteractWithRoom.OrderProvidedServiceForRoomImpl;

public class CheckOutRoomServiceImpl implements CheckOutRoomService{

	//����˷����̣���¼�˷�ʱ�䣬���¶����˷�ʱ�䣬���·���״̬,
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
			//�ͻ��ھƵ�û�к��ʵķ������
			return false;
		}
		for(String str:roomNumbers){
			//�������䣬�ı䷿��״̬Ϊ����
			if(!roomDao.changeBookDate(hotelID, str, "����")){
				return false;
			}
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		String outTime = sdf.format(new Date());
		return orderService.setEndTime(clientID,hotelID,outTime);//���ö������˷�ʱ��
	}

}
