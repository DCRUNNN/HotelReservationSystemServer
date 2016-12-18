package service.Order.ExecuteOrder;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.OrderVO;

public interface ExecuteOrderService extends Remote{

	/**
	 * @param hotelID �Ƶ���
	 * @param clientID �ͻ����
	 * @return ���ؿͻ��ھƵ������δִ�ж�����Ϣ
	 * ���������Ӧ���ǰ���ִ�ж�����������ͻ���ŵ��¼�
	 * */
	public List<OrderVO> getUnexecutedOrders(String hotelID,String clientID)throws RemoteException;
	
	/**
	 * @param hotelID �Ƶ���
	 * @param clientID �ͻ����
	 * @return ���ؿͻ��ھƵ�������쳣������Ϣ
	 * ���������Ӧ���ǿͻ������ӳ���ס֮�� ��Ӧ���¼�
	 * */
	public List<OrderVO> getAbnormalOrders(String hotelID,String clientID)throws RemoteException;
	
	/**
	 * @param clientID
	 * @return ���ؿͻ��ھƵ��Ԥ���������������(����1+"/"+����2)
	 * */
	public String getAllRoomType(String orderID,String hotelID)throws RemoteException;
	
	/**
	 * @param �ͻ����
	 * @return ���ؿͻ��ڸþƵ�����з������(����1+"/"+����2)
	 * ���Ӧ�ľ��� ����ͻ�id ֮��ĵ��ȷ����ť���¼�
	 * �������õ�˳��һ��Ҫ��֤ �ȵ���getAllRoomNumber ������������֮ǰ
	 * */
	public String getAllRoomNumber(String orderID,String hotelID)throws RemoteException;
	
	/**
	 * @return ���ص��ǿͻ�������ס�ķ�����루��֮ǰ�ķ���û�б�Ԥ������ô����֮ǰ�ķ�����룬�����Ԥ���ˣ�
	 * ���ѡ����������ĺ��룬����Ƶ�ķ��䲻�㣬��ô���ؾ��Ƕ�Ӧ��λ��Ϊ"�޿��з���"��
	 * ���Ӧ����"�ӳ���ס"��ť����֮�� ����ͻ�id��ѡ��ö���֮���ȷ���¼�
	 * �ӳ���ס��֮ǰ�������쳣ʱ�۳��˿ͻ��Ķ����۸�һ������õ� 
	 * �ڿͻ����°�����ס֮�� ���Ӷ���һ������õ� �൱�ڲ�����Ҳ������ �����Ǻܺ����
	 * */
	public String getDelayRoomNumber(String orderID,String hotelID)throws RemoteException;

	/**
	 * @param �������,��ס����
	 * @return ��������ö�Ӧ�ķ������ס����
	 * */
	public void setRoomPeople(String roomNumber,int peopleNumebr)throws RemoteException;
	
	/**
	 * @param ������룬���޶�ͯ
	 * @return ��������ö�Ӧ�ķ�������޶�ͯ
	 * */
	public void setRoomChild(String roomNumber,boolean hasChild)throws RemoteException;
	
	/**
	 * @return ����˶�����ִ�У������ı䶩��״̬���Ѹı��Ķ�����������д�����ݿ⣬���ӿͻ������õ㣬�������ü�¼
	 * �ı䷿��״̬
	 * */
	public boolean executeOrder()throws RemoteException;
}
