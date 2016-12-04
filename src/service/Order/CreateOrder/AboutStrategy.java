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
	 * @param hotelID �Ƶ���
	 * @param roomTotal ��������
	 * @param hotelCBD �Ƶ����ڵ���Ȧ
	 * @param hotelCity �Ƶ����ڵĳ���
	 * @param hotelProvince �Ƶ����ڵ�ʡ��
	 * @return �õ��ͻ��ڸþƵ���ۺϵ����ŻݵĲ��� ����8��
	 * */
	public double getPriceByStrategy(String clientID,String hotelID,int roomTotal, String hotelProvince, String hotelCity, String hotelCBD){
		
		 double discount = 0;
		 String userType = clientservice.getUserType(clientID);
		 //�Կͻ����͵ļ��ж��߼��������
		 if("��ͨ�ͻ�".equals(userType)){
			 //����ͨ�ͻ��Ļ�����Ӧ���ۿ�ֻ�������ض��ڼ���Ԥ��������Ԥ����Ŀ�����ض�����
			 discount = strategyservice.getBestStrategyForNormalUser(hotelID,roomTotal);
		 }else if("��ͨ��Ա".equals(userType)){
			 //��ͨ��Ա�Ļ�����Ӧ���ۿ۰������ض��ڼ�Ԥ����Ԥ����Ŀ�����������ػݣ����ض���ȦԤ�����ۿ�
			 String birthday = clientservice.getVipBirthday(clientID);
			 int vipGrade = clientservice.getVipGrade(clientID);
			 discount = strategyservice.getBestStrategyForNormalVip(hotelID,roomTotal,birthday,vipGrade,hotelProvince,hotelCity,hotelCBD);
		 }else if("��ҵ��Ա".equals(userType)){
			 //��ҵ��Ա�Ļ�����Ӧ���ۿ۰������ض��ڼ�Ԥ����Ԥ����Ŀ���������ض��ľƵ����Ż�
			 if(clientservice.isCorrectCompanyVip(clientID,hotelID)){
				 //�ͻ�������ҵ�����Ƶ���ס ����Ҫ�жϾƵ���û���ṩ�����ҵ���Żݲ���
				 String companyAddress = clientservice.getCompanyAddress(clientID);
				 discount = strategyservice.getBestStrategyForCompanyVip(hotelID,roomTotal,companyAddress);
			 }
		 }else{
			 //���߶����ǵĻ� ��ô������ͨ��Ա����ҵ��Ա������
			 String birthday = clientservice.getVipBirthday(clientID);
			 int vipGrade = clientservice.getVipGrade(clientID);
			 String companyAddress = clientservice.getCompanyAddress(clientID);
			 double discount1 = strategyservice.getBestStrategyForNormalVip(hotelID,roomTotal,birthday,vipGrade,hotelProvince,hotelCity,hotelCBD);

			 double discount2 = strategyservice.getBestStrategyForCompanyVip(hotelID,roomTotal,companyAddress);
		     discount = Double.min(discount1, discount2);//�ҵ����ߵĽ�Сֵ
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
