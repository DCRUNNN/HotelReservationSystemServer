package service.Hotel.MyHotel;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.dao.HotelDao;
import data.dao.impl.HotelDaoImpl;
import po.HotelPO;
import service.Hotel.help.CreateHotelVO;
import service.Order.InteractWithHotel.OrderProvidedServiceForHotel;
import service.Order.InteractWithHotel.OrderProvidedServiceForHotelImpl;
import vo.HotelVO;

/**
 * MyHotelService接口的具体实现类
 * @see AllClientHotel 
 * */
public class MyHotelServiceImpl implements MyHotelService{
	
	private HotelDao hotelDao;
	private OrderProvidedServiceForHotel orderservice;
	private List<HotelVO> allHotels;
	
	public MyHotelServiceImpl(){
		
		hotelDao = HotelDaoImpl.getInstance();
		orderservice = new OrderProvidedServiceForHotelImpl();
		allHotels = new ArrayList<HotelVO>();
	}
	
	@Override
	public List<HotelVO> getExecutedHotels(String clientID) throws RemoteException{
		
		if(allHotels.size()==0){
			initAllHotels(clientID);
		}
		
		List<HotelVO> list = new ArrayList<HotelVO>();
		for(HotelVO vo:allHotels){
			//基本的实现就是orderStatus的内容为"已执行"，"未执行"，"异常"或者"已撤销"
			if(vo.getOrderStatus().contains("已执行")){
				list.add(vo);
			}
		}
		return list;
	
	}

	private void initAllHotels(String clientID) {

		//当allHotels里面没有内容的时候
		List<HotelPO> hotelPOList = new ArrayList<HotelPO>();
		List<String> allOrderInfo = orderservice.getAllClientOrderInfo(clientID);
		for(String orderinfo:allOrderInfo){
			String array[] = orderinfo.split("/");
			hotelPOList.add(hotelDao.getHotelPO(array[4]));//array[4]是hotelID
		}
		
		for(HotelPO po:hotelPOList){
			HotelVO vo = new CreateHotelVO().create(clientID, po);
			allHotels.add(vo);
		}//把客户的所有酒店信息加入到allHotels
	
	}

	@Override
	public List<HotelVO> getUnexecutedHotels(String clientID) throws RemoteException{
		
		if(allHotels.size()==0){
			initAllHotels(clientID);
		}
		
		List<HotelVO> list = new ArrayList<HotelVO>();
		for(HotelVO vo:allHotels){
			//基本的实现就是orderStatus的内容为"已执行"，"未执行"，"异常"或者"已撤销"
			if(vo.getOrderStatus().contains("未执行")){
				list.add(vo);
			}
		}
		return list;
	
	}

	@Override
	public List<HotelVO> getWithdrawnHotels(String clientID)throws RemoteException {
		
		if(allHotels.size()==0){
			initAllHotels(clientID);
		}
		
		List<HotelVO> list = new ArrayList<HotelVO>();
		for(HotelVO vo:allHotels){
			//基本的实现就是orderStatus的内容为"已执行"，"未执行"，"异常"或者"已撤销"
			if(vo.getOrderStatus().contains("已撤销")){
				list.add(vo);
			}
		}
		return list;
	
	}

	@Override
	public List<HotelVO> getAbnormalHotels(String clientID) throws RemoteException{
		
		if(allHotels.size()==0){
			initAllHotels(clientID);
		}
		
		List<HotelVO> list = new ArrayList<HotelVO>();
		for(HotelVO vo:allHotels){
			//基本的实现就是orderStatus的内容为"已执行"，"未执行"，"异常"或者"已撤销"
			if(vo.getOrderStatus().contains("异常")){
				list.add(vo);
			}
		}
		return list;
	
	}

	@Override
	public HotelVO getHotelVO(String clientID,String hotelID) throws RemoteException{
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		if(po==null){
			return null;
		}
		
		return new CreateHotelVO().create(clientID, po);
	}

}
