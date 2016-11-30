package service.Hotel.MyHotel;

import java.util.List;

import vo.HotelVO;

/**
 * MyHotelService接口的具体实现类
 * @see AllClientHotel 
 * */
public class MyHotelServiceImpl implements MyHotelService{

	private AllClientHotel allHotel;
	
	public MyHotelServiceImpl(String clientID){
		allHotel = new AllClientHotel(clientID);
	}
	
	@Override
	public List<HotelVO> getExecutedHotels() {
		return allHotel.getExecutedHotels();
	}

	@Override
	public List<HotelVO> getUnexecutedHotels() {
		return allHotel.getUnexecutedHotels();
	}

	@Override
	public List<HotelVO> getWithdrawnHotels() {
		return allHotel.getWithdrawnHotels();
	}

	@Override
	public List<HotelVO> getAbnormalHotels() {
		return allHotel.getAbnormalHotels();
	}

	@Override
	public HotelVO getHotelVO(String hotelID) {
		return allHotel.getHotelVO(hotelID);
	}

}
