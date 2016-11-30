package service.Order.BrowseOrder_webWorker;

import java.util.List;

import vo.OrderVO;

/**
 * BrowseOrder_webWorkerService的实现类
 * @see AllOrders
 * @see WithdrawAbnormalOrder
 * */
public class BrowseOrder_webWorkerServiceImpl implements BrowseOrder_webWorkerService{

    private AllOrders allorders;
    
    public BrowseOrder_webWorkerServiceImpl(){
    	allorders = new AllOrders();
    }
	@Override
	public List<OrderVO> getAllUnexecutedOrders() {
		
		return allorders.getAllUnexecutedOrders();
	}

	@Override
	public List<OrderVO> getAllAbnormalOrders() {
	
		return allorders.getAllAbnormalOrders();
	}

	@Override
	public boolean withdrawAbnormalOrder(String orderID) {
		
		return new WithdrawAbnormalOrder().withdraw(orderID);
	}

	@Override
	public OrderVO getOrderVO(String orderID) {

		return allorders.getOrderVO(orderID);
	}

	@Override
	public List<OrderVO> getClientAbnormalOrders(String clientID) {
		
		return allorders.getClientAbnormalOrders(clientID);
	}

}
