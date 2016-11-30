package service.Order.ExecuteOrder;

import java.util.List;

import vo.OrderVO;

/**
 * ExecuteOrderService的实现类
 * @see ChangeOrder
 * */
public class ExecuteOrderServiceImpl implements ExecuteOrderService{

    private ChangeOrder change;
    
	public ExecuteOrderServiceImpl(String hotelID){
		
		change = new ChangeOrder(hotelID);
	}
	
	@Override
	public List<OrderVO> getUnexecutedOrders(String clientID){
		
		return change.getUnexecutedOrders(clientID);
	}
	
	@Override
	public List<OrderVO> getAbnormalOrders(String clientID){
		return change.getAbnormalOrders(clientID);
	}
	@Override
	public String getAllRoomType(String orderID) {
		
		return change.getAllRoomType(orderID);
	}

	@Override
	public String getAllRoomNumber(String orderID) {
		
		return change.getAllRoomNumber(orderID);
	}

	@Override
	public void setRoomPeople(String roomNumber, int peopleNumber) {
		
		change.serRoomPeople(roomNumber, peopleNumber);
	}

	@Override
	public void setRoomChild(String roomNumber, boolean hasChild) {
		
		change.setRoomChild(roomNumber, hasChild);
	}

	@Override
	public boolean executeOrder() {
		
		return change.executeOrder();
	}

	@Override
	public String getDelayRoomNumber(String orderID) {
		
		return change.getDelayRoomNumber(orderID);
	}

}
