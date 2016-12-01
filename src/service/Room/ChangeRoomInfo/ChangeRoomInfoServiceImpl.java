package service.Room.ChangeRoomInfo;

import java.util.ArrayList;
import java.util.List;

import data.dao.RoomDao;
import data.dao.impl.RoomDaoImpl;
import po.RoomPO;
import service.Hotel.ProvidedService.HotelProvidedService;
import service.Hotel.ProvidedService.HotelProvidedServiceImpl;
import vo.RoomVO;

public class ChangeRoomInfoServiceImpl implements ChangeRoomInfoService {

	private String hotelId;
	
	private List<RoomVO> hotelRoomList;
	
	private HotelProvidedService hotelService;
	
	private RoomDao roomDao;
	
	public ChangeRoomInfoServiceImpl(String hotelId) {
		
		this.hotelId=hotelId;
		roomDao=RoomDaoImpl.getInstance();
		hotelService = new HotelProvidedServiceImpl();
		initHotelRoomList();
	}
	
	private void initHotelRoomList() {
	
		hotelRoomList = new ArrayList<RoomVO>();
	    List<RoomPO> polist = roomDao.getAllRoomList(hotelId);
	    for(RoomPO po:polist){
	    	RoomVO vo = new RoomVO(po);
	    	hotelRoomList.add(vo);
	    }
	}
	@Override
	public List<RoomVO> getAllRoomList() {
		
		return hotelRoomList;
	}

	@Override
	public RoomVO getRoomByNum(String roomId) {
		
		for(RoomVO vo:hotelRoomList){
			if(roomId.equals(vo.getRoomNumber())){
				return vo;
			}
		}
		return null;
	}

	@Override
	public List<RoomVO> getRoomByState(String state) {
	
		List<RoomVO> list=new ArrayList<RoomVO>();
		for(RoomVO roomVO:hotelRoomList){
			list.add(roomVO);
		}
		return list;
	}

	@Override
	public List<RoomVO> getRoomByType(String type) {
	
		List<RoomVO> list=new ArrayList<RoomVO>();
		for(RoomVO roomVO:hotelRoomList){
			//遍历所有的房间信息，找到房间状态为type的房间进行返回
			if(type.equals(roomVO.getRoomType())){
				list.add(roomVO);
			}
		}
		return list;
	}

	@Override
	public boolean changeRoomPrice(String type, double price, String hotelId) {
		
		//改变对象里面的List<RoomVO>
		for(RoomVO vo:hotelRoomList){
			if(type.equals(vo.getRoomType())){
				vo.setPrice(price);
			}
		}
		
		if(!hotelService.changeRoomTypeAndPrice(type,price,hotelId)){
			return false;
		}
		return roomDao.changeRoomPrice(type, price, hotelId);
	}

	@Override
	public boolean changeRoomState(String hotelId, String roomId, String state) {
	
		//改变hotelRoomList的房间状态
		for(RoomVO vo:hotelRoomList){
			if(roomId.equals(vo.getRoomNumber())){
				vo.setRoomState(state);
			}
		}
		return roomDao.changeRoomState(hotelId, roomId, state);
	}

	@Override
	public boolean deleteRoom(String hotelId, String roomId) {
	
		RoomVO roomvo = null;
		for(RoomVO vo:hotelRoomList){
			if(roomId.equals(vo.getRoomNumber())){
				roomvo = vo;
			}
		}
		hotelRoomList.remove(roomvo);//在hotelRoomList里面删除房间信息
		
		return roomDao.deleteRoom(hotelId, roomId);
	}

}
