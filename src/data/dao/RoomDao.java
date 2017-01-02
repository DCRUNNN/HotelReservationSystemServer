package data.dao;

import java.rmi.RemoteException;
import java.util.List;

import po.RoomPO;

public interface RoomDao {
	
	/**
	 * @param hotelId 酒店编号
	 * @return 得到酒店的所有房间信息
	 * */
	public List<RoomPO> getAllRoomList(String hotelId);

	/**
	 * @param hotelID 房间编号
	 * @param roomId 房间号码
	 * @return 得到房间信息
	 * */
	public RoomPO getRoomByNum(String hotleID,String roomId);
	
	/**
	 * @param po 房间信息
	 * @return 返回是否增加房间信息成功
	 * */
	public boolean addRoom(RoomPO po);
	
	/**
	 * @param hotelId 酒店编号
	 * @param roomId 房间号码
	 * @return 返回是否删除成功
	 * */
	public boolean deleteRoom(String hotelId,String roomId);
	
	/**
	 * @param type 房间类型
	 * @param price 房间价格
	 * @param hotelId 酒店编号
	 * @return 返回是否修改房间价格成功
	 * */
	public boolean changeRoomType(String hotelId,String roomNumber,String type);
	
	public boolean changeRoomPrice(String type,double price,String hotelId);
	
	public boolean changeRoomPriceById(String hotelId,double price,String roomNumber);
	/**
	 * @param hotelId 酒店编号
	 * @param roomId 房间号码
	 * @param state 新的状态
	 * @return 返回是否修改成功
	 * */
	public boolean changeRoomState(String hotelId,String roomId,String state);

	/**
	 * @param hotelID 酒店编号
	 * @param roomId 房间号码
	 * @param bookDate 预订时间
	 * @return 返回是否修改成功
	 * */
	public boolean changeBookDate(String hotelID, String roomId, String bookDate);
	
	public boolean changeRoomIntroByType(String hotelId,String roomType,String intro);
	
	public boolean changeRoomIntroById(String hotelId,String roomNumber,String intro);

	public List<String> getRoomType(String hotelId);
	
	public List<String> getRoomState(String hotelId);
}
