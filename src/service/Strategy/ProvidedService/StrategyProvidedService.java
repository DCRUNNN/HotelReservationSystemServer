package service.Strategy.ProvidedService;

public interface StrategyProvidedService {

	/**
	 * @param hotelInfo �Ƶ���Ϣ(hotelID+hotelProvince+hotelCity+hotelCBD+hotelName)�ָ�����"/"
	 * @param roomTotal Ԥ���ķ�����
	 * ��ͨ�ͻ���Ӧ���ۿ�ֻ�������ض��ڼ���Ԥ��������Ԥ����Ŀ�����ض�����
	 * @return ������͵��ۿ�
	 * */
	public double getBestStrategyForNormalUser(String hotelInfo, int roomTotal);

	/**
	 * @param hotelInfo �Ƶ���Ϣ
	 * @param roomTotal ������Ŀ
	 * @param birthday ��Ա����
	 * @param vipGrade ��Ա�ȼ�
	 * ��ͨ��Ա��Ӧ���ۿ۰������ض��ڼ�Ԥ����Ԥ����Ŀ�����������ػݣ����ض���ȦԤ�����ۿ�
	 * @return ��������ۿ�
	 * */
	public double getBestStrategyForNormalVip(String hotelInfo, int roomTotal, String birthday, int vipGrade);

	/**
	 * @param hotelInfo �Ƶ���Ϣ
	 * @param roomTotal ������Ŀ
	 * ��ҵ��Ա��Ӧ���ۿ۰������ض��ڼ�Ԥ����Ԥ����Ŀ�������ھƵ����Ż�
	 * @return ��������ۿ�
	 * */
	public double getBestStrategyForCompanyVip(String hotelInfo, int roomTotal);
	
}
