package service.Order.CreateOrder;

import service.Client.ProvidedService.ClientProvidedService;
import service.Client.ProvidedService.ClientProvidedServiceImpl;
import service.Strategy.ProvidedService.StrategyProvidedService;
import service.Strategy.ProvidedService.StrategyProvidedServiceImpl;

/**
 * ������clientģ���strategyģ����н���
 * @see StrategyProvidedService
 * @see ClientProvidedService
 * */
public class AboutStrategy {

	private StrategyProvidedService strategyservice;
	private ClientProvidedService clientservice;
	
	public AboutStrategy(){
		strategyservice = new StrategyProvidedServiceImpl();
		clientservice = new ClientProvidedServiceImpl();
	}
	
	/**
	 * @param clientID �ͻ����
	 * @param hotelInfo �Ƶ������Ϣ(hotelID+"/"+hotelProvince+"/"+hotelCity+"/"+hotelCBD+"/"+hotelName)
	 * @param roomTotal ��������
	 * @return �õ��ͻ��ڸþƵ���ۺϵ����ŻݵĲ���
	 * */
	public double getPriceByStrategy(String clientID,String hotelInfo,int roomTotal){
		
		 double discount = 0;
		 String userType = clientservice.getUserType(clientID);
		 //�Կͻ����͵ļ��ж��߼��������
		 if("��ͨ�ͻ�".equals(userType)){
			 //����ͨ�ͻ��Ļ�����Ӧ���ۿ�ֻ�������ض��ڼ���Ԥ��������Ԥ����Ŀ�����ض�����
			 discount = strategyservice.getBestStrategyForNormalUser(hotelInfo,roomTotal);
		 }else if("��ͨ��Ա".equals(userType)){
			 //��ͨ��Ա�Ļ�����Ӧ���ۿ۰������ض��ڼ�Ԥ����Ԥ����Ŀ�����������ػݣ����ض���ȦԤ�����ۿ�
			 String birthday = clientservice.getVipBirthday(clientID);
			 int vipGrade = clientservice.getVipGrade(clientID);
			 discount = strategyservice.getBestStrategyForNormalVip(hotelInfo,roomTotal,birthday,vipGrade);
		 }else{
			 //��ҵ��Ա�Ļ�����Ӧ���ۿ۰������ض��ڼ�Ԥ����Ԥ����Ŀ���������ض��ľƵ����Ż�
			 
			 discount = strategyservice.getBestStrategyForCompanyVip(hotelInfo,roomTotal);
		 }
         
         return discount;
	}

	/**
	 * @return �жϿͻ�������ֵ�Ƿ���ڵ���0
	 * */
	public boolean checkCreditPoint(String clientID) {
		return clientservice.checkCreditPoint(clientID);
	}
}
