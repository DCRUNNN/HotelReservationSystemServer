package service.Strategy.ProvidedService;

public interface StrategyProvidedService {

	/**
	 * @param hotelID �Ƶ���
	 * @param roomTotal Ԥ���ķ�����
	 * ��ͨ�ͻ���Ӧ���ۿ�ֻ�������ض��ڼ���Ԥ��������Ԥ����Ŀ�����ض�����
	 * @return ������͵��ۿ�
	 * */
	public double getBestStrategyForNormalUser(String hotelID, int roomTotal);

	/**
	 * @param hotelID �Ƶ���
	 * @param roomTotal ������Ŀ
	 * @param birthday ��Ա����
	 * @param vipGrade ��Ա�ȼ�
	 * ��ͨ��Ա��Ӧ���ۿ۰������ض��ڼ�Ԥ����Ԥ����Ŀ�����������ػݣ����ض���ȦԤ�����ۿ�
	 * @param hotelCBD �Ƶ����ڵ���Ȧ
	 * @param hotelCity �Ƶ����ڵĳ���
	 * @param hotelProvince �Ƶ����ڵ�ʡ��
	 * @return ��������ۿ�
	 * */
	public double getBestStrategyForNormalVip(String hotelID, int roomTotal, String birthday, int vipGrade, String hotelProvince, String hotelCity, String hotelCBD);

	/**
	 * @param hotelID �Ƶ���
	 * @param roomTotal ������Ŀ
	 * @param companyAddress ��ҵ����ϸ��ַ
	 * ��ҵ��Ա��Ӧ���ۿ۰������ض��ڼ�Ԥ����Ԥ����Ŀ�������ھƵ����Ż�
	 * @return ��������ۿ�
	 * */
	public double getBestStrategyForCompanyVip(String hotelID, int roomTotal,String companyAddress);
	
}
