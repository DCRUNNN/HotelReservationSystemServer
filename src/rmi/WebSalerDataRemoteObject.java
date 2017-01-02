package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.datahelper.xmlhelper.XMLHelper;
import service.Credit.AddClientCredit.AddClientCreditService;
import service.Order.BrowseOrder_webWorker.BrowseOrder_webWorkerService;
import service.Strategy.ManageWebsiteStrategy.ManageWebsiteStrategyService;
import vo.ClientVO;
import vo.OrderVO;
import vo.StrategyVO;

public class WebSalerDataRemoteObject extends UnicastRemoteObject implements ManageWebsiteStrategyService,
             BrowseOrder_webWorkerService,AddClientCreditService{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3677211887410044321L;
	
	private ManageWebsiteStrategyService websiteStrategy;
	private BrowseOrder_webWorkerService browseOrder;
	private AddClientCreditService addcredit;
	
	public WebSalerDataRemoteObject() throws RemoteException {
		
		super();
		String filePath = "./xml/servicexml/websalerservice.xml";
		try {
			websiteStrategy = (ManageWebsiteStrategyService) Class.forName(XMLHelper.getClass(filePath, "websiteStrategy")).newInstance();
			browseOrder = (BrowseOrder_webWorkerService) Class.forName(XMLHelper.getClass(filePath, "browseOrder")).newInstance();
			addcredit = (AddClientCreditService) Class.forName(XMLHelper.getClass(filePath, "addcredit")).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean addCredit(String clientID, double point) throws RemoteException {
		
		return addcredit.addCredit(clientID, point);
	}

	@Override
	public List<OrderVO> getAllUnexecutedOrders()throws RemoteException {
		
		return browseOrder.getAllUnexecutedOrders();
	}

	@Override
	public List<OrderVO> getAllAbnormalOrders() throws RemoteException {
		
		return browseOrder.getAllAbnormalOrders();
	}

	@Override
	public boolean withdrawAbnormalOrder(String orderID) throws RemoteException {
		
		return browseOrder.withdrawAbnormalOrder(orderID);
	}

	@Override
	public OrderVO getOrderVO(String orderID) throws RemoteException {
		
		return browseOrder.getOrderVO(orderID);
	}

	@Override
	public List<OrderVO> getClientAbnormalOrders(String clientID) throws RemoteException {
		
		return browseOrder.getClientAbnormalOrders(clientID);
	}

	@Override
	public List<StrategyVO> getAllWebsiteStrategy() throws RemoteException {
		
		return websiteStrategy.getAllWebsiteStrategy();
	}

	@Override
	public boolean addStrategy(StrategyVO strategyVO) throws RemoteException {
		
		return websiteStrategy.addStrategy(strategyVO);
	}

	@Override
	public boolean changeStrategy(StrategyVO strategyVO) throws RemoteException {
		
		return websiteStrategy.changeStrategy(strategyVO);
	}

	@Override
	public boolean deleteStrategy(String strategyID) throws RemoteException {
		
		return websiteStrategy.deleteStrategy(strategyID);
	}

	@Override
	public ClientVO getClientVO(String clientID) throws RemoteException {
		
		return addcredit.getClientVO(clientID);
	}

	@Override
	public boolean checkID(String clientID) throws RemoteException {
		
		return addcredit.checkID(clientID);
	}

	@Override
	public List<String> getAllProvinces() throws RemoteException {
		// TODO Auto-generated method stub
		return websiteStrategy.getAllProvinces();
	}

	@Override
	public List<String> getCities(String province) throws RemoteException {
		// TODO Auto-generated method stub
		return websiteStrategy.getCities(province);
	}

	@Override
	public List<String> getCBDS(String province, String city) throws RemoteException {
		// TODO Auto-generated method stub
		return websiteStrategy.getCBDS(province, city);
	}
}
