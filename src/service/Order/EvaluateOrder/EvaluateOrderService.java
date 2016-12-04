package service.Order.EvaluateOrder;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EvaluateOrderService extends Remote{
	
	/**
	 * @param orderID 订单编号
	 * @param comment 评论内容
	 * @param point_facilities 对酒店设施的评分
	 * @param point_service 对酒店服务的评分
	 * @param surroundings 对酒店周边环境的评分
	 * @return 增加评论信息
	 * */
	public boolean addComment(String orderID,String comment,int point_facilities,int point_service,int surroundings)throws RemoteException;
	
	/**
	 * @param orderID 订单编号
	 * @param comment 追加的评论内容
	 * @return 追加评论内容
	 * */
	public boolean addExtraComment(String orderID,String comment)throws RemoteException;
}
