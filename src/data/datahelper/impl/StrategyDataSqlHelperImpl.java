package data.datahelper.impl;

/**
 * @author Cong Deng
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import data.datahelper.StrategyDataHelper;
import po.StrategyPO;

public class StrategyDataSqlHelperImpl implements StrategyDataHelper {

	private static final String DRIVER="com.mysql.jdbc.Driver";// JDBC driver name 
	private static final String URL="jdbc:mysql://localhost/bighomework"; //JDBC database URL
	private static final String USER="root"; //Database credentials
	private static final String PASSWORD="mysql";
	private static Connection conn=null;
	
	
	public StrategyDataSqlHelperImpl() {
	
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
				new StrategyDataSqlHelperImpl();
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
				new StrategyDataSqlHelperImpl();
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
	public List<StrategyPO> getHotelStrategies(String hotelId) {
		
		List<StrategyPO> list=new ArrayList<StrategyPO>();
		
		//create sql statement
		String sql="SELECT * FROM t_strategy WHERE hotelid='"+hotelId+"';";
		ResultSet set=StrategyDataSqlHelperImpl.executeQuery(sql);
		try{
			while(set.next()){
				String hotelID=set.getString("hotelid");
				String strategyId=set.getString("strategyid");
				String strategyName=set.getString("strategyname");
				String intro=set.getString("introduction");
				String beginTime=set.getString("begintime");
				String endTime=set.getString("endtime");
				String userType=set.getString("usertype");
				String province=set.getString("hotelprovince");
				String city = set.getString("hotelcity");
				String hotelCBD=set.getString("hotelcbd");
				boolean isToBDay=set.getBoolean("istobirthday");
				String strategyType=set.getString("strategytype");
				int roomTotal=set.getInt("roomtotal");
				double discount=set.getDouble("discount");
				
				//create a po object to transmit
				StrategyPO po=new StrategyPO();
				po.setBeginTime(beginTime);
				po.setDiscount(discount);
				po.setEndTime(endTime);
				po.setHotelProvince(province);
				po.setHotelCity(city);
				po.setHotelCBD(hotelCBD);
				po.setHotelID(hotelID);
				po.setIntroductuion(intro);
				po.setName(strategyName);
				po.setRoomTotal(roomTotal);
				po.setStrategyID(strategyId);
				po.setStrategyType(strategyType);
				po.setToBirthday(isToBDay);
				po.setUserType(userType);
			
				list.add(po);
			}
			StrategyDataSqlHelperImpl.close();
			return list;
		}catch(SQLException e){
			StrategyDataSqlHelperImpl.close();
			e.printStackTrace();
			return list;
		}
	}

	@Override
	public boolean changeStrategy(StrategyPO po) {
		
		String hotelID=po.getHotelID();
		String strategyId=po.getStrategyID();
		String strategyName=po.getName();
		String intro=po.getIntroductuion();
		String beginTime=po.getBeginTime();
		String endTime=po.getEndTime();
		String userType=po.getUserType();
		//String hotelAdd=po.getHotelID();
		String hotelProvince = po.getHotelProvince();
		String hotelCity = po.getHotelCity();
		String hotelCBD=po.getHotelCBD();
		boolean isToBDay=po.isToBirthday();
		String strategyType=po.getStrategyType();
		int roomTotal=po.getRoomTotal();
		double discount=po.getDiscount();
		
		//create sql statement
		String sql="UPDATE t_strategy SET hotelid='"+hotelID+"',hotelprovince='"+hotelProvince+"',hotelcity='"+hotelCity+"',hotelcbd='"+hotelCBD+"',strategyid='"
					+strategyId+"',strategyname='"+strategyName+"',strategytype='"+strategyType+"',begintime='"+beginTime+"',endtime='"
					+endTime+"',introduction='"+intro+"',usertype='"+userType+"',istobirthday='"+convert(isToBDay)+"',roomtotal='"+roomTotal+"',discount='"+
					discount+"' WHERE strategyid='"+strategyId+"';";
		
		int i=StrategyDataSqlHelperImpl.executeUpdate(sql);
		StrategyDataSqlHelperImpl.close();
		if(-1==i){
			return false;
		}
		return true;
	}

	@Override
	public boolean addStrategy(StrategyPO po) {
		
		String hotelID=po.getHotelID();
		String strategyId=po.getStrategyID();
		String strategyName=po.getName();
		String intro=po.getIntroductuion();
		String beginTime=po.getBeginTime();
		String endTime=po.getEndTime();
		String userType=po.getUserType();
		//String hotelAdd=po.getHotelID();
		String hotelprovince = po.getHotelProvince();
		String hotelcity = po.getHotelCity();
		String hotelCBD=po.getHotelCBD();
		boolean isToBDay=po.isToBirthday();
		String strategyType=po.getStrategyType();
		int roomTotal=po.getRoomTotal();
		double discount=po.getDiscount();
		
		//create sql statement
		String sql="INSERT INTO t_strategy(hotelid,hotelprovince,hotelcity,hotelcbd,strategyid,strategyname,strategytype,"+
				"begintime,endtime,introduction,usertype,istobirthday,roomtotal,discount) VALUES "+
				"('"+hotelID+"','"+hotelprovince+"','"+hotelcity+"','"+hotelCBD+"','"+strategyId+"','"+strategyName+"','"+strategyType
				+"','"+beginTime+"','"+endTime+"','"+intro+"','"+userType+"','"+convert(isToBDay)+"','"+roomTotal
				+"',"+discount+");";
		
		int i=StrategyDataSqlHelperImpl.executeUpdate(sql);
		StrategyDataSqlHelperImpl.close();
		if(-1==i){
			return false;
		}
		return true;
	}

	@Override
	public List<StrategyPO> getAllWebsiteStrategies() {
		
		List<StrategyPO> list=new ArrayList<StrategyPO>();
		
		//create sql statement
		String sql="SELECT * FROM t_strategy WHERE strategytype='website';";
		ResultSet set=StrategyDataSqlHelperImpl.executeQuery(sql);
		try{
			while(set.next()){
				
				String hotelID=set.getString("hotelid");
				String strategyId=set.getString("strategyid");
				String strategyName=set.getString("strategyname");
				String intro=set.getString("introduction");
				String beginTime=set.getString("begintime");
				String endTime=set.getString("endtime");
				String userType=set.getString("usertype");
				//String hotelAdd=set.getString("hoteladdress");
				String hotelProvince = set.getString("hotelprovince");
				String hotelCity = set.getString("hotelcity");
				String hotelCBD=set.getString("hotelcbd");
				boolean isToBDay=set.getBoolean("istobirthday");
				String strategyType=set.getString("strategytype");
				int roomTotal=set.getInt("roomtotal");
				double discount=set.getDouble("discount");
				
				//create a po object to transmit
				StrategyPO po=new StrategyPO();
				po.setBeginTime(beginTime);
				po.setDiscount(discount);
				po.setEndTime(endTime);
				//po.setHotelAddress(hotelAdd);
				po.setHotelProvince(hotelProvince);
				po.setHotelCity(hotelCity);
				po.setHotelCBD(hotelCBD);
				po.setHotelID(hotelID);
				po.setIntroductuion(intro);
				po.setName(strategyName);
				po.setRoomTotal(roomTotal);
				po.setStrategyID(strategyId);
				po.setStrategyType(strategyType);
				po.setToBirthday(isToBDay);
				po.setUserType(userType);
			
				list.add(po);
			}
			StrategyDataSqlHelperImpl.close();
			return list;
		}catch(SQLException e){
			StrategyDataSqlHelperImpl.close();
			e.printStackTrace();
			return list;
		}
	}

	@Override
	public boolean deleteStrategy(String strategyID) {
	
		//create sql statement
		String sql="DELETE FROM t_strategy WHERE strategyid='"+strategyID+"';";
		int i=StrategyDataSqlHelperImpl.executeUpdate(sql);
		StrategyDataSqlHelperImpl.close();
		if(-1==i){
			return false;
		}
		return true;
	}
	
	@Override
	public List<String> getAllIds() {
	
		List<String> list=new ArrayList<String>();
		
		//create sql statement;
		String sql="SELECT * FROM t_strategy;";
		ResultSet set=StrategyDataSqlHelperImpl.executeQuery(sql);
		try{
			while(set.next()){
				list.add(set.getString("strategyid"));
			}
			StrategyDataSqlHelperImpl.close();
			return list;
		}catch(SQLException e){
			StrategyDataSqlHelperImpl.close();
			e.printStackTrace();
			return list;
		}
	}
	
	
	private int convert(boolean b){
		return (b==true)?1:0;
	}

}
