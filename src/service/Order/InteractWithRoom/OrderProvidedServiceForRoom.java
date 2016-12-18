package service.Order.InteractWithRoom;

import java.util.List;

public interface OrderProvidedServiceForRoom {

	/**
	 * ���ö������˷�ʱ��
	 * @param clientID �ͻ����
	 * @param hotelID �Ƶ���
	 * @param roomNumber �������
	 * */
	public boolean setEndTime(String clientID, String hotelID,String roomNumber);

	/**
	 * ���ؿͻ��ھƵ����������ס�ĵķ���
	 * @param clientID �ͻ����
	 * @param hotelID �Ƶ���
	 * */
	public List<String> getRoomNumber(String clientID,String hotelID);
	
}
