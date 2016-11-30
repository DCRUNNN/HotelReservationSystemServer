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

	//���õ���ģʽ ������ص�ʱ����ɳ�ʼ�����������߳�ͬ������
	private RoomDaoImpl() {
		
		dataFactory=new DataFactoryImpl();
		roomDataHelper=dataFactory.getRoomDataHelper();
	}
	
	public static RoomDaoImpl getInstance(){
		return INSTANCE;
	} //ͨ������static���������RoomDaoImpl��ʵ��
	
	@Override
	public List<RoomPO> getAllRoomList(String hotelId) {
		
		return roomDataHelper.getAllRoomList(hotelId);
	}

	@Override
	public RoomPO getRoomByNum(String hotelId, String roomId) {
		
		return roomDataHelper.getRoomByNum(hotelId,roomId);
	}

	//ͨ��getAllRoomList���Եõ����еĲ�ͬ���� ��ͬ״̬�ķ���
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

	

}