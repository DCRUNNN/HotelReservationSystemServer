package data.dao.impl;

import java.util.List;

import data.dao.ClientDAO;
import data.datahelper.ClientDataHelper;
import data.datahelper.DataFactory;
import data.datahelper.impl.DataFactoryImpl;
import po.ClientPO;

public class ClientDaoImpl implements ClientDAO{
	
private ClientDataHelper clientDataHelper;
	
	private DataFactory dataFactory;
	
	private static final ClientDaoImpl INSTANCE = new ClientDaoImpl();

	//运用单例模式 在类加载的时候完成初始化，不存在线程同步问题
	private ClientDaoImpl() {
		
		dataFactory=new DataFactoryImpl();
		clientDataHelper=dataFactory.getClientDataHelper();
	}
	
	public static ClientDaoImpl getInstance(){
		return INSTANCE;
	} //通过调用static方法来获得CreditDaoImpl的实例
	
	@Override
	public ClientPO getClientPO(String client_id) {
		
		return clientDataHelper.getClientPO(client_id);
	}

	@Override
	public double getClientPoint(String clientID) {
	
		return clientDataHelper.getClientPoint(clientID);
	}

	@Override
	public boolean setVipGrade(String clientID, int grade) {
		
		return clientDataHelper.setVipGrade(clientID, grade);
	}

	@Override
	public boolean subClientCreditPoint(String clientID, double left) {
		
		return clientDataHelper.subClientCreditPoint(clientID, left);
	}

	@Override
	public boolean addClientCreditPoint(String clientID, double left) {
		
		return clientDataHelper.addClientCreditPoint(clientID, left);
	}

	@Override
	public String getUserType(String clientID) {
		
		return clientDataHelper.getUserType(clientID);
	}

	@Override
	public boolean change(ClientPO po) {
	
		return clientDataHelper.change(po);
	}

	@Override
	public List<ClientPO> getAllClient() {
	
		return clientDataHelper.getAllClient();
	}

	@Override
	public List<String> getAllIds() {
	
		return clientDataHelper.getAllIds();
	}

	//缺一个方法实现 下周在写了
	@Override
	public boolean insert(ClientPO po) {
		
		return clientDataHelper.insert(po);
	}

}
