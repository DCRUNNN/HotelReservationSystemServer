package service.Hotel.MaintainHotelMessage;

import vo.HotelVO;

public interface MaintainHotelMessageService {

	/**
	 * @param hotelProvince 酒店省份
	 * @param hotelCity 酒店市
	 * @param hotelCBD 酒店商圈
	 * @param introduction 酒店简介
	 * @param facilities 酒店设施
	 * @param star 酒店星级
	 * @param roomTypeAndPrices 房间类型+"|"+价格+"/"+房间类型+"|"+价格
	 * 修改酒店的基本信息
	 * */
	public boolean changeHotelInfo(String hotelProvince,String hotelCity,String hotelCBD,String introduction,String facilities,int star,String roomTypeAndPrices);
	
	/**
	 * @return 得到修改前的酒店信息,返回的HotelVO可能为空
	 * */
	public HotelVO getHotelVO();
}
