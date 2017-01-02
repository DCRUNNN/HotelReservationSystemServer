package service.Credit.AddClientCredit;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import data.dao.CreditDAO;
import data.dao.impl.CreditDaoImpl;
import po.CreditPO;
import service.Client.ProvidedService.ClientProvidedService;
import service.Client.ProvidedService.ClientProvidedServiceImpl;
import vo.ClientVO;

public class AddClientCreditServiceImpl implements AddClientCreditService{

	private CreditDAO creditDao;
	private ClientProvidedService clientservice;
	
	public AddClientCreditServiceImpl(){
		
		creditDao = CreditDaoImpl.getInstance();
		clientservice = new ClientProvidedServiceImpl();
	}
	@Override
	public boolean addCredit(String clientID, double point) throws RemoteException{
		
		if(!clientservice.addClientCreditPoint(clientID, point)){
			return false;
		}
		CreditPO po = new CreditPO();
		po.setCause("–≈”√≥‰÷µ");
		po.setChange("+"+point);
		po.setClientID(clientID);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		po.setTime(time);
		
		return creditDao.insert(po);
	}
	
	@Override
	public ClientVO getClientVO(String clientID) throws RemoteException {
		
		return clientservice.getClientVO(clientID);
	}
	@Override
	public boolean checkID(String clientID) throws RemoteException {
		
		return clientservice.checkID(clientID);
	}

}
