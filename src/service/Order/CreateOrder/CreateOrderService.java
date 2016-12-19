package service.Order.CreateOrder;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CreateOrderService extends Remote{

	/**
	 * @param hotelID �Ƶ���
	 * @return ���ؾƵ귿������+"|"+����۸�+"/"+��������+"|"+����۸�
	 * */
	public String getRoomTypeAndPrice (String hotelID)throws RemoteException;
	
	/**
	 * @param hotelID �Ƶ���
	 * @param ��������(ע���ǵ�һ�ķ������ͣ�������"/"�ָ���ȫ����������)
	 * @return ���ط������͵����п�ѡ�ķ������ (��"/"�ָ�)(���صĶ��ǿ���״̬�ķ���)
	 * */
	public String getAllRoomNumber(String hotelID,String roomType)throws RemoteException;
	
	/**
	 * @param hotelID �Ƶ���
	 * @param clientID �ͻ����
	 * @param roomType ��������(�������roomType+"/"+roomType)
	 * @param roomNumber �������(�������roomNumebr+"/"+roomNumber)
	 * @return ���ɶ���
	 * */
	public boolean createOrder(String hotelID,String clientID,String roomType,String roomNumber)throws RemoteException;
	
	/**
	 * @param hotelID �Ƶ���
	 * @param clientID �ͻ����
	 * @param roomNumber number1+"/"+number2 ѡ�еķ������
	 * @return ���������Ų����µ��ܷ���۸�
	 * */
	public double getPriceByStrategy(String hotelID,String clientID,String roomNumber)throws RemoteException;
	
	/**
	 * @param clientID �ͻ����
	 * @return �жϿͻ����õ��Ƿ����0�����ڵ���0����true��С��0����false
	 * */
	public boolean checkCreditPoint(String clientID)throws RemoteException;
	
	/**
	 * @param hotelID �Ƶ���
	 * @param roomNumber �������
	 * @return �жϷ���״̬�Ƿ�Ϊ���У��ǵĻ�����true������false
	 * */
	public boolean checkRoom(String hotelID,String roomNumber) throws RemoteException;
	
}
