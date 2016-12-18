package service.Order.ExecuteOrder;

import java.rmi.RemoteException;
import java.util.List;

import vo.OrderVO;

/**
 * ExecuteOrderService的实现类
 * @see ChangeOrder
 * */
public class ExecuteOrderServiceImpl implements ExecuteOrderService{

    private ChangeOrder change;
    
	public ExecuteOrderServiceImpl(){
		
		//把change的实例化留在输入酒店id之后
	}
	
	@Override
	public List<OrderVO> getUnexecutedOrders(String hotelID,String clientID)throws RemoteException{
		
		change = new ChangeOrder(hotelID);
		return change.getUnexecutedOrders(clientID);
	}
	
	@Override
	public List<OrderVO> getAbnormalOrders(String hotelID,String clientID)throws RemoteException{
		
		change = new ChangeOrder(hotelID);
		return change.getAbnormalOrders(clientID);
	}
	@Override
	public String getAllRoomType(String orderID,String hotelID)throws RemoteException {
		
		if(change==null){
			change = new ChangeOrder(hotelID);
		}
		return change.getAllRoomType(orderID);
	}

	@Override
	public String getAllRoomNumber(String orderID,String hotelID) throws RemoteException{
		
		if(change==null){
			change = new ChangeOrder(hotelID);
		}
		return change.getAllRoomNumber(orderID);
	}

	@Override
	public void setRoomPeople(String roomNumber, int peopleNumber)throws RemoteException {
		
		change.serRoomPeople(roomNumber, peopleNumber);
	}

	@Override
	public void setRoomChild(String roomNumber, boolean hasChild) throws RemoteException{
		
		change.setRoomChild(roomNumber, hasChild);
	}

	@Override
	public boolean executeOrder()throws RemoteException {
		
		return change.executeOrder();
	}

	@Override
	public String getDelayRoomNumber(String orderID,String hotelID) throws RemoteException{
		
		if(change==null){
			change = new ChangeOrder(hotelID);
		}
		return change.getDelayRoomNumber(orderID);
	}

}
