package service.Order.EvaluateOrder;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EvaluateOrderService extends Remote{
	
	/**
	 * @param orderID �������
	 * @param comment ��������
	 * @param point_facilities �ԾƵ���ʩ������
	 * @param point_service �ԾƵ���������
	 * @param surroundings �ԾƵ��ܱ߻���������
	 * @return ����������Ϣ
	 * */
	public boolean addComment(String orderID,String comment,int point_facilities,int point_service,int surroundings)throws RemoteException;
	
	/**
	 * @param orderID �������
	 * @param comment ׷�ӵ���������
	 * @return ׷����������
	 * */
	public boolean addExtraComment(String orderID,String comment)throws RemoteException;
}
