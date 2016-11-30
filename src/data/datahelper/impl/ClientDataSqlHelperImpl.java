package data.datahelper.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.datahelper.ClientDataHelper;
import po.ClientPO;

public class ClientDataSqlHelperImpl implements ClientDataHelper{
	
	private static final String DRIVER = "org.gjt.mm.mysql.Driver";//数据库连接驱动类
	private static final String URL = "jdbc:mysql://localhost:3306/bighomework";//url
	private static final String USER = "root";
	private static final String PASSWORD = "mysql";
	private static Connection conn = null;	
	
	public ClientDataSqlHelperImpl (){
		
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
				new ClientDataSqlHelperImpl();
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
				new ClientDataSqlHelperImpl();
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
	public ClientPO getClientPO(String client_id) {
		
		ClientPO po = new ClientPO();
		String sql = "select *from t_client where clientid="+client_id;
		ResultSet set = ClientDataSqlHelperImpl.executeQuery(sql);
		try {
			while(set.next()){
				
				String id=set.getString("clientid");
				String name=set.getString("name");
				String sex=set.getString("sex");
				String identityId = set.getString("identityid");
				double credit_point=set.getDouble("credit_point");
				String phoneNumber=set.getString("phonenumber");
				String clientType=set.getString("clienttype");
				String birthday=set.getString("birthday");
				int vipGrade=set.getInt("vipgrade");
				String companyName=set.getString("companyname");
				String companyAddress=set.getString("companyaddress");
				//create a po object to transmit
				po.setId(id);
				po.setName(name);
				po.setSex(sex);
				po.setIdentityID(identityId);
				po.setCredit_point(credit_point);
				po.setPhoneNumber(phoneNumber);
				po.setClientType(clientType);
				po.setCompanyAddress(companyAddress);
				po.setCompanyName(companyName);
				po.setBirthday(birthday);
				po.setVipGrade(vipGrade);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ClientDataSqlHelperImpl.close();
		return po;
	}

	@Override
	public double getClientPoint(String client_id) {
		
		double clientcreditpoint=0;
		String sql = "select credit_point from t_client where clientid="+client_id;
		ResultSet set=ClientDataSqlHelperImpl.executeQuery(sql);
		try{
			while(set.next()){
			   clientcreditpoint=set.getDouble("credit");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		ClientDataSqlHelperImpl.close();
		return clientcreditpoint;
	}

	@Override
	public boolean setVipGrade(String client_id, int grade) {
		
		String sql="update t_client set vipgrade="+grade+" where clientid="+client_id;
		int i=ClientDataSqlHelperImpl.executeUpdate(sql);
		ClientDataSqlHelperImpl.close();
		if(i==-1){
			return false;
		}
		return true;
	}

	@Override
	public boolean subClientCreditPoint(String client_id, double left) {
		String sql="update t_client set credit_point="+left+" where clientid="+client_id;
		int i=ClientDataSqlHelperImpl.executeUpdate(sql);
		ClientDataSqlHelperImpl.close();
		if(i==-1){
			return false;
		}
		return true;
	}

	@Override
	public boolean addClientCreditPoint(String client_id, double left) {
		String sql="update t_client set credit_point="+left+" where clientid="+client_id;
		int i=ClientDataSqlHelperImpl.executeUpdate(sql);
		ClientDataSqlHelperImpl.close();
		if(i==-1){
			return false;
		}
		return true;
	}

	@Override
	public boolean change(ClientPO po) {
		
		String id=po.getId();
		String name=po.getName();
		String sex=po.getSex();
		String identityid = po.getIdentityID();
		double credit_point=po.getCredit_point();
		String phoneNumber=po.getPhoneNumber();
		String clientType=po.getClientType();
		String birthday=po.getBirthday();
		int vipGrade=po.getVipGrade();
		String companyName=po.getCompanyName();
		String companyAddress=po.getCompanyAddress();
		
		String sql = "update t_client set clientid='"+id+"',name='"+name+"',sex='"+sex+"',identityid='"+identityid+"',credit_point="+credit_point
				+",phonenumber='"+phoneNumber+"',clienttype='"+clientType+"',birthday='"+birthday+"',vipgrade="+vipGrade+",companyname='"+companyName+"',companyaddress='"+companyAddress
				+"' where clientid="+id;
		
		int i = ClientDataSqlHelperImpl.executeUpdate(sql);
		ClientDataSqlHelperImpl.close();
		if(i==-1){
			return false;
		}
		return true;
	}

	@Override
	public String getUserType(String client_id) {
		
		String usertype="";
		String sql = "select clienttype from t_client where clientid="+client_id;
		ResultSet set=ClientDataSqlHelperImpl.executeQuery(sql);
		try{
			while(set.next()){
				usertype=set.getString("clienttype");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return usertype;
	}

	@Override
	public List<ClientPO> getAllClient() {
		
		List<ClientPO> clientList=new ArrayList<ClientPO>();		
		//create sql statement
		String sql="SELECT * FROM t_client";
		ResultSet set=ClientDataSqlHelperImpl.executeQuery(sql);
		try{
			while(set.next()){
				
				String id=set.getString("clientid");
				String name=set.getString("name");
				String sex=set.getString("sex");
				String identityid = set.getString("identityid");
				double credit_point=set.getDouble("credit_point");
				String phoneNumber=set.getString("phonenumber");
				String clientType=set.getString("clienttype");
				String birthday=set.getString("birthday");
				int vipGrade=set.getInt("vipgrade");
				String companyName=set.getString("companyname");
				String companyAddress=set.getString("companyaddress");
				//create a po object to transmit
				ClientPO po=new ClientPO();
				po.setId(id);
				po.setName(name);
				po.setSex(sex);
				po.setIdentityID(identityid);
				po.setCredit_point(credit_point);
				po.setPhoneNumber(phoneNumber);
				po.setClientType(clientType);
				po.setCompanyAddress(companyAddress);
				po.setCompanyName(companyName);
				po.setBirthday(birthday);
				po.setVipGrade(vipGrade);
				clientList.add(po);
			}
			ClientDataSqlHelperImpl.close();
			return clientList;
		}catch(SQLException e){
			PersonnelDataSqlHelperImpl.close();
			e.printStackTrace();
			return clientList;
		}
	}

	@Override
	public List<String> getAllIds() {
		
		List<String> allids= new ArrayList<String>();
		String sql="select *from t_client";
		ResultSet set=ClientDataSqlHelperImpl.executeQuery(sql);
		try{
			while(set.next()){
				String id=set.getString("clientid");
				allids.add(id);
			}
			ClientDataSqlHelperImpl.close();
			return allids;
		}catch(SQLException e){
			e.printStackTrace();
			return allids;
		}
	}

	@Override
	public boolean insert(ClientPO po) {
		
		String id=po.getId();
		String name=po.getName();
		String sex=po.getSex();
		String identityid = po.getIdentityID();
		double credit_point=po.getCredit_point();
		String phoneNumber=po.getPhoneNumber();
		String clientType=po.getClientType();
		String birthday=po.getBirthday();
		int vipGrade=po.getVipGrade();
		String companyName=po.getCompanyName();
		String companyAddress=po.getCompanyAddress();
		
		String sql ="insert into t_client(clientid,name,sex,identityid,credit_point,phonenumber,clienttype,birthday,vipgrade,companyname,companyaddress)  "
				+"values('"+id+"','"+name+"','"+sex+"','"+identityid+"',"+credit_point+",'"+phoneNumber+"','"+clientType+"','"+birthday+"',"+vipGrade+",'"
				+companyName+"','"+companyAddress+"');";
		
		int i = ClientDataSqlHelperImpl.executeUpdate(sql);
		if(i==-1){
			ClientDataSqlHelperImpl.close();
			return false;
		}
		ClientDataSqlHelperImpl.close();
		return true;
	}

}
