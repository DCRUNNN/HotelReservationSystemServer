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

	/**
	 * @param hotelID �Ƶ���
	 * @param roomType ��������
	 * @return �������ھƵ���õķ������͵ķ������ (roomNumebr1+"/"+roomNumber2)
	 * */
	public String getAvailableRoomNumbers(String hotelID, String roomType);

	/**
	 * @param hotelID �Ƶ���
	 * @param roomNumber �������
	 * @return �������еķ����Ӧ�ļ۸�
	 * */
	public double getRoomPrice(String hotelID, String roomNumber);

	/**
	 * @param hotelID �Ƶ���
	 * @param roomNumber �������
	 * @return �������״̬Ϊ���У�����true������false
	 * */
	public boolean checkRoom(String hotelID, String roomNumber);

}
