package data.datahelper.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.datahelper.OrderDataHelper;
import po.OrderPO;

public class OrderDataSqlHelperImpl implements OrderDataHelper{

	private static final String DBDRIVER = "org.gjt.mm.mysql.Driver";//数据库连接驱动类
	private static final String DBURL = "jdbc:mysql://localhost:3306/bighomework";//url
	private static final String DBUSER = "root";
	private static final String DBPASS = "mysql";
	private static Connection conn = null;
	
	public OrderDataSqlHelperImpl (){
		
		try{
			if(conn==null){
				Class.forName(DBDRIVER);
				conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			}
		}catch(Exception e){
			e.printStackTrace();
		}//获得连接对象
	}
	
	/**
	 *@param sql sql语句
	 *@return ResultSet 进行sql搜索语句返回的结果 
	 * */
	private static ResultSet executeQuery(String sql){
		//数据库的查询方法
		Statement statement = null;
		try{
			if(conn==null){
				new PersonnelDataSqlHelperImpl();
			}
			statement = conn.createStatement();
			return statement.executeQuery(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param sql sql语句
	 * @return 返回影响的行数，没有的话返回0，抛异常的话返回-1
	 * */
	private static int executeUpdate (String sql){
		//sql语句必须是insert,update,delete执行完之后返回影响表的行数
		Statement statement =null;
		try{
			if(conn==null){
				new PersonnelDataSqlHelperImpl();
			}
			statement = conn.createStatement();
			return statement.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1;
	}
	
	public static void close(){
		//关闭方法
		try{
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			conn =null;//最后设置连接对象为空
		}
	}
	
	//public static void main(String args[]){
		/*OrderPO po = new OrderPO();
		po.setOrderID("201610240002");
		new OrderDataSqlHelperImpl().insertNewOrder(po);
		System.out.println(po.getComment());*/
		
		/*List<String> allids = new OrderDataSqlHelperImpl().getAllIDs();
		for(String str:allids){
			System.out.println(str);
		}*/
	//}
	@Override
	public boolean change(OrderPO po) {
		
		String orderid = po.getOrderID();
		String hotelid = po.getHotelID();
		String clientid = po.getClientID();
		String createddate = po.getOrderCreatedDate();
		String begindate = po.getOrderBeginDate();
		String enddate = po.getOrderEndDate();
		String lastdate = po.getOrderLastDate();
		double price = po.getPrice();
		int roomtotal = po.getRoomTotal();
		String roomtype = po.getRoomType();
		String roomnumber = po.getRoomNumber();
		String peoplenumber = po.getPeopleNumber();
		String haschild = po.getHasChild();
		String orderstatus = po.getOrderStatus();
		String withdrawtime = po.getWithdrawTime();
		String comment = po.getComment();
		
		String sql = "update t_order set hotelid='"+hotelid+"',clientid='"+clientid+"',createddate='"+createddate+"',begindate='"+begindate
				+"',enddate='"+enddate+"',lastdate='"+lastdate+"',price="+price+",roomtotal="+roomtotal+",roomtype='"+roomtype+"',roomnumber='"+roomnumber
				+"',peoplenumber='"+peoplenumber+"',haschild='"+haschild+"',orderstatus='"+orderstatus+"',withdrawtime='"+withdrawtime+"',comment='"+comment+"' where orderid="+orderid;
		
		int i = OrderDataSqlHelperImpl.executeUpdate(sql);
		OrderDataSqlHelperImpl.close();
		if(i==-1){
			return false;
		}
		return true;
	}

	@Override
	public boolean insertNewOrder(OrderPO po) {
		
		String orderid = po.getOrderID();
		String hotelid = po.getHotelID();
		String clientid = po.getClientID();
		String createddate = po.getOrderCreatedDate();
		String begindate = po.getOrderBeginDate();
		String enddate = po.getOrderEndDate();
		String lastdate = po.getOrderLastDate();
		double price = po.getPrice();
		int roomtotal = po.getRoomTotal();
		String roomtype = po.getRoomType();
		String roomnumber = po.getRoomNumber();
		String peoplenumber = po.getPeopleNumber();
		String haschild = po.getHasChild();
		String orderstatus = po.getOrderStatus();
		String withdrawtime = po.getWithdrawTime();
		String comment = po.getComment();
		
		String sql ="insert into t_order(orderid,hotelid,clientid,createddate,begindate,enddate,lastdate,"
				+ "price,roomtotal,roomtype,roomnumber,peoplenumber,haschild,orderstatus,withdrawtime,comment) values"
				+ "('"+orderid+"','"+hotelid+"','"+clientid+"','"+createddate+"','"+begindate+"','"+enddate+"','"+lastdate+"',"
				+price+","+roomtotal+",'"+roomtype+"','"+roomnumber+"','"+peoplenumber+"','"+haschild+"','"+orderstatus+"','"
				+withdrawtime+"','"+comment+"')";
		
		int i =OrderDataSqlHelperImpl.executeUpdate(sql);
		OrderDataSqlHelperImpl.close();
		if(i==-1){
			return false;
		}
		return true;
	}

	@Override
	public OrderPO getOrderPO(String orderID) {
		
		OrderPO po = null;
		String sql = "select *from t_order where orderid="+orderID;
		ResultSet set = OrderDataSqlHelperImpl.executeQuery(sql);
		try {
			while(set.next()){
				//将查询结果每一项的数据取出来
				String orderid = set.getString("orderid");
				String hotelid = set.getString("hotelid");
				String clientid = set.getString("clientid");
				String createddate = set.getString("createddate");
				String begindate = set.getString("begindate");
				String enddate = set.getString("enddate");
				String lastdate = set.getString("lastdate");
				double price = set.getDouble("price");
				int roomtotal = set.getInt("roomtotal");
				String roomtype = set.getString("roomtype");
				String roomnumber = set.getString("roomnumber");
				String peoplenumber = set.getString("peoplenumber");
				String haschild = set.getString("haschild");
				String orderstatus = set.getString("orderstatus");
				String withdrawtime = set.getString("withdrawtime");
				String comment = set.getString("comment");
				
				//将数据形成一个PO传输
				po = new OrderPO();
				po.setOrderID(orderid);
				po.setHotelID(hotelid);
				po.setClientID(clientid);
				po.setOrderCreatedDate(createddate);
				po.setOrderBeginDate(begindate);
				po.setOrderEndDate(enddate);
				po.setOrderLastDate(lastdate);
				po.setPrice(price);
				po.setRoomTotal(roomtotal);
				po.setRoomType(roomtype);
				po.setRoomNumber(roomnumber);
				po.setPeopleNumber(peoplenumber);
				po.setHasChild(haschild);
				po.setOrderStatus(orderstatus);
				po.setWithdrawTime(withdrawtime);
				po.setComment(comment);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		OrderDataSqlHelperImpl.close();
		return po;
	}

	@Override
	public List<OrderPO> getClientOrdersInaHotel(String clientID, String hotelID) {
		
		List<OrderPO> polist = new ArrayList<OrderPO>();
		String sql = "select *from t_order where clientid="+clientID+" and hotelid="+hotelID;
		ResultSet set = OrderDataSqlHelperImpl.executeQuery(sql);
		try {
			while(set.next()){
				//将查询结果每一项的数据取出来
				String orderid = set.getString("orderid");
				String hotelid = set.getString("hotelid");
				String clientid = set.getString("clientid");
				String createddate = set.getString("createddate");
				String begindate = set.getString("begindate");
				String enddate = set.getString("enddate");
				String lastdate = set.getString("lastdate");
				double price = set.getDouble("price");
				int roomtotal = set.getInt("roomtotal");
				String roomtype = set.getString("roomtype");
				String roomnumber = set.getString("roomnumber");
				String peoplenumber = set.getString("peoplenumber");
				String haschild = set.getString("haschild");
				String orderstatus = set.getString("orderstatus");
				String withdrawtime = set.getString("withdrawtime");
				String comment = set.getString("comment");
				
				//将数据形成一个PO传输
				OrderPO po = new OrderPO();
				po = new OrderPO();
				po.setOrderID(orderid);
				po.setHotelID(hotelid);
				po.setClientID(clientid);
				po.setOrderCreatedDate(createddate);
				po.setOrderBeginDate(begindate);
				po.setOrderEndDate(enddate);
				po.setOrderLastDate(lastdate);
				po.setPrice(price);
				po.setRoomTotal(roomtotal);
				po.setRoomType(roomtype);
				po.setRoomNumber(roomnumber);
				po.setPeopleNumber(peoplenumber);
				po.setHasChild(haschild);
				po.setOrderStatus(orderstatus);
				po.setWithdrawTime(withdrawtime);
				po.setComment(comment);
				
				polist.add(po);
		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		OrderDataSqlHelperImpl.close();
		return polist;
	}

	@Override
	public List<OrderPO> getOrderPOList(String clientID) {
		
		List<OrderPO> list = new ArrayList<OrderPO>();
		String sql = "select *from t_order where clientid="+clientID;
		ResultSet set = OrderDataSqlHelperImpl.executeQuery(sql);
		try {
			while(set.next()){
				//将查询结果每一项的数据取出来
				String orderid = set.getString("orderid");
				String hotelid = set.getString("hotelid");
				String clientid = set.getString("clientid");
				String createddate = set.getString("createddate");
				String begindate = set.getString("begindate");
				String enddate = set.getString("enddate");
				String lastdate = set.getString("lastdate");
				double price = set.getDouble("price");
				int roomtotal = set.getInt("roomtotal");
				String roomtype = set.getString("roomtype");
				String roomnumber = set.getString("roomnumber");
				String peoplenumber = set.getString("peoplenumber");
				String haschild = set.getString("haschild");
				String orderstatus = set.getString("orderstatus");
				String withdrawtime = set.getString("withdrawtime");
				String comment = set.getString("comment");
				
				//将数据形成一个PO传输
				OrderPO po = new OrderPO();
				po.setOrderID(orderid);
				po.setHotelID(hotelid);
				po.setClientID(clientid);
				po.setOrderCreatedDate(createddate);
				po.setOrderBeginDate(begindate);
				po.setOrderEndDate(enddate);
				po.setOrderLastDate(lastdate);
				po.setPrice(price);
				po.setRoomTotal(roomtotal);
				po.setRoomType(roomtype);
				po.setRoomNumber(roomnumber);
				po.setPeopleNumber(peoplenumber);
				po.setHasChild(haschild);
				po.setOrderStatus(orderstatus);
				po.setWithdrawTime(withdrawtime);
				po.setComment(comment);
				list.add(po);
			}
			OrderDataSqlHelperImpl.close();
			return list;
		} catch (SQLException e) {
			OrderDataSqlHelperImpl.close();
			return list;
		}
	}

	@Override
	public List<OrderPO> getHotelOrderPOList(String hotelID) {
		
		List<OrderPO> list = new ArrayList<OrderPO>();
		String sql = "select *from t_order where hotelid="+hotelID;
		ResultSet set = OrderDataSqlHelperImpl.executeQuery(sql);
		try {
			while(set.next()){
				//将查询结果每一项的数据取出来
				String orderid = set.getString("orderid");
				String hotelid = set.getString("hotelid");
				String clientid = set.getString("clientid");
				String createddate = set.getString("createddate");
				String begindate = set.getString("begindate");
				String enddate = set.getString("enddate");
				String lastdate = set.getString("lastdate");
				double price = set.getDouble("price");
				int roomtotal = set.getInt("roomtotal");
				String roomtype = set.getString("roomtype");
				String roomnumber = set.getString("roomnumber");
				String peoplenumber = set.getString("peoplenumber");
				String haschild = set.getString("haschild");
				String orderstatus = set.getString("orderstatus");
				String withdrawtime = set.getString("withdrawtime");
				String comment = set.getString("comment");
				
				//将数据形成一个PO传输
				OrderPO po = new OrderPO();
				po.setOrderID(orderid);
				po.setHotelID(hotelid);
				po.setClientID(clientid);
				po.setOrderCreatedDate(createddate);
				po.setOrderBeginDate(begindate);
				po.setOrderEndDate(enddate);
				po.setOrderLastDate(lastdate);
				po.setPrice(price);
				po.setRoomTotal(roomtotal);
				po.setRoomType(roomtype);
				po.setRoomNumber(roomnumber);
				po.setPeopleNumber(peoplenumber);
				po.setHasChild(haschild);
				po.setOrderStatus(orderstatus);
				po.setWithdrawTime(withdrawtime);
				po.setComment(comment);
				list.add(po);
			}
			OrderDataSqlHelperImpl.close();
			return list;
		} catch (SQLException e) {
			OrderDataSqlHelperImpl.close();
			return list;
		}
	}

	@Override
	public List<OrderPO> getAllOrders() {
		
		List<OrderPO> list = new ArrayList<OrderPO>();
		String sql = "select *from t_order";
		ResultSet set = OrderDataSqlHelperImpl.executeQuery(sql);
		try {
			while(set.next()){
				//将查询结果每一项的数据取出来
				String orderid = set.getString("orderid");
				String hotelid = set.getString("hotelid");
				String clientid = set.getString("clientid");
				String createddate = set.getString("createddate");
				String begindate = set.getString("begindate");
				String enddate = set.getString("enddate");
				String lastdate = set.getString("lastdate");
				double price = set.getDouble("price");
				int roomtotal = set.getInt("roomtotal");
				String roomtype = set.getString("roomtype");
				String roomnumber = set.getString("roomnumber");
				String peoplenumber = set.getString("peoplenumber");
				String haschild = set.getString("haschild");
				String orderstatus = set.getString("orderstatus");
				String withdrawtime = set.getString("withdrawtime");
				String comment = set.getString("comment");
				
				//将数据形成一个PO传输
				OrderPO po = new OrderPO();
				po.setOrderID(orderid);
				po.setHotelID(hotelid);
				po.setClientID(clientid);
				po.setOrderCreatedDate(createddate);
				po.setOrderBeginDate(begindate);
				po.setOrderEndDate(enddate);
				po.setOrderLastDate(lastdate);
				po.setPrice(price);
				po.setRoomTotal(roomtotal);
				po.setRoomType(roomtype);
				po.setRoomNumber(roomnumber);
				po.setPeopleNumber(peoplenumber);
				po.setHasChild(haschild);
				po.setOrderStatus(orderstatus);
				po.setWithdrawTime(withdrawtime);
				po.setComment(comment);
				list.add(po);
			}
			OrderDataSqlHelperImpl.close();
			return list;
		} catch (SQLException e) {
			OrderDataSqlHelperImpl.close();
			return list;
		}
	}

	@Override
	public List<String> getAllIDs() {
		
		List<String> allids = new ArrayList<String>();
		String sql = "select orderid from t_order";
		ResultSet set = OrderDataSqlHelperImpl.executeQuery(sql);
		
		try {
			while(set.next()){
				String id = set.getString("orderid");
				allids.add(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		OrderDataSqlHelperImpl.close();
		return allids;
	}

}
