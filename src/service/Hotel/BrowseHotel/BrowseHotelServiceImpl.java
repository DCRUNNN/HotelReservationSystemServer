package service.Hotel.BrowseHotel;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.dao.HotelDao;
import data.dao.impl.HotelDaoImpl;
import po.HotelPO;
import po.OrderPO;
import service.Client.InteractWithHotel.ClientProvidedServiceForHotel;
import service.Client.InteractWithHotel.ClientProvidedServiceForHotelImpl;
import service.Hotel.help.CreateHotelVO;
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

	private CreateHotelVO help;
	private OrderProvidedServiceForHotel orderService;
	private ClientProvidedServiceForHotel clientservice;
	private HotelDao hotelDao;
	
	public BrowseHotelServiceImpl(){
		
		help = new CreateHotelVO();
		clientservice = new ClientProvidedServiceForHotelImpl();
		orderService = new OrderProvidedServiceForHotelImpl();
	    hotelDao = HotelDaoImpl.getInstance();
	}
	
	@Override
	public String getProvinces() throws RemoteException{
		
		return hotelDao.getProvinces();
	}

	@Override
	public String getCities(String hotelProvince)throws RemoteException {

		return hotelDao.getCities(hotelProvince);
	}
	
	@Override
	public String getCBDS(String hotelProvince, String hotelCity)throws RemoteException {
		
		return hotelDao.getCBDS(hotelProvince,hotelCity);
	}

	@Override
	public List<HotelVO> getAllHotels(String clientID,String hotelProvince, String hotelCity, String hotelCBD) throws RemoteException{
		
		List<HotelPO> list = hotelDao.getAllHotel(hotelProvince, hotelCity, hotelCBD);
		List<HotelVO> polist = new ArrayList<HotelVO>();
		for(HotelPO po:list){
			HotelVO vo = help.create(clientID, po);
			polist.add(vo);
		}
		return polist;
	}

	@Override
	public HotelVO getHotelVO(String clientID,String hotelID) throws RemoteException{
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		
		return help.create(clientID, po);
	}

	@Override
	public List<OrderVO> getAllOrders(String clientID,String hotelID) throws RemoteException{
		
		List<OrderPO> polist =  orderService.getAllOrdersOfClientInaHotel(clientID,hotelID);
		if(polist==null){
			return null;
		}
		
		List<OrderVO> volist = new ArrayList<OrderVO>();
		HotelPO hotelPO = hotelDao.getHotelPO(hotelID);
		for(OrderPO orderpo:polist){	
			String clientName = clientservice.getClientName(clientID);
			String sex = clientservice.getSex(clientID);
			String identityID = clientservice.getIdentityID(clientID);
			String phoneNumebr = clientservice.getPhoneNumber(clientID);
		    String vipInfo = clientservice.getVIPInfo(clientID);
		    double credit = clientservice.getCredit(clientID);
		    
			OrderVO ordervo = new OrderVO(orderpo,hotelPO.getHotelProvince(),hotelPO.getHotelCity(),hotelPO.getHotelCBD(),hotelPO.getHotelAddress(),hotelPO.getHotelName(),clientName,sex,identityID,phoneNumebr,credit,vipInfo);
			volist.add(ordervo);
		}
		return volist;
	}
	
}
