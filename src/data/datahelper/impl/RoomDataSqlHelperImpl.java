package data.datahelper.impl;

/**
 * @author Cong Deng
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import data.datahelper.RoomDataHelper;
import po.RoomPO;

public class RoomDataSqlHelperImpl implements RoomDataHelper {

	private static final String DRIVER="com.mysql.jdbc.Driver";// JDBC driver name 
	private static final String URL="jdbc:mysql://localhost/bighomework"; //JDBC database URL
	private static final String USER="root"; //Database credentials
	private static final String PASSWORD="mysql";
	private static Connection conn=null;
	
	
	public RoomDataSqlHelperImpl() {
	
		try{
			if(conn==null){
				Class.forName(DRIVER);
				conn=DriverManager.getConnection(URL,USER,PASSWORD);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param sql statements
	 * @return the result of the sql statement
	 */
	private static ResultSet executeQuery(String sql){
		//query the database
		Statement statement=null;
		try{
			if(null==conn){
				new RoomDataSqlHelperImpl();
			}
			statement=conn.createStatement();
			return statement.executeQuery(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param sql sql statement
	 * @return return the numbers of lines that are influenced
	 */
	private static int executeUpdate(String sql){
		//the sql statement should be insert,update or delete
		//return the numbers of lines that are influenced when finished
		Statement statement=null;
		try{
			if(null==conn){
				new RoomDataSqlHelperImpl();
			}
			statement=conn.createStatement();
			return statement.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1;
	}
	
	public static void close(){
		//close the function
		try{
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			conn=null; //set the connection object to null
		}
	}

	@Override
	public List<RoomPO> getAllRoomList(String hotelId) {
		
		List<RoomPO> roomList=new ArrayList<RoomPO>();		
		//create sql statement
		String sql="SELECT * FROM t_room WHERE hotelid='"+hotelId+"';";
		ResultSet set=RoomDataSqlHelperImpl.executeQuery(sql);
		try{
			while(set.next()){
				String hotelID=set.getString("hotelid");
				String roomType=set.getString("roomtype");
				double price=set.getDouble("price");
				String roomState=set.getString("roomstate");
				String bookDate=set.getString("bookdate");
				String roomNumber=set.getString("roomnumber");
				String roomIntro=set.getString("introduction");
				
				//create a po object to transmit
				RoomPO po=new RoomPO();
				po.setHotelID(hotelID);
				po.setBookDate(bookDate);
				po.setPrice(price);
				po.setRoomIntroduction(roomIntro);
				po.setRoomNumber(roomNumber);
				po.setRoomState(roomState);
				po.setRoomType(roomType);
				
				roomList.add(po);
			}
			RoomDataSqlHelperImpl.close();
			return roomList;
		}catch(SQLException e){
			RoomDataSqlHelperImpl.close();
			e.printStackTrace();
			return roomList;
		}
	}

	@Override
	public RoomPO getRoomByNum(String hotelId,String roomId) {
		
		RoomPO po=null;
		
		//create sql statement
		String sql="SELECT * FROM t_room WHERE hotelid='"+hotelId+"' AND roomnumber='"+roomId+"';";
		ResultSet set=RoomDataSqlHelperImpl.executeQuery(sql);
		try{
			while(set.next()){
				String hotelID=set.getString("hotelid");
				String roomType=set.getString("roomtype");
				double price=set.getDouble("price");
				String roomState=set.getString("roomstate");
				String bookDate=set.getString("bookdate");
				String roomNumber=set.getString("roomnumber");
				String roomIntro=set.getString("introduction");
				
				//create a po to transmit
				po=new RoomPO();
				po.setHotelID(hotelID);
				po.setBookDate(bookDate);
				po.setPrice(price);
				po.setRoomIntroduction(roomIntro);
				po.setRoomNumber(roomNumber);
				po.setRoomState(roomState);
				po.setRoomType(roomType);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		RoomDataSqlHelperImpl.close();
		return po;
	}

	@Override
	public List<RoomPO> getRoomByState(String hotelId,String state) {
		
		List<RoomPO> rooms=new ArrayList<RoomPO>();
		
		//create sql statement
		String sql="SELECT * FROM t_room WHERE hotelid='"+hotelId+"' AND roomstate='"+state+"';";
		ResultSet set=RoomDataSqlHelperImpl.executeQuery(sql);
		try{
			while(set.next()){
				String hotelID=set.getString("hotelid");
				String roomType=set.getString("roomtype");
				double price=set.getDouble("price");
				String roomState=set.getString("roomstate");
				String bookDate=set.getString("bookdate");
				String roomNumber=set.getString("roomnumber");
				String roomIntro=set.getString("introduction");
				
				//create a po to transmit
				RoomPO po=new RoomPO();
				po.setHotelID(hotelID);
				po.setBookDate(bookDate);
				po.setPrice(price);
				po.setRoomIntroduction(roomIntro);
				po.setRoomNumber(roomNumber);
				po.setRoomState(roomState);
				po.setRoomType(roomType);
			
				rooms.add(po);
			}
			RoomDataSqlHelperImpl.close();
			return rooms;
		}catch(SQLException e){
			RoomDataSqlHelperImpl.close();
			e.printStackTrace();
			return rooms;
		}
	}

	@Override
	public List<RoomPO> getRoomByType(String hotelId,String type) {
		
		List<RoomPO> rooms=new ArrayList<RoomPO>();
		
		//create sql statement
		String sql="SELECT * FROM t_room WHERE hotelid='"+hotelId+"' AND roomtype='"+type+"';";
		ResultSet set=RoomDataSqlHelperImpl.executeQuery(sql);
		try{
			while(set.next()){
				String hotelID=set.getString("hotelid");
				String roomType=set.getString("roomtype");
				double price=set.getDouble("price");
				String roomState=set.getString("roomstate");
				String bookDate=set.getString("bookdate");
				String roomNumber=set.getString("roomnumber");
				String roomIntro=set.getString("introduction");
				
				//create a po to transmit
				RoomPO po=new RoomPO();
				po.setHotelID(hotelID);
				po.setBookDate(bookDate);
				po.setPrice(price);
				po.setRoomIntroduction(roomIntro);
				po.setRoomNumber(roomNumber);
				po.setRoomState(roomState);
				po.setRoomType(roomType);
			
				rooms.add(po);
			}
			RoomDataSqlHelperImpl.close();
			return rooms;
		}catch(SQLException e){
			RoomDataSqlHelperImpl.close();
			e.printStackTrace();
			return rooms;
		}
	}

	@Override
	public boolean addRoom(RoomPO po) {
		
		String hotelId=po.getHotelID();
		String bookDate=po.getBookDate();
		String roomIntro=po.getRoomIntroduction();
		String roomState=po.getRoomState();
		String roomType=po.getRoomType();
		String roomNumber=po.getRoomNumber();
		double price=po.getPrice();
		
		//create sql statement
		String sql="INSERT INTO t_room(hotelid,roomnumber,roomtype,roomstate,"+
					"introduction,bookdate,price) VALUES "+ "('"+hotelId+"','"
					+roomNumber+"','"+roomType+"','"+roomState+"','"+roomIntro+"','"
					+bookDate+"',"+price+");";
		
		int i=RoomDataSqlHelperImpl.executeUpdate(sql);
		RoomDataSqlHelperImpl.close();
		if(-1==i){
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteRoom(String hotelId, String roomId) {
		
		//create sql statement
		String sql="DELETE FROM t_room WHERE hotelid='"+hotelId
				+"' AND roomnumber='"+roomId+"';";
		int i=RoomDataSqlHelperImpl.executeUpdate(sql);
		RoomDataSqlHelperImpl.close();
		if(-1==i){
			return false;
		}
		return true;
	}

	@Override
	public boolean changeRoomPrice(String type, double price, String hotelId) {
		
		//create sql statement
		String sql="UPDATE t_room SET price='"+price+"' WHERE hotelid='"+hotelId+"' AND roomtype='"+type+"';";
		int i=RoomDataSqlHelperImpl.executeUpdate(sql);
		RoomDataSqlHelperImpl.close();
		if(-1==i){
			return false;
		}
		return true;
	}

	@Override
	public boolean changeRoomState(String hotelId, String roomId, String state) {
		
		//create sql statement
		String sql="UPDATE t_room SET roomstate='"+state+"' WHERE hotelid='"+hotelId+"' AND roomnumber='"+roomId+"';";
		int i=RoomDataSqlHelperImpl.executeUpdate(sql);
		RoomDataSqlHelperImpl.close();
		if(-1==i){
			return false;
		}
		return true;
	}

	@Override
	public boolean changeBookDate(String hotelId, String roomId, String bookDate) {
	
		//create sql statement
		String sql="UPDATE t_room SET bookdate='"+bookDate+"' WHERE hotelid='"+hotelId+"' AND roomnumber='"+roomId+"';";
		int i=RoomDataSqlHelperImpl.executeUpdate(sql);
		RoomDataSqlHelperImpl.close();
		if(-1==i){
			return false;
		}
		return true;
	}

	@Override
	public List<String> getRoomType(String hotelId) {
		// TODO Auto-generated method stub
		List<String> roomType=new ArrayList<String>();
		String result="";
		//create sql statement
		String sql="SELECT * FROM t_room WHERE hotelid='"+hotelId+"';";
		ResultSet set=RoomDataSqlHelperImpl.executeQuery(sql);
		try{
			while(set.next()){
				String type=set.getString("roomtype");
				result+=type+"/";
			}
			result=toString(result.substring(0,result.length()-1));
			roomType=Arrays.asList(result.split("/"));
			return roomType;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<String> getRoomState(String hotelId) {
		// TODO Auto-generated method stub
		List<String> roomState=new ArrayList<String>();
		//create sql statement
		String sql="SELECT * FROM t_room WHERE hotelid='"+hotelId+"';";
		String result="";
		ResultSet set=RoomDataSqlHelperImpl.executeQuery(sql);
		try{
			while(set.next()){
				String type=set.getString("roomstate");
				result+=type+"/";
			}
			result=toString(result.substring(0,result.length()-1));
			roomState=Arrays.asList(result.split("/"));
			return roomState;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	private String toString(String str){
		
		String[] list=str.split("/");
		String result="";
		for(int i=0;i<list.length;i++){
			if(!result.contains(list[i])){
				result= result+list[i]+"/";
			}
		}
		return result.substring(0,result.length()-1);
	}

}
