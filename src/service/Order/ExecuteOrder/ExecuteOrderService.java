package service.Order.ExecuteOrder;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.OrderVO;

public interface ExecuteOrderService extends Remote{

	/**
	 * @param hotelID 酒店编号
	 * @param clientID 客户编号
	 * @return 返回客户在酒店的所有未执行订单信息
	 * 这个方法对应的是按下执行订单，输入完客户编号的事件
	 * */
	public List<OrderVO> getUnexecutedOrders(String hotelID,String clientID)throws RemoteException;
	
	/**
	 * @param hotelID 酒店编号
	 * @param clientID 客户编号
	 * @return 返回客户在酒店的所有异常订单信息
	 * 这个方法对应的是客户按下延迟入住之后 对应的事件
	 * */
	public List<OrderVO> getAbnormalOrders(String hotelID,String clientID)throws RemoteException;
	
	/**
	 * @param clientID
	 * @return 返回客户在酒店的预订房间的所有类型(类型1+"/"+类型2)
	 * */
	public String getAllRoomType(String orderID)throws RemoteException;
	
	/**
	 * @param 客户编号
	 * @return 返回客户在该酒店的所有房间号码(房间1+"/"+房间2)
	 * 相对应的就是 输入客户id 之后的点击确定按钮的事件
	 * 方法调用的顺序一定要保证 先调用getAllRoomNumber 在其他的设置之前
	 * */
	public String getAllRoomNumber(String orderID)throws RemoteException;
	
	/**
	 * @return 返回的是客户延期入住的房间号码（若之前的房间没有被预订，那么还是之前的房间号码，如果被预订了，
	 * 随机选择符合条件的号码，如果酒店的房间不足，那么返回就是对应的位置为"无空闲房间"）
	 * 相对应的是"延迟入住"按钮按下之后 输入客户id后选择好订单之后的确认事件
	 * 延迟入住在之前订单变异常时扣除了客户的订单价格一半的信用点 
	 * 在客户重新办理入住之后 增加订单一半的信用点 相当于不增加也不减少 这样是很合理的
	 * */
	public String getDelayRoomNumber(String orderID)throws RemoteException;

	/**
	 * @param 房间号码,入住人数
	 * @return 完成了设置对应的房间的入住人数
	 * */
	public void setRoomPeople(String roomNumber,int peopleNumebr)throws RemoteException;
	
	/**
	 * @param 房间号码，有无儿童
	 * @return 完成了设置对应的房间的有无儿童
	 * */
	public void setRoomChild(String roomNumber,boolean hasChild)throws RemoteException;
	
	/**
	 * @return 完成了订单的执行，包括改变订单状态，把改变后的订单数据重新写入数据库，增加客户的信用点，生成信用记录
	 * 改变房间状态
	 * */
	public boolean executeOrder()throws RemoteException;
}
