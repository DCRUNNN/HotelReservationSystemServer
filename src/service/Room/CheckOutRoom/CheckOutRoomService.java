package service.Room.CheckOutRoom;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.RoomVO;

public interface CheckOutRoomService extends Remote{

	/**
	 * 客户进行退房，输入房间号码，和客户id
	 * @param clinetID 客户编号
	 * @param hotelID 酒店编号
	 * @return 是否退房成功
	 * */
	public boolean checkOutRoom(String clientID,String hotelID,String roomNumber)throws RemoteException;
	
	/**
	 * 返回客户在该酒店的所有的房间信息
	 * @param clientID 客户编号
	 * @param hotelID 酒店编号
	 * */
	public List<RoomVO> getAllRooms(String clientID,String hotelID) throws RemoteException;
	
}
