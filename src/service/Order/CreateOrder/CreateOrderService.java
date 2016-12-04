package service.Order.CreateOrder;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CreateOrderService extends Remote{

	/**
	 * @param hotelID 酒店编号
	 * @return 返回酒店房间类型+"|"+房间价格+"/"+房间类型+"|"+房间价格
	 * */
	public String getRoomTypeAndPrice (String hotelID)throws RemoteException;
	
	/**
	 * @param hotelID 酒店编号
	 * @param 房间类型(注意是单一的房间类型，不是用"/"分隔的全部房间类型)
	 * @return 返回符合类型的所有可选的房间号码 (用"/"分隔)(返回的都是空闲状态的房间)
	 * */
	public String getAllRoomNumber(String hotelID,String roomType)throws RemoteException;
	
	/**
	 * @param hotelID 酒店编号
	 * @param clientID 客户编号
	 * @param roomType 房间类型(多个房间roomType+"/"+roomType)
	 * @param roomNumber 房间号码(多个房间roomNumebr+"/"+roomNumber)
	 * @return 生成订单
	 * */
	public boolean createOrder(String hotelID,String clientID,String roomType,String roomNumber)throws RemoteException;
	
	/**
	 * @param hotelID 酒店编号
	 * @param clientID 客户编号
	 * @param roomNumber number1+"/"+number2 选中的房间号码
	 * @return 返回在最优策略下的总房间价格
	 * */
	public double getPriceByStrategy(String hotelID,String clientID,String roomNumber)throws RemoteException;
	
	/**
	 * @param clientID 客户编号
	 * @return 判断客户信用点是否大于0，大于等于0返回true，小于0返回false
	 * */
	public boolean checkCreditPoint(String clientID)throws RemoteException;
	
}
