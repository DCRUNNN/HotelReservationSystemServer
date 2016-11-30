package service.Hotel.MaintainHotelMessage;

import data.dao.HotelDao;
import data.dao.impl.HotelDaoImpl;
import po.HotelPO;
import vo.HotelVO;

/**
 * MaintainHotelMessageService�ӿڵ�ʵ����
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
	public boolean changeHotelInfo(String hotelProvince,String hotelCity, String hotelCBD, String introduction, String facilities,
			int star, String roomTypeAndPrices) {
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		po.setHotelProvince(hotelProvince);
		po.setHotelCity(hotelCity);
		po.setHotelCBD(hotelCBD);
		po.setIntroduction(introduction);
		po.setFacilities(facilities);
		po.setHotelStar(star);
		po.setRoomTypeAndPrice(roomTypeAndPrices);
		return hotelDao.change(po);
	}

	@Override
	public HotelVO getHotelVO() {
		
		
		HotelPO po = hotelDao.getHotelPO(hotelID);//����Ϊ�յ�
		if(po==null){
			return null;
		}else{
			//������Ҫע��һ�£��п�����ϵ�
			HotelVO vo = new HotelVO("//// ",po);
			return vo;
		}
	}

}