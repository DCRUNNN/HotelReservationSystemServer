package data.dao.impl;

/**
 * @author Cong Deng
 */
import java.util.List;

import data.dao.StrategyDao;
import data.datahelper.DataFactory;
import data.datahelper.StrategyDataHelper;
import data.datahelper.impl.DataFactoryImpl;
import po.StrategyPO;

public class StrategyDaoImpl implements StrategyDao {

	private StrategyDataHelper strategyDataHelper;
	
	private DataFactory dataFactory;
	
	private static final StrategyDaoImpl INSTANCE=new StrategyDaoImpl();
	
	//���õ���ģʽ ������ص�ʱ����ɳ�ʼ�����������߳�ͬ������
	private StrategyDaoImpl() {
		
		dataFactory=new DataFactoryImpl();
		strategyDataHelper=dataFactory.getStrategyDataHelper();
	}
	
	public static StrategyDaoImpl getInstance(){
		return INSTANCE;
	}//ͨ������static���������RoomDaoImpl��ʵ��
	
	@Override
	public List<StrategyPO> getAllHotelStrategies(String hotelId) {
		
		return strategyDataHelper.getHotelStrategies(hotelId);
	}

	@Override
	public boolean changeStrategy(StrategyPO po) {
		
		return strategyDataHelper.changeStrategy(po);
	}

	@Override
	public boolean addStrategy(StrategyPO po) {
	
		return strategyDataHelper.addStrategy(po);
	}

	@Override
	public List<StrategyPO> getAllWebsiteStrategies() {
		
		return strategyDataHelper.getAllWebsiteStrategies();
	}

	@Override
	public boolean deleteStrategy(String strategyID) {
		
		return strategyDataHelper.deleteStrategy(strategyID);
	}

	@Override
	public List<String> getAllIDs() {
		
		return strategyDataHelper.getAllIds();
	}

}
