package service.Room.CheckOutRoom;

public interface CheckOutRoomService {

	/**
	 * @param clinetID �ͻ����
	 * @param hotelID �Ƶ���
	 * �˷�ʱ���������еķ��䶼����
	 * @return �˷��ɹ��Ļ������˵÷���� roomnumber1+"/"+roomnumber2 ʧ�ܵĻ�����""
	 * */
	public String checkOutRoom(String clientID,String hotelID);
	
	
}
