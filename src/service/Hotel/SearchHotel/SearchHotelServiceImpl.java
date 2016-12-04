package service.Hotel.SearchHotel;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.dao.HotelDao;
import data.dao.impl.HotelDaoImpl;
import po.HotelPO;
import po.OrderPO;
import service.Client.InteractWithHotel.ClientProvidedServiceForHotel;
import service.Hotel.help.CreateHotelVO;
import service.Order.InteractWithHotel.OrderProvidedServiceForHotel;
import service.Order.InteractWithHotel.OrderProvidedServiceForHotelImpl;
import vo.HotelVO;
import vo.OrderVO;
import vo.SearchVO;

/**
 * SearchHotelService的实现类
 * @see Search
 * */
public class SearchHotelServiceImpl implements SearchHotelService{

	private Search searchHotel;//Search类的实例化放在getAllHotels方法内 调用search方法一定要在getAllHotels方法后
	private OrderProvidedServiceForHotel orderService;
	private ClientProvidedServiceForHotel clientservice;
	private HotelDao hotelDao;
	private CreateHotelVO help;
	
	public SearchHotelServiceImpl(){
		
		orderService = new OrderProvidedServiceForHotelImpl();
		hotelDao = HotelDaoImpl.getInstance();
		help = new CreateHotelVO();
	}
	@Override
	public String getAllProvinces()throws RemoteException {
		
		return hotelDao.getProvinces();
	}
	@Override
	public String getCities(String hotelProvince) throws RemoteException{
		
		return hotelDao.getCities(hotelProvince);
	}
	@Override
	public String getCBDS(String hotelProvince,String hotelCity) throws RemoteException{
		return hotelDao.getCBDS(hotelProvince,hotelCity);
	}

	@Override
	public HotelVO getHotelVO(String clientID,String hotelID) throws RemoteException{
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		
		return help.create(clientID, po);
	}

	@Override
	public List<HotelVO> search(SearchVO vo) throws RemoteException{
		return searchHotel.search(vo);
	}

	@Override
	public List<OrderVO> getAllOrders(String clientID,String hotelID) throws RemoteException{
		
		List<OrderPO> polist =  orderService.getAllOrdersOfClientInaHotel(clientID,hotelID);
		List<OrderVO> volist = new ArrayList<OrderVO>();
		
		if(polist==null){
			return volist;
		}
		
		HotelPO hotelPO = hotelDao.getHotelPO(hotelID);
		for(OrderPO orderpo:polist){
			
			String clientName = clientservice.getClientName(clientID);
			String sex = clientservice.getSex(clientID);
			String identityID = clientservice.getIdentityID(clientID);
			String phoneNumebr = clientservice.getPhoneNumber(clientID);
			OrderVO ordervo = new OrderVO(orderpo,hotelPO.getHotelProvince(),hotelPO.getHotelCity(),hotelPO.getHotelCBD(),hotelPO.getHotelAddress(),hotelPO.getHotelName(),clientName,sex,identityID,phoneNumebr);
			volist.add(ordervo);
		}
		return volist;
	}
	
	@Override
	public void initAllHotel(String clientID,String hotelProvince,String hotelCity, String hotelCBD) throws RemoteException{
		
		List<HotelPO> list = hotelDao.getAllHotel(hotelProvince, hotelCity, hotelCBD);
		List<HotelVO> polist = new ArrayList<HotelVO>();
		for(HotelPO po:list){
			HotelVO vo = help.create(clientID, po);
			polist.add(vo);
		}
		
		searchHotel = new Search(polist);
	}
	

}
