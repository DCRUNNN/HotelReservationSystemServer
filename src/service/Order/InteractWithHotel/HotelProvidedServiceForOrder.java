package service.Order.InteractWithHotel;

public interface HotelProvidedServiceForOrder {

	/**
	 * @param hotelID
	 * @return 返回一个hotelInfo hotelInfo = hotelID+hotelProvince+hotelCity+hotelCBD+hotelName 分隔符是"/"
	 * */
	public String getHotelInfo(String hotelID);
	
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
}
