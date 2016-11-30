package service.Order.BrowseOrder_hotelWorker;

import java.util.List;

import vo.OrderVO;

public interface BrowseOrder_hotelWorkerService {

	/**
	 * @param orderID
	 * @return 根据订单id，返回详细的订单信息
	 * */
	public OrderVO getOrder(String orderID);
	
	/**
	 * @return 得到酒店的所有已执行订单
	 * */
	public List<OrderVO> getExecutedOrders();
	
	/**
	 * @return 得到酒店的所有未执行订单
	 * */
	public List<OrderVO> getUnexecutedOrders();
	
	/**
	 * @return 得到酒店的所有已撤销订单
	 * */
	public List<OrderVO> getWithdrawnOrders();
	
	/**
	 * @return 得到酒店的所有异常订单
	 * */
	public List<OrderVO> getAbnormalOrders();
	
}
