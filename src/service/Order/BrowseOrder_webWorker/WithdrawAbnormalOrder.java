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
 * �����볷���쳣������صĹ��ܣ���Ҫ����������ģ����н���
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
			po.setOrderStatus("�ѳ���");
			if(!orderdao.change(po)){
				return false;
			}//����˸ı䶩������ز���
			
			double point = po.getPrice()/2;//���ӿͻ������۸�һ������õ�
			String clientID = po.getClientID();
			if(!clientservice.addClientCreditPoint(clientID, point)){
				return false;
			}//��������ӿͻ�����ֵ
			
			CreditPO creditpo = new CreditPO();
			creditpo.setCause("�����쳣");
			creditpo.setChange("+"+point);
			creditpo.setClientID(po.getClientID());
			creditpo.setOrderID(po.getOrderID());
			creditpo.setTime(current);
			if(!creditservice.insertCredit(creditpo)){
				return false;
			}//��������ü�¼������
		}
		
		return true;
	}
}
