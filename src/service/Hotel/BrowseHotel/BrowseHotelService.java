package service.Hotel.BrowseHotel;

import java.util.List;

import vo.HotelVO;
import vo.OrderVO;

public interface BrowseHotelService {

	/**
	 * @return 得到数据库里面的所有酒店的省份(省份1+"/"+省份2)
	 * */
	public String getProvinces();
	
	/**
	 * @param 酒店所在省份
	 * @return 得到数据库里面的在特定省份的酒店的市(市1+"/"+市2)
	 * */
	public String getCities(String hotelProvince);
	
	/**
	 * @param hotelProvince 酒店省份,hotelCity 酒店所在市
	 * @return 根据酒店所在的省份和酒店所在的市，返回该地区内的所有商圈(商圈1+"/"+商圈2)
	 * */
	public String getCBDS(String hotelProvince,String hotelCity);
	
	/**
	 * @param hotelProvince 酒店省份 hotelCity 酒店所在市 hotelCBD 酒店所在的商圈
	 * @return 根据输入的酒店地址和酒店商圈，返回一个该地址该商圈内的所有酒店的HotelVO列表，默认是按照评分顺序从高到底返回的
	 * */
	public List<HotelVO> getAllHotels(String hotelProvince,String hotelCity,String hotelCBD);
	
	/**
	 * @param hotelID
	 * @return 根据输入的hotelID，返回一个HotelVO
	 * */
	public HotelVO getHotelVO(String hotelID);
	
	/**
	 * @param hotelID
	 * @return 根据酒店的ID，获得客户在该酒店的所有订单
	 * */
	public List<OrderVO> getAllOrders(String hotelID);
	
	/**
	 * @return 需要注意的是只有在调用getAllHotels方法之后才能调用这些方法
	 * 按星级从大到小的顺序显示酒店信息
	 * */
	public List<HotelVO> showHotelByStar();
	
	/**
	 * @return 按综合评分顺序显示酒店信息
	 * */
	public List<HotelVO> showHotelByPoint();
	
	/**
	 * @return 按酒店最低价格显示酒店信息
	 * */
	public  List<HotelVO> showHotelByPrice();
	
	/**
	 * @return 返回曾经预订过的酒店列表
	 * */
	public List<HotelVO> showHotelOrdered();
}
