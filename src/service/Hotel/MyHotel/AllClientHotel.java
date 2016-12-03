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
 * AllClientHotel 是一个容器类，包含客户的所有酒店信息，并且完成了返回酒店的相关信息
 * 减少对数据库的访问
 * @see HotelDao
 * @see OrderProvidedServiceForHotel
 * @see CreateHotelVO
 * */
public class AllClientHotel {
	
	private HotelDao hotelDao;
	private List<HotelVO> hotelVOList;
	private OrderProvidedServiceForHotel orderservice;
	
	/**
	 * 参数为clientID的构造函数
	 * */
	public AllClientHotel (String clientID) {	
		
		hotelDao = HotelDaoImpl.getInstance();
		orderservice = new OrderProvidedServiceForHotelImpl();
		initHotelVOList(clientID);

	}
	
	/**
	 * @param clientID
	 * @return 私有方法，完成了初始化hotelPOList
	 * */
	private void initHotelVOList(String clientID) {
		
		List<HotelPO> hotelPOList = new ArrayList<HotelPO>();
		hotelVOList = new ArrayList<HotelVO>();
		List<String> allOrderInfo = orderservice.getAllClientOrderInfo(clientID);
		for(String orderinfo:allOrderInfo){
			String array[] = orderinfo.split("/");
			hotelPOList.add(hotelDao.getHotelPO(array[4]));//array[4]是hotelID
		}
		
	    for(HotelPO po:hotelPOList){
	    	HotelVO vo =new CreateHotelVO().create(clientID,po);
	    	hotelVOList.add(vo);
	    }//完成了HotelVOList的初始化
	    //需要注意的是可能客户会在不同的订单里预订相同的酒店，这时候显示的话还是分开显示，因为对应的订单是不一样的
	}

	/**
	 * @return 返回客户的所有的已执行酒店的HotelVO
	 * */
	public List<HotelVO> getExecutedHotels(){
		
		List<HotelVO> list = new ArrayList<HotelVO>();
		for(HotelVO vo:hotelVOList){
			//基本的实现就是orderStatus的内容为"已执行"，"未执行"，"异常"或者"已撤销"
			if(vo.getOrderStatus().contains("已执行")){
				list.add(vo);
			}
		}
		return list;
	}
	
	/**
	 * @return 返回客户的所有的未执行酒店的HotelVO
	 * */
	public List<HotelVO> getUnexecutedHotels(){
		
		List<HotelVO> list = new ArrayList<HotelVO>();
		for(HotelVO vo:hotelVOList){
			if(vo.getOrderStatus().contains("未执行")){
				list.add(vo);
			}
		}
		return list;
	}
	
	/**
	 * @return 返回客户的所有的已撤销酒店的HotelVO
	 * */
	public List<HotelVO> getWithdrawnHotels(){
		
		List<HotelVO> list = new ArrayList<HotelVO>();
		for(HotelVO vo:hotelVOList){
			if(vo.getOrderStatus().contains("已撤销")){
				list.add(vo);
			}
		}
		return list;
	}
	
	/**
	 * @return 返回客户的所有的异常酒店的HotelVO
	 * */
	public List<HotelVO> getAbnormalHotels(){
		
		List<HotelVO> list = new ArrayList<HotelVO>();
		for(HotelVO vo:hotelVOList){
			if(vo.getOrderStatus().contains("异常")){
				list.add(vo);
			}
		}
		return list;
	}
	
	/**
	 * @return 根据hotelID，返回对应的HotelVO
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
