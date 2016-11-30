package service.Hotel.SearchHotel;

import java.util.List;

import vo.HotelVO;
import vo.OrderVO;
import vo.SearchVO;

public interface SearchHotelService {

	/**
	 * @return 得到所有有酒店的省份
	 * */
	public String getAllProvinces ();
	
	/**
	 * @param hotelProvince 酒店所在的省份
	 * @return 得到该省份的所有有酒店的市 市1+"/"+市2
	 * */
	public String getCities(String hotelProvince);
	
	/**
	 * @param hotelProvince 酒店省份
	 * @param hotelCity 酒店市
	 * @return 返回特定地址的所有商圈（商圈1+"/"+商圈2）
	 * */
	public String getCBDS(String hotelProvince,String hotelCity);
	
	/**
	 * @param hotelID
	 * @return 根据酒店id 返回一个HotelVO,返回的可能为空
	 * */
	public HotelVO getHotelVO(String hotelID);
	
	/**
	 * @param SearchVO
	 * @return 根据搜索条件返回 符合条件的HotelVO列表 返回可能为空
	 * */
	public List<HotelVO> search(SearchVO vo);
	
	/**
	 * @param hotelID
	 * @return 返回客户在某个酒店的所有历史订单列表 返回可能为空
	 * */
	public List<OrderVO> getAllOrders(String hotelID);
	
	/**
	 * @param hotelProvince 酒店所在的省份
	 * @param hotelCities 酒店所在的市
	 * @param hotelCBD 酒店所在的商圈
	 * @return 对应的是客户选择好酒店商圈之后 给impl类提供hotelCBD来完成相应的初始化操作，点下确定按钮的事件
	 * */
	public void getAllHotels(String hotelProvince,String hotelCities,String hotelCBD);
}
