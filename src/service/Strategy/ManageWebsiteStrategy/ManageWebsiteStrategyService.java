package service.Strategy.ManageWebsiteStrategy;

import java.util.List;

import vo.StrategyVO;

public interface ManageWebsiteStrategyService {

	/**
	 * @return �õ���վ������Ӫ������
	 * */
	public List<StrategyVO> getAllWebsiteStrategy();
	
	/**
	 * @param StrategyVO  Ӫ������
	 * @return �����µ�Ӫ������
	 * */
	public boolean addStrategy(StrategyVO strategyVO);
	
	/**
	 * @param StrategyVO Ӫ������
	 * @return StrategyID���䣬����վӪ�����Խ����޸�
	 * */
	public boolean changeStrategy(StrategyVO strategyVO);
	
	/**
	 * @param strategyID ���Ա��
	 * @return �Բ��Խ���ɾ��
	 * */
	public boolean deleteStrategy(String strategyID);
	
	
}
