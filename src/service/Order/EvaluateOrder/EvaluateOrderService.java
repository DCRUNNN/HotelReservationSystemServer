package service.Order.EvaluateOrder;

public interface EvaluateOrderService {
	
	/**
	 * @param ��������,����ʩ������,�Է��������,����Χ����������
	 * @return ����������Ϣ
	 * */
	public boolean addComment(String comment,int point_facilities,int point_service,int surroundings);
	
	/**
	 * @param ��������
	 * @return ׷����������
	 * */
	public boolean addExtraComment(String comment);
}
