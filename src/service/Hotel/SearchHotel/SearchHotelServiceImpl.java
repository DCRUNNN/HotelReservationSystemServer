package service.Hotel.SearchHotel;

import java.util.ArrayList;
import java.util.List;

import data.dao.HotelDao;
import data.dao.impl.HotelDaoImpl;
import po.HotelPO;
import po.OrderPO;
import service.Hotel.BrowseHotel.AllHotels;
import service.Order.InteractWithHotel.OrderProvidedServiceForHotel;
import service.Order.InteractWithHotel.OrderProvidedServiceForHotelImpl;
import vo.HotelVO;
import vo.OrderVO;
import vo.SearchVO;

/**
 * SearchHotelService的实现类
 * @see AllHotels
 * @see Search
 * */
public class SearchHotelServiceImpl implements SearchHotelService{

	private String clientID;
	private AllHotels allhotel;
	private Search searchHotel;//Search类的实例化放在getAllHotels方法内 调用search方法一定要在getAllHotels方法后
	private OrderProvidedServiceForHotel orderService;
	private HotelDao hotelDao;
	
	public SearchHotelServiceImpl(String clientID){
		
		allhotel = new AllHotels(clientID);
		this.clientID = clientID;
		orderService = new OrderProvidedServiceForHotelImpl();
		hotelDao = HotelDaoImpl.getInstance();
	}
	@Override
	public String getAllProvinces() {
		
		return allhotel.getProvinces();
	}
	@Override
	public String getCities(String hotelProvince) {
		
		return allhotel.getCities(hotelProvince);
	}
	@Override
	public String getCBDS(String hotelProvince,String hotelCity) {
		return allhotel.getCBDS(hotelProvince,hotelCity);
	}

	@Override
	public HotelVO getHotelVO(String hotelID) {
		return allhotel.getHotelVO(hotelID);
	}

	@Override
	public List<HotelVO> search(SearchVO vo) {
		return searchHotel.search(vo);
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
	public void getAllHotels(String hotelProvince,String hotelCity, String hotelCBD) {
		
		List<HotelVO> list = allhotel.getAllHotels(hotelCBD);
		searchHotel = new Search(list);
		
	}
	

}
