package service.Order.CreateOrderID;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import data.dao.OrderDao;
import data.dao.impl.OrderDaoImpl;
import po.OrderPO;

public class CreateOrderID {

	/*
	 * 给订单编号：编号规则： 时间戳+四位的序列号（从0开始）
	 * */
	private OrderDao orderDao;
	private final static int LENGTHOFTAIL = 4;//限制尾数只能为4位
	
	public CreateOrderID(){
		
		orderDao = OrderDaoImpl.getInstance();//完成了dao的实例化
	}
	
	public String nextId(){
		
		synchronized(this){
			
			OrderPO po = new OrderPO();
			
			List<String> allIds = orderDao.getAllIDs();
			String today = new SimpleDateFormat("yyyyMMdd").format(new Date());//今天的缩写
			if(allIds.size()==0||allIds==null){
				//还没有编号的话
				po.setOrderID(today+"0001");
				if(!orderDao.insertNewOrder(po)){
					return "";
				}
				return today+"0001";//直接返回今天的缩写+序号
			}
			
			List<Integer> allTodayID = new ArrayList<Integer>();
			for(String str:allIds){
				String date = str.substring(0,8);
				if(today.equals(date)){
					//遍历所有订单号,找到所有今天的订单号
					allTodayID.add(Integer.valueOf(str.substring(8)));//把今天的id记录下来
				}
			}
			
			if(allTodayID.size()==0){
				//今天没有订单
				po.setOrderID(today+"0001");
				if(!orderDao.insertNewOrder(po)){
					return "";
				}
				return today+"0001";
			}
			
			int max = 0;
			for(int i:allTodayID){
				if(i>max){
					max=i;
				}
			}//找出最大值，就是今天的最大订单数
			
			if(max==9999){
				return "";//订单号达到上限了
			}else{
				int value = max+1;
				String newId = String.valueOf(value);
				int length = newId.length();
				String zero = "";
				for(int i=0;i<LENGTHOFTAIL-length;i++){
					zero+="0";
				}
				po.setOrderID(today+zero+value);
				if(!orderDao.insertNewOrder(po)){
					return "";
				}
				return today+zero+value;
			}
		}
	}
}
