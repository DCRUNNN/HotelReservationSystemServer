package service.Order.MyOrder;

import java.util.List;

import vo.OrderVO;

public interface MyOrderService {

	/**
	 * @return 获得客户的所有已执行订单
	 * */
	public List<OrderVO> getExecutedOrders();
	
	/**
	 * @return 获得客户的所有未执行订单
	 * */
	public List<OrderVO> getUnexecutedOrders();
	
	/**
	 * @return 获得客户的所有已撤销订单
	 * */
	public List<OrderVO> getWithdrawnOrders();
	
	/**
	 * @return 获得客户的所有异常订单
	 * */
	public List<OrderVO> getAbnormalOrders();
	
	/**
	 * @param 订单编号
	 * @return 根据订单编号获得详细订单信息
	 * */
	public OrderVO getOrderVO(String orderID);

	/**
	 * @param 订单编号
	 * @return 根据订单编号 撤销订单
	 * */
	public boolean withdraw(String orderID);
	
	
}
