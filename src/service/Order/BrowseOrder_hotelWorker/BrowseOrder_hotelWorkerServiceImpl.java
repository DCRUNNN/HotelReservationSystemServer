package service.Order.BrowseOrder_hotelWorker;

import java.util.List;

import vo.OrderVO;

/**
 * BrowseOrder_hotelWorkerService的实现类
 * @see AllHotelOrder
 * */
public class BrowseOrder_hotelWorkerServiceImpl implements BrowseOrder_hotelWorkerService{

	private AllHotelOrder allorder;
	
	public BrowseOrder_hotelWorkerServiceImpl (String hotelID){
		allorder = new AllHotelOrder(hotelID);
	}
	@Override
	public OrderVO getOrder(String orderID) {
		return allorder.getOrderVO(orderID);
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

}
