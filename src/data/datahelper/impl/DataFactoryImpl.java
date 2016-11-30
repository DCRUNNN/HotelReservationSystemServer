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

public class DataFactoryImpl implements DataFactory {

	@Override
	public OrderDataHelper getOrderDataHelper() {

		OrderDataHelper helper = new OrderDataSqlHelperImpl();
		return helper;
	}

	@Override
	public AccountDataHelper getAccountDataHelper() {
		
		AccountDataHelper helper = new AccountDataSqlHelperImpl();
		return helper;
	}

	@Override
	public RoomDataHelper getRoomDataHelper() {
		
		RoomDataHelper helper = new RoomDataSqlHelperImpl();
		return helper;
	}

	@Override
	public StrategyDataHelper getStrategyDataHelper() {
		
		StrategyDataHelper helper = new StrategyDataSqlHelperImpl();
		return helper;
	}

	@Override
	public CreditDataHelper getCreditDataHelper() {
		
		CreditDataHelper helper = new CreditDataSqlHelperImpl();
		return helper;
	}

	@Override
	public ClientDataHelper getClientDataHelper() {
		
		ClientDataHelper helper = new ClientDataSqlHelperImpl();
		return helper;
	}

	@Override
	public PersonnelDataHelper getPersonnelDataHelper() {
		
		PersonnelDataHelper helper = new PersonnelDataSqlHelperImpl();
		return helper;
	}

	@Override
	public HotelDataHelper getHotelDataHelper() {
		
		HotelDataHelper helper = new HotelDataSqlHelperImpl();
		return helper;
	}

	
}
