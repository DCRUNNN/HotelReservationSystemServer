package service.Order.MyOrder;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.OrderVO;

public interface MyOrderService extends Remote{

	/**
	 * @return 获得客户的所有已执行订单
	 * */
	public List<OrderVO> getExecutedOrders(String clientID) throws RemoteException;
	
	/**
	 * @return 获得客户的所有未执行订单
	 * */
	public List<OrderVO> getUnexecutedOrders(String clientID) throws RemoteException;
	
	/**
	 * @return 获得客户的所有已撤销订单
	 * */
	public List<OrderVO> getWithdrawnOrders(String clientID) throws RemoteException;
	
	/**
	 * @return 获得客户的所有异常订单
	 * */
	public List<OrderVO> getAbnormalOrders(String clientID) throws RemoteException;
	
	/**
	 * @param 订单编号
	 * @return 根据订单编号获得详细订单信息
	 * */
	public OrderVO getOrderVO(String orderID) throws RemoteException;

	/**
	 * @param 客户编号
	 * @param 订单编号
	 * @return 根据订单编号 撤销订单
	 * */
	public boolean withdraw(String clientID,String orderID) throws RemoteException;
	
	
}
