package service.Room.CheckOutRoom;

public interface CheckOutRoomService {

	/**
	 * @param clinetID �ͻ����
	 * @param hotelID �Ƶ���
	 * �˷�ʱ���������еķ��䶼����
	 * @return �����Ƿ�ɹ�������Ϣ
	 * */
	public boolean checkOutRoom(String clientID,String hotelID);
	
	
}
