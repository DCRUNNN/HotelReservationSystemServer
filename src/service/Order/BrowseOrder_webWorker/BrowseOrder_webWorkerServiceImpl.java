package service.Order.BrowseOrder_webWorker;

import java.util.ArrayList;
import java.util.List;

import data.dao.OrderDao;
import data.dao.impl.OrderDaoImpl;
import po.OrderPO;
import service.Order.help.CreateOrderVO;
import vo.OrderVO;

/**
 * BrowseOrder_webWorkerService��ʵ����
 * @see AllOrders
 * @see WithdrawAbnormalOrder
 * */
public class BrowseOrder_webWorkerServiceImpl implements BrowseOrder_webWorkerService{

    private OrderDao orderDao;
    
    public BrowseOrder_webWorkerServiceImpl(){
    	
          orderDao = OrderDaoImpl.getInstance();
    }
	@Override
	public List<OrderVO> getAllUnexecutedOrders() {
		
		List<OrderPO> allHotelOrders = orderDao.getAllOrders();
		List<OrderVO> volist = new ArrayList<OrderVO>();
		CreateOrderVO help = new CreateOrderVO();
		
		for(OrderPO po:allHotelOrders){
			if(po.getOrderStatus().equals("δִ��")){
				volist.add(help.createOrderVO(po));
			}
		}
		return volist;
	}

	@Override
	public List<OrderVO> getAllAbnormalOrders() {
		
		List<OrderPO> allHotelOrders = orderDao.getAllOrders();
		List<OrderVO> volist = new ArrayList<OrderVO>();
		CreateOrderVO help = new CreateOrderVO();
		
		for(OrderPO po:allHotelOrders){
			if(po.getOrderStatus().equals("�쳣")){
				volist.add(help.createOrderVO(po));
			}
		}
		return volist;
	}

	@Override
	public boolean withdrawAbnormalOrder(String orderID) {
		
		return new WithdrawAbnormalOrder().withdraw(orderID);
	}

	@Override
	public OrderVO getOrderVO(String orderID) {

		OrderPO po = orderDao.getOrderPO(orderID);
		if(po==null){
			return null;
		}
		CreateOrderVO help = new CreateOrderVO();
		return help.createOrderVO(po);
	}

	@Override
	public List<OrderVO> getClientAbnormalOrders(String clientID) {
		
		List<OrderPO> allHotelOrders = orderDao.getOrderPOList(clientID);//�õ��ͻ������ж���
		List<OrderVO> volist = new ArrayList<OrderVO>();
		CreateOrderVO help = new CreateOrderVO();
		
		for(OrderPO po:allHotelOrders){
			if(po.getOrderStatus().equals("�쳣")){
				volist.add(help.createOrderVO(po));
			}
		}
		return volist;
	
	}

}
