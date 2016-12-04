package service.Room.CreateRoom;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.RoomVO;

public interface CreateRoomInfoService extends Remote{
	
	
	/**
	 * @param roomVo
	 * @return �½�һ������״̬
	 */
	public boolean CreateRoom(RoomVO roomVO)throws RemoteException;
	
	/**
	 * @param hotelID �Ƶ���
	 * @return ���ط�������(����1+"/"+����2)
	 * */
	public String getAllRoomTypeAndPrice(String hotelID)throws RemoteException;
	
}
