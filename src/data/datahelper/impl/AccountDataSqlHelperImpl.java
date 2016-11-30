package data.datahelper.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.datahelper.AccountDataHelper;

public class AccountDataSqlHelperImpl implements AccountDataHelper{

	private static final String DBDRIVER = "org.gjt.mm.mysql.Driver";//数据库连接驱动类
	private static final String DBURL = "jdbc:mysql://localhost:3306/bighomework";//url
	private static final String DBUSER = "root";
	private static final String DBPASS = "mysql";
	private static Connection conn = null;
	
	public AccountDataSqlHelperImpl(){

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
				new AccountDataSqlHelperImpl();
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
				new AccountDataSqlHelperImpl();
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
	public boolean insert(String ID, String pass) {
		
		if(isExist(ID)){
			return changePassword(ID,pass);
		}
		String sql = "insert into account (id,password) values ('"+ID+"','"+pass+"')";
		
		int i =AccountDataSqlHelperImpl.executeUpdate(sql);
		AccountDataSqlHelperImpl.close();
		if(i==-1){
			return false;
		}
		return true;
	}

	private boolean changePassword(String ID, String pass) {
		
		String sql = "update account set password='"+pass+"' where id='"+ID+"';";
		int i = AccountDataSqlHelperImpl.executeUpdate(sql);
		AccountDataSqlHelperImpl.close();
		if(i==-1){
			return false;
		}
		return true;
		
	}
	
	private boolean isExist(String ID) {
		
		String sql = "select *from account where id='"+ID+"';";
		ResultSet set = AccountDataSqlHelperImpl.executeQuery(sql);
		try {
			if(set.next()){
				if(set.getString("id").equals(ID)){
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean check(String id, String password) {
		
		String sql = "select password from account where id="+id;
		ResultSet set = AccountDataSqlHelperImpl.executeQuery(sql);
		try{
			while(set.next()){
				String pass = set.getString("password");
				if(pass.equals(password)){
					return true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	/*public static void main(String args[]){
		
		AccountDataSqlHelperImpl account = new AccountDataSqlHelperImpl();
		/*account.insert("0001", "zxhzxh");
		account.insert("0002", "chenyuanzhi");
		account.insert("0003", "dengcong");
		account.insert("0004", "caiqimin");
		account.insert("0005", "13");
	   System.out.println(account.check("0001", "zxhzxh"));
		
	}*/
}
