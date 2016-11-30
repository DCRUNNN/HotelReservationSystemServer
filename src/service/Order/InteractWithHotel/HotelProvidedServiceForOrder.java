package service.Order.InteractWithHotel;

public interface HotelProvidedServiceForOrder {
	
	/**
	 * @param hotelID,clientID,评论的内容，对酒店设施的评分，对酒店服务的评分，对酒店周边环境的评分
	 * 实现的时候记住评论人数加一
	 * @return 返回是否评论成功
	 * */
	public boolean addComment(String hotelID,String clientID,String comment,int point_facilities,int point_service,int point_surroundings);
	
	/**
	 * @param hotelID,clientID,追加的评论内容
	 * 传来的参数是原来的评论+"|"+追加的评论
	 * @return 返回是否追加成功
	 * */
	public boolean addComment(String hotelID,String clientID,String comment);
	
	/**
	 * @param 酒店编号
	 * @return 返回一个酒店所有类型和价格的字符串（类型+"|"+价格+"/"）
	 * */
	public String getRoomTypeAndPrice(String hotelID);
	
	/**
	 * @param hotelID 酒店编号
	 * @return 得到酒店的省份
	 * */
	public String getHotelProvince(String hotelID);
	
	/**
	 * @param hotelID 酒店编号
	 * @return 得到酒店所在的市
	 * */
	public String getHotelCity(String hotelID);
	
	/**
	 * @param hotelID 酒店编号
	 * @return 得到酒店所在的商圈
	 * */
	public String getHotelCBD(String hotelID);
	
	/**
	 * @param hotelID 酒店编号
	 * @return 得到酒店的详细地址
	 * */
	public String getHotelAddress(String hotelID);
	
	/**
	 * @param hotelID 酒店编号
	 * @return 得到酒店的名称
	 * */
	public String getHotelName(String hotelID);
	
}
