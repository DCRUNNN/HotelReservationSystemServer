package service.Hotel.BrowseHotel;

import java.util.ArrayList;
import java.util.List;

import data.dao.HotelDao;
import data.dao.impl.HotelDaoImpl;
import po.HotelPO;
import po.OrderPO;
import service.Order.InteractWithHotel.OrderProvidedServiceForHotel;
import service.Order.InteractWithHotel.OrderProvidedServiceForHotelImpl;
import vo.HotelVO;
import vo.OrderVO;

/**
 * BrowseHotelService的实现类 
 * @see AllHotels 
 * @see AllClientOrderOfaHotel 
 * */
public class BrowseHotelServiceImpl implements BrowseHotelService{

	private String clientID;
	private AllHotels allhotel;
	private OrderProvidedServiceForHotel orderService;
	private HotelDao hotelDao;
	
	public BrowseHotelServiceImpl(String clientID){
		
		this.clientID = clientID;
		allhotel = new AllHotels(clientID);
		orderService = new OrderProvidedServiceForHotelImpl();
	    hotelDao = HotelDaoImpl.getInstance();
	}
	
	@Override
	public String getProvinces() {
		
		return allhotel.getProvinces();
	}

	@Override
	public String getCities(String hotelProvince) {

		return allhotel.getCities(hotelProvince);
	}
	
	@Override
	public String getCBDS(String hotelProvince, String hotelCity) {
		
		return allhotel.getCBDS(hotelProvince,hotelCity);
	}

	@Override
	public List<HotelVO> getAllHotels(String hotelProvince, String hotelCity, String hotelCBD) {
		
		return allhotel.getAllHotels(hotelCBD);
	}

	@Override
	public HotelVO getHotelVO(String hotelID) {
		return allhotel.getHotelVO(hotelID);
	}

	@Override
	public List<OrderVO> getAllOrders(String hotelID) {
		
		List<OrderPO> polist =  orderService.getAllOrdersOfClientInaHotel(clientID,hotelID);
		if(polist==null){
			return null;
		}
		
		List<OrderVO> volist = new ArrayList<OrderVO>();
		HotelPO hotelPO = hotelDao.getHotelPO(hotelID);
		String hotelInfo = hotelPO.getHotelID()+"/"+hotelPO.getHotelProvince()+"/"+hotelPO.getHotelCity()+"/"+hotelPO.getHotelCBD()+"/"
		+hotelPO.getHotelName();
		for(OrderPO orderpo:polist){
			OrderVO ordervo = new OrderVO(orderpo,hotelInfo);
			volist.add(ordervo);
		}
		return volist;
	}

	@Override
	public List<HotelVO> showHotelByStar() {
		
		return allhotel.showByStar();
	}

	@Override
	public List<HotelVO> showHotelByPoint() {
		
		return allhotel.showByPoint();
	}

	@Override
	public List<HotelVO> showHotelByPrice() {
		
		return allhotel.showByprice();
	}

	@Override
	public List<HotelVO> showHotelOrdered() {
		
		return allhotel.showHotelOrdered();
	}

	
}
