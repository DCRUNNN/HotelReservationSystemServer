package service.Credit.ShowCreditRecord;

import java.util.ArrayList;
import java.util.List;

import data.dao.CreditDAO;
import data.dao.impl.CreditDaoImpl;
import po.CreditPO;
import service.Client.ProvidedService.ClientProvidedService;
import service.Client.ProvidedService.ClientProvidedServiceImpl;
import vo.CreditVO;

public class ShowCreditRecordServiceImpl implements ShowCreditRecordService{

	private CreditDAO creditDao;
	private ClientProvidedService clientService;
	
	public ShowCreditRecordServiceImpl(){
	
		creditDao = CreditDaoImpl.getInstance();
		clientService = new ClientProvidedServiceImpl();
	}
	
	@Override
	public List<CreditVO> ShowAllCredit(String clientID) {
		
		List<CreditPO> polist = creditDao.getAllClientCreditPO(clientID);
		if(polist==null){
			//��������ݲ�õ���listΪ�յĻ���ֱ�ӷ��ؿ�
			return null;
		}
		List<CreditVO> volist = new ArrayList<CreditVO>();
		for(CreditPO po:polist){
		   CreditVO vo = new CreditVO(po);
		   volist.add(vo);
		}
		return volist;
	}

	@Override
	public double getCreditPoint(String clientID) {
	
		return clientService.getCreditPoint(clientID);
	}

}
