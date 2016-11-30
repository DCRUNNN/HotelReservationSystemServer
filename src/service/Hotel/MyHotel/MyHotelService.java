package service.Hotel.MyHotel;

import java.util.List;

import vo.HotelVO;

public interface MyHotelService {

	/**
	 * @return 返回已执行的酒店的HotelVO,需要注意返回值可能为空
	 * */
	public List<HotelVO> getExecutedHotels();
	
	/**
	 * @return 返回未执行的酒店的HotelVO,返回值可能为空
	 * */
	public List<HotelVO> getUnexecutedHotels();
	
	/**
	 * @return 返回已撤销的酒店的HotelVO，返回值可能为空
	 * */
	public List<HotelVO> getWithdrawnHotels();
	
	/**
	 * @return 返回异常的酒店的HotelVO，返回值可能为空
	 * */
	public List<HotelVO> getAbnormalHotels();
	
	/**
	 * @param hotelID 选好的酒店编号
	 * @return 根据hotelID 返回一个HotelVO
	 * */
	public HotelVO getHotelVO(String hotelID);
}
