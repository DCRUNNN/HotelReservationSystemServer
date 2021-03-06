package data.datahelper;

/**
 * @author Cong Deng
 */
import java.util.List;

import po.RoomPO;

public interface RoomDataHelper {
		
	public List<RoomPO> getAllRoomList(String hotelId);
	
	public RoomPO getRoomByNum(String hotelId,String roomId);
	
	public List<RoomPO> getRoomByState(String hotelId,String state);
	
	public List<RoomPO> getRoomByType(String hotelId,String type);
	
	public boolean addRoom(RoomPO po);
	
	public boolean deleteRoom(String hotelId, String roomId);
	
	public boolean changeRoomPrice(String type, double price, String hotelId);
	
	public boolean changeRoomPriceById(String hotelId,double price,String roomNumber);
	
	public boolean changeRoomState(String hotelId, String roomId, String state);
	
	public boolean changeRoomIntroByType(String hotelId,String roomType,String intro);
	
	public boolean changeRoomIntroById(String hotelId,String roomNumber,String intro);
	
	public boolean changeBookDate(String hotelId, String roomId, String bookDate);
	
	public boolean changeRoomType(String hotelId,String roomNumber,String type);

	public List<String> getRoomType(String hotelId);

	public List<String> getRoomState(String hotelId);
	
}
