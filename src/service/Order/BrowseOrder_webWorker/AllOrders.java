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
 * 容器类，含有所有的订单信息
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
	 * @return 初始化allorders
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
	 * @return 得到所有的未执行订单
	 * */
	public List<OrderVO> getAllUnexecutedOrders(){
		
		List<OrderVO> list = new ArrayList<OrderVO>();
		for(OrderVO vo:allorders){
			if("未执行".equals(vo.getOrderStatus())){
				list.add(vo);
			}
		}
		return list;
	}
	
	/**
	 * @return 得到所有的异常订单
	 * */
	public List<OrderVO> getAllAbnormalOrders(){
		List<OrderVO> list = new ArrayList<OrderVO>();
		for(OrderVO vo:allorders){
			if("异常".equals(vo.getOrderStatus())){
				list.add(vo);
			}
		}
		return list;
	}
	
	/**
	 * @return 根据订单编号得到订单信息
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
	 * @return 得到客户的所有异常订单
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
