package service.Order.BrowseOrder_hotelWorker;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.OrderVO;

public interface BrowseOrder_hotelWorkerService extends Remote{

	/**
	 * @param orderID
	 * @return 根据订单id，返回详细的订单信息
	 * */
	public OrderVO getOrder(String orderID)throws RemoteException;
	
	/**
	 * @param hotelID 酒店编号
	 * @return 得到酒店的所有已执行订单
	 * */
	public List<OrderVO> getExecutedOrders(String hotelID)throws RemoteException;
	
	/**
	 * @param hotelID 酒店编号
	 * @return 得到酒店的所有未执行订单
	 * */
	public List<OrderVO> getUnexecutedOrders(String hotelID)throws RemoteException;
	
	/**
	 * @param hotelID 酒店编号
	 * @return 得到酒店的所有已撤销订单
	 * */
	public List<OrderVO> getWithdrawnOrders(String hotelID)throws RemoteException;
	
	/**
	 * @param hotelID 酒店编号
	 * @return 得到酒店的所有异常订单
	 * */
	public List<OrderVO> getAbnormalOrders(String hotelID)throws RemoteException;
	
}
