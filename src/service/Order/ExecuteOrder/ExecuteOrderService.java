package service.Order.ExecuteOrder;

import java.util.List;

import vo.OrderVO;

public interface ExecuteOrderService {

	/**
	 * @param clientID �ͻ����
	 * @return ���ؿͻ��ھƵ������δִ�ж�����Ϣ
	 * */
	public List<OrderVO> getUnexecutedOrders(String clientID);
	
	/**
	 * @param clientID �ͻ����
	 * @return ���ؿͻ��ھƵ�������쳣������Ϣ
	 * */
	public List<OrderVO> getAbnormalOrders(String clientID);
	
	/**
	 * @param clientID
	 * @return ���ؿͻ��ھƵ��Ԥ���������������(����1+"/"+����2)
	 * */
	public String getAllRoomType(String orderID);
	
	/**
	 * @param �ͻ����
	 * @return ���ؿͻ��ڸþƵ�����з������(����1+"/"+����2)
	 * ���Ӧ�ľ��� ����ͻ�id ֮��ĵ��ȷ����ť���¼�
	 * �������õ�˳��һ��Ҫ��֤ �ȵ���getAllRoomNumber ������������֮ǰ
	 * */
	public String getAllRoomNumber(String orderID);
	
	/**
	 * @return ���ص��ǿͻ�������ס�ķ�����루��֮ǰ�ķ���û�б�Ԥ������ô����֮ǰ�ķ�����룬�����Ԥ���ˣ�
	 * ���ѡ����������ĺ��룬����Ƶ�ķ��䲻�㣬��ô���ؾ��Ƕ�Ӧ��λ��Ϊ"�޿��з���"��
	 * ���Ӧ����"�ӳ���ס"��ť����֮�� ����ͻ�id��ѡ��ö���֮���ȷ���¼�
	 * �ӳ���ס��֮ǰ�������쳣ʱ�۳��˿ͻ��Ķ����۸�һ������õ� 
	 * �ڿͻ����°�����ס֮�� ���Ӷ���һ������õ� �൱�ڲ�����Ҳ������ �����Ǻܺ����
	 * */
	public String getDelayRoomNumber(String orderID);

	/**
	 * @param �������,��ס����
	 * @return ��������ö�Ӧ�ķ������ס����
	 * */
	public void setRoomPeople(String roomNumber,int peopleNumebr);
	
	/**
	 * @param ������룬���޶�ͯ
	 * @return ��������ö�Ӧ�ķ�������޶�ͯ
	 * */
	public void setRoomChild(String roomNumber,boolean hasChild);
	
	/**
	 * @return ����˶�����ִ�У������ı䶩��״̬���Ѹı��Ķ�����������д�����ݿ⣬���ӿͻ������õ㣬�������ü�¼
	 * �ı䷿��״̬
	 * */
	public boolean executeOrder();
}
