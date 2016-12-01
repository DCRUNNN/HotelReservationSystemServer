package service.Hotel.MaintainHotelMessage;

import data.dao.HotelDao;
import data.dao.impl.HotelDaoImpl;
import po.HotelPO;
import vo.HotelVO;

/**
 * MaintainHotelMessageService接口的实现类
 * @see HotelDao
 * */
public class MaintainHotelMessageServiceImpl implements MaintainHotelMessageService{

	private String hotelID;
	private HotelDao hotelDao;
	
	public MaintainHotelMessageServiceImpl(String hotelID){
		this.hotelID = hotelID;
		hotelDao = HotelDaoImpl.getInstance();
	}
	
	@Override
	public boolean changeHotelInfo(String hotelProvince,String hotelCity, String hotelCBD,String hotelAddress,String hotelName, String introduction, String facilities,
			int star, String roomTypeAndPrices) {
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		po.setHotelProvince(hotelProvince);
		po.setHotelCity(hotelCity);
		po.setHotelCBD(hotelCBD);
		po.setHotelAddress(hotelAddress);
		po.setHotelName(hotelName);
		po.setIntroduction(introduction);
		po.setFacilities(facilities);
		po.setHotelStar(star);
		po.setRoomTypeAndPrice(roomTypeAndPrices);
		return hotelDao.change(po);
	}

	@Override
	public HotelVO getHotelVO() {
		
		HotelPO po = hotelDao.getHotelPO(hotelID);//可能为空的
		if(po==null){
			return null;
		}else{
			//这里需要注意一下，有控制耦合的
			HotelVO vo = new HotelVO("//// ",po);
			return vo;
		}
	}

	@Override
	public boolean changeHotelInfo(HotelVO vo) {
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		po.setHotelProvince(vo.getHotelProvince());
		po.setHotelCity(vo.getHotelCity());
		po.setHotelCBD(vo.getHotelCBD());
		po.setHotelAddress(vo.getHotelAddress());
		po.setHotelName(vo.getHotelName());
		po.setHotelStar(vo.getHotelStar());
		po.setFacilities(vo.getFacilities());
		po.setIntroduction(vo.getIntroduction());
		po.setRoomTypeAndPrice(vo.getRoomTypeAndPrice());
		return hotelDao.change(po);
	}

}
