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
 * 容器类，包含酒店的所有订单，负责与orderdao交互，与酒店模块交互
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
	 * @return 获得酒店的所有已执行订单
	 * */
	public List<OrderVO> getExecutedOrders(){
		
		List<OrderVO> list = new ArrayList<OrderVO> ();
		for(OrderVO vo:orderVOList){
			if("已执行".equals(vo.getOrderStatus())){
				list.add(vo);
			}
		}
		return list;
	}
	
	/**
	 * @return 获得酒店的所有未执行订单
	 * */
	public List<OrderVO> getUnexecutedOrders(){
		
		List<OrderVO> list = new ArrayList<OrderVO> ();
		for(OrderVO vo:orderVOList){
			if("未执行".equals(vo.getOrderStatus())){
				list.add(vo);
			}
		}
		return list;
	}
	
	/**
	 * @return 获得酒店的所有已撤销订单
	 * */
	public List<OrderVO> getWithdrawnOrders(){
		
		List<OrderVO> list = new ArrayList<OrderVO> ();
		for(OrderVO vo:orderVOList){
			if("已撤销".equals(vo.getOrderStatus())){
				list.add(vo);
			}
		}
		return list;
	}
	
	/**
	 * @return 获得酒店的所有异常订单
	 * */
	public List<OrderVO> getAbnormalOrders(){
		
		List<OrderVO> list = new ArrayList<OrderVO> ();
		for(OrderVO vo:orderVOList){
			if("异常".equals(vo.getOrderStatus())){
				list.add(vo);
			}
		}
		return list;
	}
	
	/**
	 * @return 根据订单编号 返回订单详细信息
	 * */
	public OrderVO getOrderVO(String orderID){
		for(OrderVO vo:orderVOList){
			if(orderID.equals(vo.getOrderID()));
			return vo;
		}
		return null;
	}
	
}
