package service.Order.BrowseOrder_hotelWorker;

import java.util.ArrayList;
import java.util.List;

import data.dao.OrderDao;
import data.dao.impl.OrderDaoImpl;
import po.OrderPO;
import service.Hotel.ProvidedService.HotelProvidedServiceForOrderImpl;
import service.Order.InteractWithHotel.HotelProvidedServiceForOrder;
import vo.OrderVO;

/**
 * �����࣬�����Ƶ�����ж�����������orderdao��������Ƶ�ģ�齻��
 * @see HotelProvidedServiceForOrder
 * @see OrderDao
 * */
public class AllHotelOrder {

	String hotelID;
	private List<OrderVO> orderVOList;
	private HotelProvidedServiceForOrder hotelservice;
	private OrderDao orderDao;
	
	private void initOrderVOList() {
	
		List<OrderPO> polist = orderDao.getHotelOrderPOList(hotelID);
		orderVOList = new ArrayList<OrderVO>();
		for(OrderPO po:polist){
			String hotelInfo = hotelservice.getHotelInfo(hotelID);
			OrderVO vo = new OrderVO(po,hotelInfo);
			orderVOList.add(vo);
		}
	}

	public AllHotelOrder(String hotelID){
		
		this.hotelID = hotelID;
		hotelservice = new HotelProvidedServiceForOrderImpl();
		orderDao = OrderDaoImpl.getInstance();
		initOrderVOList();
	}

	/**
	 * @return ��þƵ��������ִ�ж���
	 * */
	public List<OrderVO> getExecutedOrders(){
		
		List<OrderVO> list = new ArrayList<OrderVO> ();
		for(OrderVO vo:orderVOList){
			if("��ִ��".equals(vo.getOrderStatus())){
				list.add(vo);
			}
		}
		return list;
	}
	
	/**
	 * @return ��þƵ������δִ�ж���
	 * */
	public List<OrderVO> getUnexecutedOrders(){
		
		List<OrderVO> list = new ArrayList<OrderVO> ();
		for(OrderVO vo:orderVOList){
			if("δִ��".equals(vo.getOrderStatus())){
				list.add(vo);
			}
		}
		return list;
	}
	
	/**
	 * @return ��þƵ�������ѳ�������
	 * */
	public List<OrderVO> getWithdrawnOrders(){
		
		List<OrderVO> list = new ArrayList<OrderVO> ();
		for(OrderVO vo:orderVOList){
			if("�ѳ���".equals(vo.getOrderStatus())){
				list.add(vo);
			}
		}
		return list;
	}
	
	/**
	 * @return ��þƵ�������쳣����
	 * */
	public List<OrderVO> getAbnormalOrders(){
		
		List<OrderVO> list = new ArrayList<OrderVO> ();
		for(OrderVO vo:orderVOList){
			if("�쳣".equals(vo.getOrderStatus())){
				list.add(vo);
			}
		}
		return list;
	}
	
	/**
	 * @return ���ݶ������ ���ض�����ϸ��Ϣ
	 * */
	public OrderVO getOrderVO(String orderID){
		for(OrderVO vo:orderVOList){
			if(orderID.equals(vo.getOrderID()));
			return vo;
		}
		return null;
	}
	
}
