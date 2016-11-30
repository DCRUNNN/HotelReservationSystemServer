package data.dao;

import java.util.List;

import po.RoomPO;

public interface RoomDao {
	
	/**
	 * @param hotelId �Ƶ���
	 * @return �õ��Ƶ�����з�����Ϣ
	 * */
	public List<RoomPO> getAllRoomList(String hotelId);

	/**
	 * @param hotelID ������
	 * @param roomId �������
	 * @return �õ�������Ϣ
	 * */
	public RoomPO getRoomByNum(String hotleID,String roomId);
	
	/**
	 * @param po ������Ϣ
	 * @return �����Ƿ����ӷ�����Ϣ�ɹ�
	 * */
	public boolean addRoom(RoomPO po);
	
	/**
	 * @param hotelId �Ƶ���
	 * @param roomId �������
	 * @return �����Ƿ�ɾ���ɹ�
	 * */
	public boolean deleteRoom(String hotelId,String roomId);
	
	/**
	 * @param type ��������
	 * @param price ����۸�
	 * @param hotelId �Ƶ���
	 * @return �����Ƿ��޸ķ���۸�ɹ�
	 * */
	public boolean changeRoomPrice(String type,double price,String hotelId);
	
	/**
	 * @param hotelId �Ƶ���
	 * @param roomId �������
	 * @param state �µ�״̬
	 * @return �����Ƿ��޸ĳɹ�
	 * */
	public boolean changeRoomState(String hotelId,String roomId,String state);

	/**
	 * @param hotelID �Ƶ���
	 * @param roomId �������
	 * @param bookDate Ԥ��ʱ��
	 * @return �����Ƿ��޸ĳɹ�
	 * */
	public boolean changeBookDate(String hotelID, String roomId, String bookDate);
	
}
