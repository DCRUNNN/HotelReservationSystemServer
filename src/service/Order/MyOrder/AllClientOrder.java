package service.Order.MyOrder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import po.OrderPO;
import service.Hotel.ProvidedService.HotelProvidedServiceForOrderImpl;
import service.Order.InteractWithHotel.HotelProvidedServiceForOrder;
import vo.OrderVO;

/**
 * 容器类，主要职责就是负责处理与订单详细信息相关的操作
 * @see HotelProvidedServiceForOrder
 * @see Withdraw
 * */
public class AllClientOrder {

	private String clientID;
	private List<OrderVO> orderVOList;
	private HotelProvidedServiceForOrder hotelservice;
	private Withdraw withdraw;
	
	public AllClientOrder(String clientID){
		
		this.clientID = clientID;
		hotelservice = new HotelProvidedServiceForOrderImpl();
		initOrderVOList();
		withdraw = new Withdraw(clientID);
	}

	/**
	 * 参数为clienID 方法用来初始化orderVOList
	 * */
	private void initOrderVOList() {
		
		List<OrderPO> polist = withdraw.getOrderPOList();
		orderVOList = new ArrayList<OrderVO>();
		
		for(OrderPO po:polist){
			
			String hotelID = po.getHotelID();
			String hotelProvince = hotelservice.getHotelProvince(hotelID);
			String hotelCity = hotelservice.getHotelCity(hotelID);
			String hotelCBD = hotelservice.getHotelCBD(hotelID);
			String hotelAddress = hotelservice.getHotelAddress(hotelID);
			String hotelName = hotelservice.getHotelName(hotelID);
			OrderVO vo = new OrderVO(po,hotelProvince,hotelCity,hotelCBD,hotelAddress,hotelName);//完成了po向vo的转化
			orderVOList.add(vo);
		}
	}
	
	/**
	 * @return 获得客户的所有已执行订单
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
	 * @return 获得客户的所有未执行订单
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
	 * @return 获得客户的所有已撤销订单
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
	 * @return 获得客户的所有异常订单
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
	
	/**
	 * @return 根据订单编号撤销订单
	 * */
	public boolean withdraw(String orderID){
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String withdrawTime = formatter.format(new java.util.Date());
		
		for(OrderVO vo:orderVOList){
			if(orderID.equals(vo.getOrderID())){
				vo.setWithdrawTime(withdrawTime);
				vo.setOrderStatus("已撤销");
			}
		}//改变orderVOList中的vo
	
		return new Withdraw(clientID).withdraw(orderID,withdrawTime);
	}
}
