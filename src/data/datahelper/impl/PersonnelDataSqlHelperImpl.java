package data.datahelper.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.datahelper.PersonnelDataHelper;
import po.PersonnelPO;

public class PersonnelDataSqlHelperImpl implements PersonnelDataHelper{
	
	private static final String DRIVER = "org.gjt.mm.mysql.Driver";//数据库连接驱动类
	private static final String URL = "jdbc:mysql://localhost:3306/bighomework";//url
	private static final String USER = "root";
	private static final String PASSWORD = "mysql";
	private static Connection conn = null;	
	
	public PersonnelDataSqlHelperImpl (){
		
		try{
			if(conn==null){
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
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
	@Override
	public PersonnelPO getPersonnelPO(String Personnel_id) {
		
		PersonnelPO po = new PersonnelPO();
		String sql = "select *from t_personnel where personnelid="+Personnel_id;
		ResultSet set = PersonnelDataSqlHelperImpl.executeQuery(sql);
		try {
			while(set.next()){
				String personnelID=set.getString("personnelid");
				//String identity=set.getString("identity");
				String name=set.getString("name");
				String sex=set.getString("sex");
				String phoneNumber=set.getString("phonenumber");
				String hotelID=set.getString("hotelid");
				String type=set.getString("type");
				//create a po object to transmit
				po.setHotelID(hotelID);
			//po.setIdentity(identity);
				po.setName(name);
				po.setPersonnelID(personnelID);
				po.setPhoneNumber(phoneNumber);
				po.setSex(sex);
				po.setType(type);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PersonnelDataSqlHelperImpl.close();
		return po;
	}


	@Override
	public List<PersonnelPO> getAllPersonnelPOList() {
		
		List<PersonnelPO> personnelList=new ArrayList<PersonnelPO>();		
		//create sql statement
		String sql="SELECT * FROM t_personnel";
		ResultSet set=PersonnelDataSqlHelperImpl.executeQuery(sql);
		try{
			while(set.next()){
				
				String personnelID=set.getString("personnelid");
				String name=set.getString("name");
				String sex=set.getString("sex");
				String phoneNumber=set.getString("phonenumber");
				String hotelID=set.getString("hotelid");
				String type=set.getString("type");
				//create a po object to transmit
				PersonnelPO po=new PersonnelPO();
				po.setHotelID(hotelID);
				po.setName(name);
				po.setPersonnelID(personnelID);
				po.setPhoneNumber(phoneNumber);
				po.setSex(sex);
				po.setType(type);
				
				personnelList.add(po);
			}
			PersonnelDataSqlHelperImpl.close();
			return personnelList;
		}catch(SQLException e){
			PersonnelDataSqlHelperImpl.close();
			e.printStackTrace();
			return personnelList;
		}
	}

	@Override
	public boolean insert(PersonnelPO po) {
		
		String personnelid = po.getPersonnelID();
		String hotelid = po.getHotelID();
		//String identity = po.getIdentity();
		String name = po.getName();
		String phonenumber = po.getPhoneNumber();
		String sex = po.getSex();
		String type = po.getType();
		
		String sql ="insert into t_personnel(personnelid,hotelid,name,phonenumber,sex,type) values"
				+ "('"+personnelid+"','"+hotelid+"','"+name+"','"+phonenumber+"','"+sex+"','"+type+"')";
		
		int i =PersonnelDataSqlHelperImpl.executeUpdate(sql);
		PersonnelDataSqlHelperImpl.close();
		if(i==-1){
			return false;
		}
		return true;
	}

	public static void main(String args[]){
		
		/*PersonnelPO po = new PersonnelPO();
		po.setPersonnelID("100001");
		new PersonnelDataSqlHelperImpl().insert(po);
		PersonnelPO newPO = new PersonnelDataSqlHelperImpl().getPersonnelPO("100001");
		newPO.setName("曾锡豪");
		System.out.println(new PersonnelDataSqlHelperImpl().change(newPO));*/
	}
	@Override
	public boolean isExist(String hotelID) {
		
		String sql="select *from t_personnel where hotelid="+hotelID;
		ResultSet set=PersonnelDataSqlHelperImpl.executeQuery(sql);
		try{
			while(set.next()){
				PersonnelDataSqlHelperImpl.close();
				return true;
			}
		}catch(SQLException e){
			PersonnelDataSqlHelperImpl.close();
			e.printStackTrace();
		}	
		return false;
	}

	@Override
	public boolean change(PersonnelPO po) {
		
		String personnelid = po.getPersonnelID();
		String hotelid = po.getHotelID();
		String name = po.getName();
		String phonenumber = po.getPhoneNumber();
		String sex = po.getSex();
		String type = po.getType();
		
		String sql = "update t_personnel set hotelid='"+hotelid+"',name='"+name
				+"',phonenumber='"+phonenumber+"',sex='"+sex+"',type='"+type+"' where personnelid="+personnelid;
		
		int i = PersonnelDataSqlHelperImpl.executeUpdate(sql);
		PersonnelDataSqlHelperImpl.close();
		if(i==-1){
			return false;
		}
		return true;
	}

	@Override
	public List<String> getAllids() {
		
		List<String> allids=new ArrayList<String>();
		String sql="select *from t_personnel";
		ResultSet set=PersonnelDataSqlHelperImpl.executeQuery(sql);
		try{
			while(set.next()){
				String id=set.getString("personnelid");
				allids.add(id);
			}
			PersonnelDataSqlHelperImpl.close();
			return allids;
		}catch(SQLException e){
			e.printStackTrace();
			return allids;
		}
	}

}
