package service.Room.ProvidedService;

import java.util.ArrayList;
import java.util.List;

import data.dao.RoomDao;
import data.dao.impl.RoomDaoImpl;
import po.RoomPO;
import service.Order.InteractWithRoom.RoomProvidedServiceForOrder;
import vo.RoomVO;

public class RoomProvidedServiceForOrderImpl implements RoomProvidedServiceForOrder{

	private RoomDao roomDao;
	
	public RoomProvidedServiceForOrderImpl(){
		
		roomDao = RoomDaoImpl.getInstance();
	}
	@Override
	public List<RoomVO> getAllRooms(String hotelID) {
	    
		List<RoomVO> allroom = new ArrayList<RoomVO>();
		List<RoomPO> allrooms = roomDao.getAllRoomList(hotelID);
		for(RoomPO po:allrooms){
			RoomVO roomvo = new RoomVO(po);
			allroom.add(roomvo);
		}
		return allroom;
	}

	@Override
	public boolean changeRoomState(String hotelID, String roomNumber, String state) {
		
		return roomDao.changeRoomState(hotelID, roomNumber, state);
	}

	@Override
	public boolean setBookDate(String hotelID, String roomNumber, String bookDate) {
	
		return roomDao.changeBookDate(hotelID,roomNumber,bookDate);
	}
	
	@Override
	public String getAvailableRoomNumbers(String hotelID, String roomType) {
    	
    	List<RoomPO> allrooms = roomDao.getAllRoomList(hotelID);
    	StringBuilder sb = new StringBuilder();
    	for(RoomPO po:allrooms){
    		if("ø’œ–".equals(po.getRoomState())){
    			if(roomType.equals(po.getRoomType())){
    				sb.append(po.getRoomNumber()+"/");
    			}
    		}
    	}
    	
    	if(sb.length()==0){
    		return "";
    	}else{
    		String result = sb.toString().substring(0, sb.length()-1);
        	return result;
    	}
    }
	
	@Override
	public double getRoomPrice(String hotelID, String roomNumber) {
		
		RoomPO po = roomDao.getRoomByNum(hotelID, roomNumber);
		return po.getPrice();
	}

}
