package service.Room.CheckOutRoom;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CheckOutRoomService extends Remote{

	/**
	 * @param clinetID �ͻ����
	 * @param hotelID �Ƶ���
	 * �˷�ʱ���������еķ��䶼����
	 * @return �˷��ɹ��Ļ������˵÷���� roomnumber1+"/"+roomnumber2 ʧ�ܵĻ�����""
	 * */
	public String checkOutRoom(String clientID,String hotelID)throws RemoteException;
	
	
}
