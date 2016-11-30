package service.Order.MyOrder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import po.OrderPO;
import service.Hotel.ProvidedService.HotelProvidedServiceForOrderImpl;
import service.Order.InteractWithHotel.HotelProvidedServiceForOrder;
import vo.OrderVO;

/**
 * �����࣬��Ҫְ����Ǹ������붩����ϸ��Ϣ��صĲ���
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
	 * ����ΪclienID ����������ʼ��orderVOList
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
			OrderVO vo = new OrderVO(po,hotelProvince,hotelCity,hotelCBD,hotelAddress,hotelName);//�����po��vo��ת��
			orderVOList.add(vo);
		}
	}
	
	/**
	 * @return ��ÿͻ���������ִ�ж���
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
	 * @return ��ÿͻ�������δִ�ж���
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
	 * @return ��ÿͻ��������ѳ�������
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
	 * @return ��ÿͻ��������쳣����
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
	
	/**
	 * @return ���ݶ�����ų�������
	 * */
	public boolean withdraw(String orderID){
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String withdrawTime = formatter.format(new java.util.Date());
		
		for(OrderVO vo:orderVOList){
			if(orderID.equals(vo.getOrderID())){
				vo.setWithdrawTime(withdrawTime);
				vo.setOrderStatus("�ѳ���");
			}
		}//�ı�orderVOList�е�vo
	
		return new Withdraw(clientID).withdraw(orderID,withdrawTime);
	}
}
