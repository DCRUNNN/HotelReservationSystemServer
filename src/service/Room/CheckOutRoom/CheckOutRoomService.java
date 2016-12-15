package service.Room.CheckOutRoom;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.RoomVO;

public interface CheckOutRoomService extends Remote{

	/**
	 * �ͻ������˷������뷿����룬�Ϳͻ�id
	 * @param clinetID �ͻ����
	 * @param hotelID �Ƶ���
	 * @return �Ƿ��˷��ɹ�
	 * */
	public boolean checkOutRoom(String clientID,String hotelID,String roomNumber)throws RemoteException;
	
	/**
	 * ���ؿͻ��ڸþƵ�����еķ�����Ϣ
	 * @param clientID �ͻ����
	 * @param hotelID �Ƶ���
	 * */
	public List<RoomVO> getAllRooms(String clientID,String hotelID) throws RemoteException;
	
}
