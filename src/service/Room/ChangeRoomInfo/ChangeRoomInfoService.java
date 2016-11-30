package service.Room.ChangeRoomInfo;

import java.util.List;

import vo.RoomVO;

public interface ChangeRoomInfoService {

	/**
	 * @return 返回酒店的所有房间信息
	 */
	public List<RoomVO> getAllRoomList();
	
	/**
	 * @param roomId 房间号码
	 * @return 返回房间信息
	 * */
	public RoomVO getRoomByNum(String roomId);
	
	/**
	 * @param state 房间状态
	 * @return 返回特定状态下的所有房间信息
	 * */
	public List<RoomVO> getRoomByState(String state);
	
	/**
	 * @param type 房间类型
	 * @return 返回该类型的所有房间信息
	 * */
	public List<RoomVO> getRoomByType(String type);
	
	/**
	 * @param type 房间类型
	 * @param price 价格
	 * @param hotelId 酒店编号
	 * @return 返回是否修改成功
	 * */
	public boolean changeRoomPrice(String type,double price,String hotelId);
	
	/**
	 * @param hotelId 酒店编号
	 * @param roomId 房间编号
	 * @param state 新的房间状态
	 * @return 返回是否修改成功
	 * */
	public boolean changeRoomState(String hotelId,String roomId,String state);
	
	/**
	 * @param hotelId 酒店编号
	 * @param roomId 房间号码
	 * @return 返回是否删除成功
	 * */
	public boolean deleteRoom(String hotelId,String roomId);
	
}
