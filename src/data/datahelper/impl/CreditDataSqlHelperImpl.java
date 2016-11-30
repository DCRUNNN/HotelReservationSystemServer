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
	
	private static final String DRIVER = "org.gjt.mm.mysql.Driver";//���ݿ�����������
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
		}//������Ӷ���
	}
	
	/**
	 *@param sql sql���
	 *@return ResultSet ����sql������䷵�صĽ�� 
	 * */
	private static ResultSet executeQuery(String sql){
		//���ݿ�Ĳ�ѯ����
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
	 * @param sql sql���
	 * @return ����Ӱ���������û�еĻ�����0�����쳣�Ļ�����-1
	 * */
	private static int executeUpdate (String sql){
		//sql��������insert,update,deleteִ����֮�󷵻�Ӱ��������
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
		//�رշ���
		try{
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			conn =null;//����������Ӷ���Ϊ��
		}
	}

	@Override
	public List<CreditPO> getAllClientCreditPO(String clientID) {
		
		List<CreditPO> list = new ArrayList<CreditPO>();
		String sql = "select *from t_credit where clientid="+clientID;
		ResultSet set = CreditDataSqlHelperImpl.executeQuery(sql);
		try {
			while(set.next()){
				//����ѯ���ÿһ�������ȡ����
				String orderid = set.getString("orderid");
				String clientid = set.getString("clientid");
				String time = set.getString("time");
				String cause = set.getString("cause");
				String change = set.getString("change");
				
				//�������γ�һ��PO����
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
