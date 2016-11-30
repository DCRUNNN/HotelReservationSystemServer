package service.Order.InteractWithRoom;

import java.util.List;

import vo.RoomVO;

public interface RoomProvidedServiceForOrder {

	/**
	 * @param �Ƶ���
	 * @return ���ظþƵ�����з����б�
	 * */
	public List<RoomVO> getAllRooms(String hotelID);

	/**
	 * @param �Ƶ���,������룬����״̬
	 * @return ���ݾƵ��� ȥ�ı�Ƶ�ķ���״̬,ֻ�Ǽ򵥵ĸı䷿��״̬
	 * */
	public boolean changeRoomState(String hotelID, String roomNumber,String state);
	
	/**
	 * @param �Ƶ��ţ�������룬Ԥ��ʱ��
	 * @return ���ݾƵ��ţ�ȥ�ı�Ƶ��Ԥ��ʱ��
	 * */
	public boolean setBookDate(String hotelID,String roomNumber,String bookDate);

}
