package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import service.Credit.AddClientCredit.AddClientCreditService;
import service.Credit.AddClientCredit.AddClientCreditServiceImpl;
import service.Order.BrowseOrder_webWorker.BrowseOrder_webWorkerService;
import service.Order.BrowseOrder_webWorker.BrowseOrder_webWorkerServiceImpl;
import service.Strategy.ManageWebsiteStrategy.ManageWebsiteStrategyService;
import service.Strategy.ManageWebsiteStrategy.ManageWebsiteStrategyServiceImpl;
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
	
	protected WebSalerDataRemoteObject() throws RemoteException {
		
		super();
		websiteStrategy = new ManageWebsiteStrategyServiceImpl();
		browseOrder = new BrowseOrder_webWorkerServiceImpl();
		addcredit = new AddClientCreditServiceImpl();
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
}