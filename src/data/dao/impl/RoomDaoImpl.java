package data.dao.impl;

/**
 * @author Cong Deng
 */
import java.util.List;

import data.dao.RoomDao;
import data.datahelper.DataFactory;
import data.datahelper.RoomDataHelper;
import data.datahelper.impl.DataFactoryImpl;
import po.RoomPO;

public class RoomDaoImpl implements RoomDao {

	private RoomDataHelper roomDataHelper;
	
	private DataFactory dataFactory;
	
	private static final RoomDaoImpl INSTANCE=new RoomDaoImpl();

	//运用单例模式 在类加载的时候完成初始化，不存在线程同步问题
	private RoomDaoImpl() {
		
		dataFactory=new DataFactoryImpl();
		roomDataHelper=dataFactory.getRoomDataHelper();
	}
	
	public static RoomDaoImpl getInstance(){
		return INSTANCE;
	} //通过调用static方法来获得RoomDaoImpl的实例
	
	@Override
	public List<RoomPO> getAllRoomList(String hotelId) {
		
		return roomDataHelper.getAllRoomList(hotelId);
	}

	@Override
	public RoomPO getRoomByNum(String hotelId, String roomId) {
		
		return roomDataHelper.getRoomByNum(hotelId,roomId);
	}

	//通过getAllRoomList可以得到所有的不同类型 不同状态的房间
	/*@Override
	/*public List<RoomPO> getRoomByState(String hotelId, String state) {
		// TODO Auto-generated method stub
		return roomDataHelper.getRoomByType(hotelId,state);
	}

	@Override
	public List<RoomPO> getRoomByType(String hotelId, String type) {
		// TODO Auto-generated method stub
		return roomDataHelper.getRoomByType(hotelId, type);
	}*/
	
	@Override
	public boolean addRoom(RoomPO po) {
	
		return roomDataHelper.addRoom(po);
	}

	@Override
	public boolean deleteRoom(String hotelId, String roomId) {

		return roomDataHelper.deleteRoom(hotelId, roomId);
	}

	@Override
	public boolean changeRoomPrice(String type, double price, String hotelId) {
		
		return roomDataHelper.changeRoomPrice(type, price, hotelId);
	}

	@Override
	public boolean changeRoomState(String hotelId, String roomId, String state) {
		
		return roomDataHelper.changeRoomState(hotelId, roomId, state);
	}

	@Override
	public boolean changeBookDate(String hotelId, String roomId, String bookDate) {
	
		return roomDataHelper.changeBookDate(hotelId, roomId, bookDate);
	}

	@Override
	public List<String> getRoomType(String hotelId) {
		
		return roomDataHelper.getRoomType(hotelId);
	}

	@Override
	public List<String> getRoomState(String hotelId) {
		
		return roomDataHelper.getRoomState(hotelId);
	}

	@Override
	public boolean changeRoomIntroByType(String hotelId, String roomType, String intro) {
		// TODO Auto-generated method stub
		return roomDataHelper.changeRoomIntroByType(hotelId,roomType,intro);
	}

	@Override
	public boolean changeRoomIntroById(String hotelId, String roomNumber, String intro) {
		// TODO Auto-generated method stub
		return roomDataHelper.changeRoomIntroById(hotelId,roomNumber,intro);
	}

	@Override
	public boolean changeRoomPriceById(String hotelId, double price, String roomNumber) {
		// TODO Auto-generated method stub
		return roomDataHelper.changeRoomPriceById(hotelId,price,roomNumber);
	}

	@Override
	public boolean changeRoomType(String hotelId, String roomNumber, String type) {
		// TODO Auto-generated method stub
		return roomDataHelper.changeRoomType(hotelId,roomNumber,type);
	}

	
	

}
