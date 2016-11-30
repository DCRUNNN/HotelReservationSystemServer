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
	
	public boolean changeRoomState(String hotelId, String roomId, String state);
	
	public boolean changeBookDate(String hotelId, String roomId, String bookDate);
	
}
