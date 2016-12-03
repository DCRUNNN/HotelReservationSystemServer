package service.Order.BrowseOrder_webWorker;

import java.util.List;

import vo.OrderVO;

public interface BrowseOrder_webWorkerService {
	
	/**
	 * @return 得到所有的未执行订单
	 * */
	public List<OrderVO> getAllUnexecutedOrders();
	
	/**
	 * @return 得到所有的异常订单
	 * */
	public List<OrderVO> getAllAbnormalOrders();
	
	/**
	 * @return 将一个异常订单转变为已撤销订单
	 * */
	public boolean withdrawAbnormalOrder(String orderID);
	
	/**
	 * @return 根据订单编号返回订单信息
	 * */
    public OrderVO getOrderVO(String orderID);
    
    /**
     * @return 根据客户id得到客户的所有异常订单
     * */
    public List<OrderVO> getClientAbnormalOrders(String clientID);
    
    
}
