package service.Order.BrowseOrder_hotelWorker;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.dao.OrderDao;
import data.dao.impl.OrderDaoImpl;
import po.OrderPO;
import service.Order.InteractWithHotel.HotelProvidedServiceForOrder;
import service.Order.help.CreateOrderVO;
import vo.OrderVO;

/**
 * BrowseOrder_hotelWorkerService的实现类
 * @see HotelProvidedServiceForOrder
 * @see OrderDao
 * @see CreateOrderVO
 * */
public class BrowseOrder_hotelWorkerServiceImpl implements BrowseOrder_hotelWorkerService{

	private OrderDao orderDao;
	
	public BrowseOrder_hotelWorkerServiceImpl (){
		
		orderDao = OrderDaoImpl.getInstance();
	}
	
	@Override
	public OrderVO getOrder(String orderID) throws RemoteException{
		
		OrderPO po = orderDao.getOrderPO(orderID);
		if(po==null){
			return null;
		}
		return new CreateOrderVO().createOrderVO(po);
	}

	@Override
	public List<OrderVO> getExecutedOrders(String hotelID)throws RemoteException {
		
		List<OrderPO> allHotelOrders = orderDao.getHotelOrderPOList(hotelID);
		List<OrderVO> volist = new ArrayList<OrderVO>();
		CreateOrderVO help = new CreateOrderVO();
		
		for(OrderPO po:allHotelOrders){
			if(po.getOrderStatus().equals("已执行")){
				volist.add(help.createOrderVO(po));
			}
		}
		return volist;
	}

	@Override
	public List<OrderVO> getUnexecutedOrders(String hotelID) throws RemoteException{
		
		List<OrderPO> allHotelOrders = orderDao.getHotelOrderPOList(hotelID);
		List<OrderVO> volist = new ArrayList<OrderVO>();
		CreateOrderVO help = new CreateOrderVO();
		
		for(OrderPO po:allHotelOrders){
			if(po.getOrderStatus().equals("未执行")){
				volist.add(help.createOrderVO(po));
			}
		}
		return volist;
	}

	@Override
	public List<OrderVO> getWithdrawnOrders(String hotelID) throws RemoteException{
		
		List<OrderPO> allHotelOrders = orderDao.getHotelOrderPOList(hotelID);
		List<OrderVO> volist = new ArrayList<OrderVO>();
		CreateOrderVO help = new CreateOrderVO();
		
		for(OrderPO po:allHotelOrders){
			if(po.getOrderStatus().equals("已撤销")){
				volist.add(help.createOrderVO(po));
			}
		}
		return volist;
	}

	@Override
	public List<OrderVO> getAbnormalOrders(String hotelID) throws RemoteException{
		
		List<OrderPO> allHotelOrders = orderDao.getHotelOrderPOList(hotelID);
		List<OrderVO> volist = new ArrayList<OrderVO>();
		CreateOrderVO help = new CreateOrderVO();
		
		for(OrderPO po:allHotelOrders){
			if(po.getOrderStatus().equals("异常")){
				volist.add(help.createOrderVO(po));
			}
		}
		return volist;
	}

}
