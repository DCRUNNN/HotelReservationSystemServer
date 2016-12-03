package service.Hotel.MyHotel;

import java.util.ArrayList;
import java.util.List;
import data.dao.HotelDao;
import data.dao.impl.HotelDaoImpl;
import po.HotelPO;
import service.Order.InteractWithHotel.OrderProvidedServiceForHotel;
import service.Order.InteractWithHotel.OrderProvidedServiceForHotelImpl;
import vo.HotelVO;

/**
 * AllClientHotel ��һ�������࣬�����ͻ������оƵ���Ϣ����������˷��ؾƵ�������Ϣ
 * ���ٶ����ݿ�ķ���
 * @see HotelDao
 * @see OrderProvidedServiceForHotel
 * @see CreateHotelVO
 * */
public class AllClientHotel {
	
	private HotelDao hotelDao;
	private List<HotelVO> hotelVOList;
	private OrderProvidedServiceForHotel orderservice;
	
	/**
	 * ����ΪclientID�Ĺ��캯��
	 * */
	public AllClientHotel (String clientID) {	
		
		hotelDao = HotelDaoImpl.getInstance();
		orderservice = new OrderProvidedServiceForHotelImpl();
		initHotelVOList(clientID);

	}
	
	/**
	 * @param clientID
	 * @return ˽�з���������˳�ʼ��hotelPOList
	 * */
	private void initHotelVOList(String clientID) {
		
		List<HotelPO> hotelPOList = new ArrayList<HotelPO>();
		hotelVOList = new ArrayList<HotelVO>();
		List<String> allOrderInfo = orderservice.getAllClientOrderInfo(clientID);
		for(String orderinfo:allOrderInfo){
			String array[] = orderinfo.split("/");
			hotelPOList.add(hotelDao.getHotelPO(array[4]));//array[4]��hotelID
		}
		
	    for(HotelPO po:hotelPOList){
	    	HotelVO vo =new CreateHotelVO().create(clientID,po);
	    	hotelVOList.add(vo);
	    }//�����HotelVOList�ĳ�ʼ��
	    //��Ҫע����ǿ��ܿͻ����ڲ�ͬ�Ķ�����Ԥ����ͬ�ľƵ꣬��ʱ����ʾ�Ļ����Ƿֿ���ʾ����Ϊ��Ӧ�Ķ����ǲ�һ����
	}

	/**
	 * @return ���ؿͻ������е���ִ�оƵ��HotelVO
	 * */
	public List<HotelVO> getExecutedHotels(){
		
		List<HotelVO> list = new ArrayList<HotelVO>();
		for(HotelVO vo:hotelVOList){
			//������ʵ�־���orderStatus������Ϊ"��ִ��"��"δִ��"��"�쳣"����"�ѳ���"
			if(vo.getOrderStatus().contains("��ִ��")){
				list.add(vo);
			}
		}
		return list;
	}
	
	/**
	 * @return ���ؿͻ������е�δִ�оƵ��HotelVO
	 * */
	public List<HotelVO> getUnexecutedHotels(){
		
		List<HotelVO> list = new ArrayList<HotelVO>();
		for(HotelVO vo:hotelVOList){
			if(vo.getOrderStatus().contains("δִ��")){
				list.add(vo);
			}
		}
		return list;
	}
	
	/**
	 * @return ���ؿͻ������е��ѳ����Ƶ��HotelVO
	 * */
	public List<HotelVO> getWithdrawnHotels(){
		
		List<HotelVO> list = new ArrayList<HotelVO>();
		for(HotelVO vo:hotelVOList){
			if(vo.getOrderStatus().contains("�ѳ���")){
				list.add(vo);
			}
		}
		return list;
	}
	
	/**
	 * @return ���ؿͻ������е��쳣�Ƶ��HotelVO
	 * */
	public List<HotelVO> getAbnormalHotels(){
		
		List<HotelVO> list = new ArrayList<HotelVO>();
		for(HotelVO vo:hotelVOList){
			if(vo.getOrderStatus().contains("�쳣")){
				list.add(vo);
			}
		}
		return list;
	}
	
	/**
	 * @return ����hotelID�����ض�Ӧ��HotelVO
	 * */
	public HotelVO getHotelVO(String hotelID){
		
		for(HotelVO vo:hotelVOList){
			if(hotelID.equals(vo.getHotelID())){
				return vo;
			}
		}
		
		return null;
	}
}
