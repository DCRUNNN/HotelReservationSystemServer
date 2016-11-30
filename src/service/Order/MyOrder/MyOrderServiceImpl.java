package service.Order.MyOrder;

import java.util.List;

import vo.OrderVO;

/**
 * MyOrderService的实现类
 * @see AllClientOrder
 * */
public class MyOrderServiceImpl implements MyOrderService{

	private AllClientOrder allorder;
	
	public MyOrderServiceImpl(String clientID){
		allorder = new AllClientOrder(clientID);
	}
	
	@Override
	public List<OrderVO> getExecutedOrders() {
		return allorder.getExecutedOrders();
	}

	@Override
	public List<OrderVO> getUnexecutedOrders() {
		return allorder.getUnexecutedOrders();
	}

	@Override
	public List<OrderVO> getWithdrawnOrders() {
		return allorder.getWithdrawnOrders();
	}

	@Override
	public List<OrderVO> getAbnormalOrders() {
		return allorder.getAbnormalOrders();
	}

	@Override
	public OrderVO getOrderVO(String orderID) {
		return allorder.getOrderVO(orderID);
	}

	@Override
	public boolean withdraw(String orderID) {
		return allorder.withdraw(orderID);
	}

}
