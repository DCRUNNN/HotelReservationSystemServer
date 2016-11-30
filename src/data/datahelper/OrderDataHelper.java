package data.datahelper;

import java.util.List;

import po.OrderPO;

public interface OrderDataHelper {

	public List<OrderPO> getOrderPOList(String clientID);

	public boolean change(OrderPO po);

	public OrderPO getOrderPO(String orderID);

	public boolean insertNewOrder(OrderPO po);

	public List<OrderPO> getClientOrdersInaHotel(String clientID, String hotelID);

	public List<OrderPO> getHotelOrderPOList(String hotelID);

	public List<OrderPO> getAllOrders();

	public List<String> getAllIDs();

}
