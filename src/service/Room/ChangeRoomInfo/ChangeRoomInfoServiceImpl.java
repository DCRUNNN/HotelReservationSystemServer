package service.Room.ChangeRoomInfo;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.dao.RoomDao;
import data.dao.impl.RoomDaoImpl;
import po.RoomPO;
import service.Hotel.ProvidedService.HotelProvidedService;
import service.Hotel.ProvidedService.HotelProvidedServiceImpl;
import vo.RoomVO;

public class ChangeRoomInfoServiceImpl implements ChangeRoomInfoService {
	
	private HotelProvidedService hotelService;
	
	private RoomDao roomDao;
	
	public ChangeRoomInfoServiceImpl() {
		
		roomDao=RoomDaoImpl.getInstance();
		hotelService = new HotelProvidedServiceImpl();
	}
	
	@Override
	public List<RoomVO> getAllRoomList(String hotelID) throws RemoteException{
		
		List<RoomVO> hotelRoomList = new ArrayList<RoomVO>();
	    List<RoomPO> polist = roomDao.getAllRoomList(hotelID);
	    for(RoomPO po:polist){
	    	RoomVO vo = new RoomVO(po);
	    	hotelRoomList.add(vo);
	    }
		return hotelRoomList;
	}

	@Override
	public RoomVO getRoomByNum(String hotelID,String roomId)  throws RemoteException{
		
	    List<RoomPO> polist = roomDao.getAllRoomList(hotelID);
	    for(RoomPO po:polist){
	    	if(roomId.equals(po.getRoomNumber())){
	    		return new RoomVO(po);
	    	}
	    }
		return null;
	}

	@Override
	public List<RoomVO> getRoomByState(String hotelID,String state)  throws RemoteException{
		
		List<RoomVO> hotelRoomList = new ArrayList<RoomVO>();
	    List<RoomPO> polist = roomDao.getAllRoomList(hotelID);
	    for(RoomPO po:polist){
	        if(po.getRoomState().equals(state)){
	        	hotelRoomList.add(new RoomVO(po));
	        }
	    }
		return hotelRoomList;
	}

	@Override
	public List<RoomVO> getRoomByType(String hotelID,String type) throws RemoteException {
		
		List<RoomVO> hotelRoomList = new ArrayList<RoomVO>();
	    List<RoomPO> polist = roomDao.getAllRoomList(hotelID);
	    for(RoomPO po:polist){
	        if(po.getRoomType().equals(type)){
	        	hotelRoomList.add(new RoomVO(po));
	        }
	    }
		return hotelRoomList;
	}

	@Override
	public boolean changeRoomPrice(String type, double price, String hotelId)  throws RemoteException{
		
		
		if(!hotelService.changeRoomTypeAndPrice(type,price,hotelId)){
			return false;
		}
		return roomDao.changeRoomPrice(type, price, hotelId);
	}

	@Override
	public boolean changeRoomState(String hotelId, String roomId, String state) throws RemoteException {
	
		return roomDao.changeRoomState(hotelId, roomId, state);
	}

	@Override
	public boolean deleteRoom(String hotelId, String roomId)  throws RemoteException{
		
		return roomDao.deleteRoom(hotelId, roomId);
	}

	@Override
	public List<String> getRoomType(String hotelId)throws RemoteException {
		
		return roomDao.getRoomType(hotelId);
	}

	@Override
	public List<String> getRoomState(String hotelId)throws RemoteException {
		
		return roomDao.getRoomState(hotelId);
	}

}
