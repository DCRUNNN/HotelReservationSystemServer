package service.Order.CreateOrder;

public interface CreateOrderService {

	/**
	 * @return 返回酒店房间类型+"|"+房间价格+"/"+房间类型+"|"+房间价格
	 * */
	public String getRoomTypeAndPrice ();
	
	/**
	 * @param 房间类型(注意是单一的房间类型，不是用"/"分隔的全部房间类型)
	 * @return 返回符合类型的所有可选的房间号码 (用"/"分隔)
	 * */
	public String getAllRoomNumber(String roomType);
	
	/**
	 * @param 房间数目,房间类型(多个房间roomType+"/"+roomType),房间号码(多个房间roomNumebr+"/"+roomNumber)
	 * @return 生成订单
	 * */
	public boolean createOrder(int roomTotal,String roomType,String roomNumber);
	
	/**
	 * @param 房间号码(number+"/"+number)
	 * @return 返回在最优策略下的总房间价格
	 * */
	public double getPriceByStrategy(String roomNumber);
	
	/**
	 * @return 判断客户信用点是否大于0，大于等于0返回true，小于0返回false
	 * */
	public boolean checkCreditPoint();
	
}
