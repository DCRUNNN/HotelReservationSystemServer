package service.Order.BrowseOrder_webWorker;

import java.util.ArrayList;
import java.util.List;

import data.dao.OrderDao;
import data.dao.impl.OrderDaoImpl;
import po.OrderPO;
import service.Hotel.ProvidedService.HotelProvidedServiceForOrderImpl;
import service.Order.InteractWithHotel.HotelProvidedServiceForOrder;
import vo.OrderVO;

/**
 * �����࣬�������еĶ�����Ϣ
 * @see OrderDao
 * @see HotelProvidedServiceForOrder
 * */
public class AllOrders {

	private List<OrderVO> allorders;
	private HotelProvidedServiceForOrder hotelservice;
	private OrderDao orderdao;
	
	public AllOrders(){
		
		hotelservice = new HotelProvidedServiceForOrderImpl();
		orderdao = OrderDaoImpl.getInstance();
		initallorders();
	}

	/**
	 * @return ��ʼ��allorders
	 * */
	private void initallorders() {
		
		List<OrderPO> polist = orderdao.getAllOrders();
		allorders = new ArrayList<OrderVO>();
		for(OrderPO po:polist){
			String hotelInfo = hotelservice.getHotelInfo(po.getHotelID());
			OrderVO vo = new OrderVO(po,hotelInfo);
			allorders.add(vo);
		}
	}
	
	/**
	 * @return �õ����е�δִ�ж���
	 * */
	public List<OrderVO> getAllUnexecutedOrders(){
		
		List<OrderVO> list = new ArrayList<OrderVO>();
		for(OrderVO vo:allorders){
			if("δִ��".equals(vo.getOrderStatus())){
				list.add(vo);
			}
		}
		return list;
	}
	
	/**
	 * @return �õ����е��쳣����
	 * */
	public List<OrderVO> getAllAbnormalOrders(){
		List<OrderVO> list = new ArrayList<OrderVO>();
		for(OrderVO vo:allorders){
			if("�쳣".equals(vo.getOrderStatus())){
				list.add(vo);
			}
		}
		return list;
	}
	
	/**
	 * @return ���ݶ�����ŵõ�������Ϣ
	 * */
	public OrderVO getOrderVO(String orderID){
		for(OrderVO vo:allorders){
			if(orderID.equals(vo.getOrderID())){
				return vo;
			}
		}
		return null;
	}
	
	/**
	 * @return �õ��ͻ��������쳣����
	 * */
	public List<OrderVO> getClientAbnormalOrders(String clientID){
		List<OrderVO> list = new ArrayList<OrderVO> ();
		for(OrderVO vo:allorders){
			if(clientID.equals(vo.getClientID())){
				list.add(vo);
			}
		}
		return list;
	}
}
