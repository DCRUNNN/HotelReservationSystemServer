package service.Order.CreateOrder;

public interface CreateOrderService {

	/**
	 * @return ���ؾƵ귿������+"|"+����۸�+"/"+��������+"|"+����۸�
	 * */
	public String getRoomTypeAndPrice ();
	
	/**
	 * @param ��������(ע���ǵ�һ�ķ������ͣ�������"/"�ָ���ȫ����������)
	 * @return ���ط������͵����п�ѡ�ķ������ (��"/"�ָ�)
	 * */
	public String getAllRoomNumber(String roomType);
	
	/**
	 * @param ������Ŀ,��������(�������roomType+"/"+roomType),�������(�������roomNumebr+"/"+roomNumber)
	 * @return ���ɶ���
	 * */
	public boolean createOrder(int roomTotal,String roomType,String roomNumber);
	
	/**
	 * @param �������(number+"/"+number)
	 * @return ���������Ų����µ��ܷ���۸�
	 * */
	public double getPriceByStrategy(String roomNumber);
	
	/**
	 * @return �жϿͻ����õ��Ƿ����0�����ڵ���0����true��С��0����false
	 * */
	public boolean checkCreditPoint();
	
}
