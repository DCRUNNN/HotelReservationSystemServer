package data.datahelper.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.datahelper.CreditDataHelper;
import po.CreditPO;

public class CreditDataSqlHelperImpl implements CreditDataHelper{
	
	private static final String DRIVER = "org.gjt.mm.mysql.Driver";//数据库连接驱动类
	private static final String URL = "jdbc:mysql://localhost:3306/bighomework";//url
	private static final String USER = "root";
	private static final String PASSWORD = "mysql";
	private static Connection conn = null;	
	
	public CreditDataSqlHelperImpl (){
		
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
				new CreditDataSqlHelperImpl();
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
				new CreditDataSqlHelperImpl();
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
	public List<CreditPO> getAllClientCreditPO(String clientID) {
		
		List<CreditPO> list = new ArrayList<CreditPO>();
		String sql = "select *from t_credit where clientid="+clientID;
		ResultSet set = CreditDataSqlHelperImpl.executeQuery(sql);
		try {
			while(set.next()){
				//将查询结果每一项的数据取出来
				String orderid = set.getString("orderid");
				String clientid = set.getString("clientid");
				String time = set.getString("time");
				String cause = set.getString("cause");
				String change = set.getString("change");
				
				//将数据形成一个PO传输
				CreditPO po = new CreditPO();
				po.setTime(time);
				po.setClientID(clientid);
				po.setOrderID(orderid);
				po.setCause(cause);
				po.setChange(change);
				list.add(po);
			}
			CreditDataSqlHelperImpl.close();
			return list;
		} catch (SQLException e) {
			CreditDataSqlHelperImpl.close();
			e.printStackTrace();
			return list;
		}
	}

	@Override
	public boolean insert(CreditPO po) {
		
		String orderid = po.getOrderID();
		String clientid = po.getClientID();
		String time = po.getTime();
		String cause = po.getCause();
		String change = po.getChange();
		
		String sql ="insert into t_credit(orderid,clientid,time,cause,change) values"
				+ "('"+orderid+"','"+clientid+"','"+time+"','"+cause+"','"+change+"')";
		
		int i =CreditDataSqlHelperImpl.executeUpdate(sql);
		PersonnelDataSqlHelperImpl.close();
		if(i==-1){
			return false;
		}
		return true;
	}

}
