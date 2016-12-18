package service.Order.BrowseOrder_webWorker;

import java.text.SimpleDateFormat;
import java.util.Date;

import data.dao.OrderDao;
import data.dao.impl.OrderDaoImpl;
import po.CreditPO;
import po.OrderPO;
import service.Client.ProvidedService.ClientProvidedService;
import service.Client.ProvidedService.ClientProvidedServiceImpl;
import service.Credit.ProvidedService.CreditProvidedService;
import service.Credit.ProvidedService.CreditProvidedServiceImpl;

/**
 * 负责与撤销异常订单相关的功能，主要负责与其他模块进行交互
 * @see OrderDao
 * @see ClientProvidedService
 * @see CreditProvidedService
 * */
public class WithdrawAbnormalOrder {

	private OrderDao orderdao;
	private ClientProvidedService clientservice;
	private CreditProvidedService creditservice;
	
	public WithdrawAbnormalOrder(){
		
		orderdao = OrderDaoImpl.getInstance();
		clientservice = new ClientProvidedServiceImpl();
		creditservice = new CreditProvidedServiceImpl();

	}
	
	public boolean withdraw(String orderID){
		
		OrderPO po = orderdao.getOrderPO(orderID);
		if(po==null){
			return false;
		}else{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String current = sdf.format(new Date());
			po.setWithdrawTime(current);
			po.setOrderStatus("已撤销");
			if(!orderdao.change(po)){
				return false;
			}//完成了改变订单的相关部分
			
			double point = po.getPrice()/2;//增加客户订单价格一半的信用点
			String clientID = po.getClientID();
			if(!clientservice.addClientCreditPoint(clientID, point)){
				return false;
			}//完成了增加客户信用值
			
			CreditPO creditpo = new CreditPO();
			creditpo.setCause("撤销异常");
			creditpo.setChange("+"+point);
			creditpo.setClientID(po.getClientID());
			creditpo.setOrderID(po.getOrderID());
			creditpo.setTime(current);
			if(!creditservice.insertCredit(creditpo)){
				return false;
			}//完成了信用记录的增加
		}
		
		return true;
	}
}
