package data.datahelper;

public interface DataFactory {
	
	public OrderDataHelper getOrderDataHelper();

	public AccountDataHelper getAccountDataHelper();

	public RoomDataHelper getRoomDataHelper();

	public StrategyDataHelper getStrategyDataHelper();

	public CreditDataHelper getCreditDataHelper();

	public ClientDataHelper getClientDataHelper();

	public PersonnelDataHelper getPersonnelDataHelper();

	public HotelDataHelper getHotelDataHelper();
}
