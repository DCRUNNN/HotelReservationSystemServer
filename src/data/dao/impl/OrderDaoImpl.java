package data.dao.impl;

import java.util.List;

import data.dao.OrderDao;
import data.datahelper.DataFactory;
import data.datahelper.OrderDataHelper;
import data.datahelper.impl.DataFactoryImpl;
import po.OrderPO;

public class OrderDaoImpl implements OrderDao{

	//运用单例模式，在类加载的时候完成初始化，不存在线程同步问题
	private static final OrderDaoImpl INSTANCE = new OrderDaoImpl();
	private DataFactory dataFactory;
	private OrderDataHelper orderDataHelper;
	private OrderDaoImpl(){
		dataFactory = new DataFactoryImpl();
		orderDataHelper = dataFactory.getOrderDataHelper();
	}
	
	public static OrderDaoImpl getInstance(){
		return INSTANCE;
	}//通过调用static方法来获得OrderDaoImpl的实例
	
	
	@Override
	public List<OrderPO> getOrderPOList(String clientID) {
		
		return orderDataHelper.getOrderPOList(clientID);
	}

	@Override
	public boolean change(OrderPO po) {
		
		return orderDataHelper.change(po);
	}

	@Override
	public OrderPO getOrderPO(String orderID) {
		
		return orderDataHelper.getOrderPO(orderID);
	}

	@Override
	public boolean insertNewOrder(OrderPO po) {
		
		return orderDataHelper.insertNewOrder(po);
	}

	@Override
	public List<OrderPO> getClientOrdersInaHotel(String clientID, String hotelID) {
		
		return orderDataHelper.getClientOrdersInaHotel(clientID,hotelID);
	}

	@Override
	public List<OrderPO> getHotelOrderPOList(String hotelID) {
		
		return orderDataHelper.getHotelOrderPOList(hotelID);
	}

	@Override
	public List<OrderPO> getAllOrders() {
	
		return orderDataHelper.getAllOrders();
	}

	@Override
	public List<String> getAllIDs() {
		
		return orderDataHelper.getAllIDs();
	}
	
}
