package data.datahelper.impl;


import data.datahelper.AccountDataHelper;
import data.datahelper.ClientDataHelper;
import data.datahelper.CreditDataHelper;
import data.datahelper.DataFactory;
import data.datahelper.HotelDataHelper;
import data.datahelper.OrderDataHelper;
import data.datahelper.PersonnelDataHelper;
import data.datahelper.RoomDataHelper;
import data.datahelper.StrategyDataHelper;
import data.datahelper.factory.AccountFactory;
import data.datahelper.factory.ClientFactory;
import data.datahelper.factory.CreditFactory;
import data.datahelper.factory.HotelFactory;
import data.datahelper.factory.OrderFactory;
import data.datahelper.factory.PersonnelFactory;
import data.datahelper.factory.RoomFactory;
import data.datahelper.factory.StrategyFactory;

public class DataFactoryImpl implements DataFactory {

	
	@Override
	public OrderDataHelper getOrderDataHelper() {

		OrderDataHelper helper = OrderFactory.getOrderDataHelper();
		return helper;
	}

	@Override
	public AccountDataHelper getAccountDataHelper() {
		
		AccountDataHelper helper = AccountFactory.getAccountDataHelper();
		return helper;
	}

	@Override
	public RoomDataHelper getRoomDataHelper() {
		
		RoomDataHelper helper = RoomFactory.getRoomDataHelper();
		return helper;
	}

	@Override
	public StrategyDataHelper getStrategyDataHelper() {
		
		StrategyDataHelper helper = StrategyFactory.getStrategyDataHelper();
		return helper;
	}

	@Override
	public CreditDataHelper getCreditDataHelper() {
		
		CreditDataHelper helper = CreditFactory.getCreditDataHelper();
		return helper;
	}

	@Override
	public ClientDataHelper getClientDataHelper() {
		
		ClientDataHelper helper = ClientFactory.getClientDataHelper();
		return helper;
	}

	@Override
	public PersonnelDataHelper getPersonnelDataHelper() {
		
		PersonnelDataHelper helper = PersonnelFactory.getPersonnelDataHelper();
		return helper;
	}

	@Override
	public HotelDataHelper getHotelDataHelper() {
		
		HotelDataHelper helper = HotelFactory.getHotelDataHelper();
		return helper;
	}

	
}
