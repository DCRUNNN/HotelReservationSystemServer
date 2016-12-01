package data.datahelper.impl;

/**
 * @author Cong Deng
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import data.datahelper.HotelDataHelper;
import po.HotelPO;


public class HotelDataSqlHelperImpl implements HotelDataHelper {
	
	private static final String DRIVER="com.mysql.jdbc.Driver";// JDBC driver name 
	private static final String URL="jdbc:mysql://localhost/bighomework"; //JDBC database URL
	private static final String USER="root"; //Database credentials
	private static final String PASSWORD="mysql";
	private static Connection conn=null;
		
	public HotelDataSqlHelperImpl() {
	
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
				new HotelDataSqlHelperImpl();
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
				new HotelDataSqlHelperImpl();
			}
			statement=conn.createStatement();
			return statement.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1;
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
	public String getCBDS(String hotelProvince, String hotelCity) {
		
		//create sql statement
		String sql="SELECT * FROM t_hotel WHERE province='"+hotelProvince+"' AND city='"+hotelCity+"';";
		ResultSet set=HotelDataSqlHelperImpl.executeQuery(sql);
		String result="";
		try{
			while(set.next()){
				result+=set.getString("hotelcbd")+"/";
			}
			HotelDataSqlHelperImpl.close();
			return toString(result.substring(0,result.length()-1));
		}catch(SQLException e){
			HotelDataSqlHelperImpl.close();
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public HotelPO getHotelPO(String hotelID) {
		
		HotelPO po=null;
		
		//create sql statement
		String sql="SELECT * FROM t_hotel WHERE hotelid='"+hotelID+"';";
		ResultSet set=HotelDataSqlHelperImpl.executeQuery(sql);
		try{
			while(set.next()){
				String hotelId=set.getString("hotelid");
				String province=set.getString("province");
				String city=set.getString("city");
				String hotelCBD=set.getString("hotelcbd");
				String address = set.getString("address");
				String hotelName=set.getString("hotelname");
				int hotelStar=set.getInt("hotelstar");
				String intro=set.getString("introduction");
				String facility=set.getString("facility");
				String roomTypeAndPrice=set.getString("roomtypeandprice");
				String comment=set.getString("comment");
				double facilityPoint=set.getDouble("facilitypoint");
				double servicePoint=set.getDouble("servicepoint");
				double surroundingPoint=set.getDouble("surroundingpoint");
				int commentPeople=set.getInt("commentpeople");
				
				//create a po to transmit
				po=new HotelPO();
				po.setCommentList(comment);
				po.setCommentPeople(commentPeople);
				po.setFacilities(facility);
				po.setHotelCBD(hotelCBD);
				po.setHotelAddress(address);
				po.setHotelCity(city);
				po.setHotelID(hotelId);
				po.setHotelName(hotelName);
				po.setHotelProvince(province);
				po.setHotelStar(hotelStar);
				po.setIntroduction(intro);
				po.setPoint_facilities(facilityPoint);
				po.setPoint_service(servicePoint);
				po.setPoint_surroundings(surroundingPoint);
				po.setRoomTypeAndPrice(roomTypeAndPrice);	
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		HotelDataSqlHelperImpl.close();
		return po;
	}

	@Override
	public List<HotelPO> getAllHotel(String hotelProvince, String hotelCity, String hotelCBD) {
	
		List<HotelPO> hotels=new ArrayList<HotelPO>();
	
		//create sql statement
		String sql="SELECT * FROM t_hotel WHERE province='"+hotelProvince+"' AND city='"+hotelCity
				+"' AND hotelcbd='"+hotelCBD+"';";
		ResultSet set=HotelDataSqlHelperImpl.executeQuery(sql);
		try{
			while(set.next()){
				String hotelId=set.getString("hotelid");
				String province=set.getString("province");
				String city=set.getString("city");
				String hotelcbd=set.getString("hotelcbd");
				String address = set.getString("address");
				String hotelName=set.getString("hotelname");
				int hotelStar=set.getInt("hotelstar");
				String intro=set.getString("introduction");
				String facility=set.getString("facility");
				String roomTypeAndPrice=set.getString("roomtypeandprice");
				String comment=set.getString("comment");
				double facilityPoint=set.getDouble("facilitypoint");
				double servicePoint=set.getDouble("servicepoint");
				double surroundingPoint=set.getDouble("surroundingpoint");
				int commentPeople=set.getInt("commentpeople");
				
				//create a po to transmit
				HotelPO po=new HotelPO();
				po.setCommentList(comment);
				po.setCommentPeople(commentPeople);
				po.setFacilities(facility);
				po.setHotelCBD(hotelcbd);
				po.setHotelAddress(address);
				po.setHotelCity(city);
				po.setHotelID(hotelId);
				po.setHotelName(hotelName);
				po.setHotelProvince(province);
				po.setHotelStar(hotelStar);
				po.setIntroduction(intro);
				po.setPoint_facilities(facilityPoint);
				po.setPoint_service(servicePoint);
				po.setPoint_surroundings(surroundingPoint);
				po.setRoomTypeAndPrice(roomTypeAndPrice);
				
				hotels.add(po);
			}
			HotelDataSqlHelperImpl.close();
			return hotels;
		}catch(SQLException e){
			HotelDataSqlHelperImpl.close();
			e.printStackTrace();
			return hotels;
		}
	}

	@Override
	public boolean change(HotelPO po) {
		
		String hotelId=po.getHotelID();
		String province=po.getHotelProvince();
		String city=po.getHotelCity();
		String hotelCBD=po.getHotelCBD();
		String address = po.getHotelAddress();
		String hotelName=po.getHotelName();
		int hotelStar=po.getHotelStar();
		String intro=po.getIntroduction();
		String facility=po.getFacilities();
		String roomTypeAndPrice=po.getRoomTypeAndPrice();
		double facilityPoint=po.getPoint_facilities();
		double servicePoint=po.getPoint_service();
		double surroundingPoint=po.getPoint_surroundings();
		String comment=po.getCommentList();
		int commentPeople=po.getCommentPeople();
		
		
		//create sql statement
		String sql="UPDATE t_hotel SET province='"+province+"',city='"+city+"',hotelcbd='"+hotelCBD+"',address='"+address+"',hotelname='"+hotelName
				+"',hotelstar='"+hotelStar+"',introduction='"+intro+"',facility='"+facility+"',roomtypeandprice='"+roomTypeAndPrice
				+"',facilitypoint='"+facilityPoint+"',servicepoint='"+servicePoint+"',surroundingpoint='"+surroundingPoint
				+"',comment='"+comment+"',commentpeople='"+commentPeople+"' WHERE hotelid='"+hotelId+"';";
		
		int i=HotelDataSqlHelperImpl.executeUpdate(sql);
		HotelDataSqlHelperImpl.close();
		if(-1==i){
			return false;
		}
		return true;
	}

	@Override
	public boolean insert(HotelPO po) {
		
		String hotelId=po.getHotelID();
		String province=po.getHotelProvince();
		String city=po.getHotelCity();
		String hotelCBD=po.getHotelCBD();
		String address = po.getHotelAddress();
		String hotelName=po.getHotelName();
		int hotelStar=po.getHotelStar();
		String intro=po.getIntroduction();
		String facility=po.getFacilities();
		String roomTypeAndPrice=po.getRoomTypeAndPrice();
		double facilityPoint=po.getPoint_facilities();
		double servicePoint=po.getPoint_service();
		double surroundingPoint=po.getPoint_surroundings();
		String comment=po.getCommentList();
		int commentPeople=po.getCommentPeople();
		
		//create sql statement
		String sql="INSERT INTO t_hotel(hotelid,hotelname,province,city,hotelcbd,address,hotelstar,introduction"
					+",facility,roomtypeandprice,facilitypoint,servicepoint,surroundingpoint,comment,commentpeople) VALUES ('"
					+hotelId+"','"+hotelName+"','"+province+"','"+city+"','"+hotelCBD+"','"+address+"','"+hotelStar+"','"+intro+"','"+facility
					+"','"+roomTypeAndPrice+"','"+facilityPoint+"','"+servicePoint+"','"+surroundingPoint+"','"+comment+"','"+
					commentPeople+"');";
		
		int i=HotelDataSqlHelperImpl.executeUpdate(sql);
		HotelDataSqlHelperImpl.close();
		if(-1==i){
			return false;
		}
		return true;	
	}

	@Override
	public String getProvinces() {
	
		String sql="SELECT * FROM t_hotel;";
		ResultSet set=HotelDataSqlHelperImpl.executeQuery(sql);
		String result="";
		try{
			while(set.next()){
				result+=set.getString("province")+"/";
			}
			HotelDataSqlHelperImpl.close();
			return toString(result.substring(0,result.length()-1));
		}catch(SQLException e){
			HotelDataSqlHelperImpl.close();
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public String getCities(String hotelProvince) {
		
		String sql="SELECT * FROM t_hotel WHERE province='"+hotelProvince+"';";
		ResultSet set=HotelDataSqlHelperImpl.executeQuery(sql);
		String result="";
		try{
			while(set.next()){
				result+=set.getString("city")+"/";
			}
			HotelDataSqlHelperImpl.close();
			return toString(result.substring(0,result.length()-1));
		}catch(SQLException e){
			HotelDataSqlHelperImpl.close();
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public List<String> getAllIds() {
		
		List<String> list=new ArrayList<String>();
		
		//create sql statement;
		String sql="SELECT * FROM t_hotel;";
		ResultSet set=HotelDataSqlHelperImpl.executeQuery(sql);
		try{
			while(set.next()){
				list.add(set.getString("hotelid"));
			}
			HotelDataSqlHelperImpl.close();
			return list;
		}catch(SQLException e){
			HotelDataSqlHelperImpl.close();
			e.printStackTrace();
			return list;
		}
	}

	@Override
	public boolean isExist(String hotelProvince, String hotelCity, String hotelCBD, String hotelAddress,
			String hotelName) {
	
		
		String sql = "select *from t_hotel where province='"+hotelProvince+"' and city='"+hotelCity+"' and hotelcbd='"
				+hotelCBD+"' and address='"+hotelAddress+"' and hotelname='"+hotelName+"';";
		ResultSet set = HotelDataSqlHelperImpl.executeQuery(sql);
		try {
			if(set.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
