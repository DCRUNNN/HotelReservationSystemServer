package service.Order.MyOrder;

import java.util.ArrayList;
import java.util.List;

import data.dao.OrderDao;
import data.dao.impl.OrderDaoImpl;
import po.OrderPO;
import service.Order.help.CreateOrderVO;
import vo.OrderVO;

/**
 * MyOrderService��ʵ����
 * @see AllClientOrder
 * */
public class MyOrderServiceImpl implements MyOrderService{

	private String clientID;
	private OrderDao orderDao;
	
	public MyOrderServiceImpl(String clientID){
		
		this.clientID = clientID;
		orderDao = OrderDaoImpl.getInstance();
	}
	
	@Override
	public List<OrderVO> getExecutedOrders() {
		
	    List<OrderPO> polist = orderDao.getOrderPOList(clientID);
	    List<OrderVO> result = new ArrayList<OrderVO>();
	    CreateOrderVO help = new CreateOrderVO();
	    
	    for(OrderPO po:polist){
			//�������еĿͻ��Ķ���
			if("��ִ��".equals(po.getOrderStatus())){
				//�����е�δִ�ж������뵽result
				result.add(help.createOrderVO(po));
			}
		}
	    
	    return result;
	}

	@Override
	public List<OrderVO> getUnexecutedOrders() {
		
	    List<OrderPO> polist = orderDao.getOrderPOList(clientID);
	    List<OrderVO> result = new ArrayList<OrderVO>();
	    CreateOrderVO help = new CreateOrderVO();
	    
	    for(OrderPO po:polist){
			//�������еĿͻ��Ķ���
			if("δִ��".equals(po.getOrderStatus())){
				//�����е�δִ�ж������뵽result
				result.add(help.createOrderVO(po));
			}
		}
	    
	    return result;
	}

	@Override
	public List<OrderVO> getWithdrawnOrders() {
		
	    List<OrderPO> polist = orderDao.getOrderPOList(clientID);
	    List<OrderVO> result = new ArrayList<OrderVO>();
	    CreateOrderVO help = new CreateOrderVO();
	    
	    for(OrderPO po:polist){
			//�������еĿͻ��Ķ���
			if("�ѳ���".equals(po.getOrderStatus())){
				//�����е�δִ�ж������뵽result
				result.add(help.createOrderVO(po));
			}
		}
	    
	    return result;
	}

	@Override
	public List<OrderVO> getAbnormalOrders() {
		
	    List<OrderPO> polist = orderDao.getOrderPOList(clientID);
	    List<OrderVO> result = new ArrayList<OrderVO>();
	    CreateOrderVO help = new CreateOrderVO();
	    
	    for(OrderPO po:polist){
			//�������еĿͻ��Ķ���
			if("�쳣".equals(po.getOrderStatus())){
				//�����е�δִ�ж������뵽result
				result.add(help.createOrderVO(po));
			}
		}
	    
	    return result;
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
	public boolean withdraw(String orderID) {
		
		Withdraw withdraw = new Withdraw(clientID);
		return withdraw.withdraw(orderID);
	}

}
