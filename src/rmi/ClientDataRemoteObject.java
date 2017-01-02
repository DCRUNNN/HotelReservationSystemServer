package rmi;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.datahelper.xmlhelper.XMLHelper;
import service.Client.ApplyForVip.ApplyForVipService;
import service.Client.ManageClientMessage_client.ManageClientMessage_clientService;
import service.Credit.ShowCreditRecord.ShowCreditRecordService;
import service.Hotel.BrowseHotel.BrowseHotelService;
import service.Hotel.MyHotel.MyHotelService;
import service.Hotel.SearchHotel.SearchHotelService;
import service.Order.CreateOrder.CreateOrderService;
import service.Order.EvaluateOrder.EvaluateOrderService;
import service.Order.MyOrder.MyOrderService;
import vo.ClientVO;
import vo.CreditVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.SearchVO;

public class ClientDataRemoteObject extends UnicastRemoteObject 
    implements ManageClientMessage_clientService,MyOrderService,MyHotelService,ShowCreditRecordService
    ,BrowseHotelService,SearchHotelService,CreateOrderService,EvaluateOrderService,ApplyForVipService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3573180055433011613L;
	private ManageClientMessage_clientService manageMessage;
	private MyOrderService myOrder;
	private MyHotelService myHotel;
	private ShowCreditRecordService showCredit;
	private BrowseHotelService browseHotel;
	private SearchHotelService searchHotel;
	private CreateOrderService createOrder;
	private EvaluateOrderService evaluateOrder;
	private ApplyForVipService applyVip;
	
	public ClientDataRemoteObject() throws RemoteException {
		
		super();
		String filePath = "./xml/servicexml/clientservice.xml";
		try {
			//利用反射机制和配置文件 加强可修改性
			manageMessage = (ManageClientMessage_clientService)Class.forName(XMLHelper.getClass(filePath, "manageMessage")).newInstance();
			myOrder = (MyOrderService)Class.forName(XMLHelper.getClass(filePath, "myOrder")).newInstance();
			myHotel = (MyHotelService)Class.forName(XMLHelper.getClass(filePath, "myHotel")).newInstance();
			showCredit = (ShowCreditRecordService)Class.forName(XMLHelper.getClass(filePath, "showCredit")).newInstance();
			browseHotel = (BrowseHotelService)Class.forName(XMLHelper.getClass(filePath, "browseHotel")).newInstance();
			searchHotel = (SearchHotelService)Class.forName(XMLHelper.getClass(filePath, "searchHotel")).newInstance();
			createOrder = (CreateOrderService)Class.forName(XMLHelper.getClass(filePath, "createOrder")).newInstance();
			evaluateOrder = (EvaluateOrderService)Class.forName(XMLHelper.getClass(filePath, "evaluateOrder")).newInstance();
			applyVip = (ApplyForVipService)Class.forName(XMLHelper.getClass(filePath, "applyVip")).newInstance();
		
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean applyNormalVip(String clientID, String birthday) throws RemoteException {
		
		return applyVip.applyNormalVip(clientID, birthday);
	}

	@Override
	public boolean applyBusinessVip(String clientID, String companyAddress, String hotelID) throws RemoteException {
		
		return applyVip.applyBusinessVip(clientID, companyAddress, hotelID);
	}

	@Override
	public boolean checkNormalVip(String clientID) throws RemoteException{
		
		return applyVip.checkNormalVip(clientID);
	}

	@Override
	public boolean checkBusinessVip(String clientID)throws RemoteException {
		
		return applyVip.checkBusinessVip(clientID);
	}

	@Override
	public boolean addComment(String orderID, String comment, int point_facilities, int point_service,
			int surroundings)throws RemoteException {
		
		return evaluateOrder.addComment(orderID, comment, point_facilities, point_service, surroundings);
	}

	@Override
	public boolean addExtraComment(String orderID, String comment) throws RemoteException{
	
		return evaluateOrder.addExtraComment(orderID, comment);
	}

	@Override
	public String getRoomTypeAndPrice(String hotelID)throws RemoteException {
		
		return createOrder.getRoomTypeAndPrice(hotelID);
	}

	@Override
	public String getAllRoomNumber(String hotelID, String roomType)throws RemoteException {
		
		return createOrder.getAllRoomNumber(hotelID, roomType);
	}

	@Override
	public boolean createOrder(String hotelID, String clientID, String roomType, String roomNumber)throws RemoteException {
		
		return createOrder.createOrder(hotelID, clientID, roomType, roomNumber);
	}

	@Override
	public double getPriceByStrategy(String hotelID, String clientID, String roomNumber) throws RemoteException{
		
		return createOrder.getPriceByStrategy(hotelID, clientID, roomNumber);
	}

	@Override
	public boolean checkCreditPoint(String clientID) throws RemoteException{
		
		return createOrder.checkCreditPoint(clientID);
	}

	@Override
	public String getAllProvinces() throws RemoteException{
		
		return searchHotel.getAllProvinces();
	}

	@Override
	public List<HotelVO> search(SearchVO vo)throws RemoteException {
		
		return searchHotel.search(vo);
	}

	@Override
	public List<HotelVO> getAllHotels(String clientID, String hotelProvince, String hotelCities, String hotelCBD) throws RemoteException{
		
		
		return browseHotel.getAllHotels(clientID, hotelProvince, hotelCities, hotelCBD);
		
	}

	@Override
	public String getProvinces()throws RemoteException {
		
		return browseHotel.getProvinces();
	}

	@Override
	public String getCities(String hotelProvince) throws RemoteException{
		
		return browseHotel.getCities(hotelProvince);
	}

	@Override
	public String getCBDS(String hotelProvince, String hotelCity) throws RemoteException{
		
		return browseHotel.getCBDS(hotelProvince, hotelCity);
	}

	@Override
	public List<OrderVO> getAllOrders(String clientID, String hotelID)throws RemoteException {
		
		return browseHotel.getAllOrders(clientID, hotelID);
	}

	@Override
	public List<CreditVO> ShowAllCredit(String clientID)throws RemoteException {
		
		return showCredit.ShowAllCredit(clientID);
	}

	@Override
	public double getCreditPoint(String clientID) throws RemoteException{
		
		return showCredit.getCreditPoint(clientID);
	}

	@Override
	public List<HotelVO> getExecutedHotels(String clientID) throws RemoteException{
		
		return myHotel.getExecutedHotels(clientID);
	}

	@Override
	public List<HotelVO> getUnexecutedHotels(String clientID)throws RemoteException {
		
		return myHotel.getUnexecutedHotels(clientID);
	}

	@Override
	public List<HotelVO> getWithdrawnHotels(String clientID) throws RemoteException{
		
		return myHotel.getWithdrawnHotels(clientID);
	}

	@Override
	public List<HotelVO> getAbnormalHotels(String clientID) throws RemoteException{
		
		return myHotel.getAbnormalHotels(clientID);
	}

	@Override
	public HotelVO getHotelVO(String clientID, String hotelID)throws RemoteException {
		
		return myHotel.getHotelVO(clientID, hotelID);
	}

	@Override
	public List<OrderVO> getExecutedOrders(String clientID) throws RemoteException{
		
		return myOrder.getExecutedOrders(clientID);
	}

	@Override
	public List<OrderVO> getUnexecutedOrders(String clientID) throws RemoteException{
		
		return myOrder.getUnexecutedOrders(clientID);
	}

	@Override
	public List<OrderVO> getWithdrawnOrders(String clientID) throws RemoteException{
		
		return myOrder.getWithdrawnOrders(clientID);
	}

	@Override
	public List<OrderVO> getAbnormalOrders(String clientID) throws RemoteException{
		
		return myOrder.getAbnormalOrders(clientID);
	}

	@Override
	public OrderVO getOrderVO(String orderID)throws RemoteException{
		
		return myOrder.getOrderVO(orderID);
	}

	@Override
	public boolean withdraw(String clientID, String orderID)throws RemoteException {
		
		return myOrder.withdraw(clientID, orderID);
	}

	@Override
	public ClientVO getClientVO(String clientID)throws RemoteException {
		
		return applyVip.getClientVO(clientID);
	}

	@Override
	public boolean changeClientMessage(ClientVO vo) throws RemoteException {
		
		return manageMessage.changeClientMessage(vo);
	}

	@Override
	public void initAllHotel(String clientID, String hotelProvince, String hotelCities, String hotelCBD)throws RemoteException {
		
		searchHotel.initAllHotel(clientID, hotelProvince, hotelCities, hotelCBD);
	}

	@Override
	public boolean checkRoom(String hotelID, String roomNumber) throws RemoteException {
		
		return createOrder.checkRoom(hotelID, roomNumber);
	}

	@Override
	public boolean uploadPicture(byte[] picture,String clientID) throws RemoteException {
		
		
		return manageMessage.uploadPicture(picture, clientID);
	}

	@Override
	public byte[] getHotelPicture(String hotelID) throws RemoteException {
		
		return searchHotel.getHotelPicture(hotelID);
	}

	@Override
	public byte[] getClientPicture(String clientID) throws RemoteException {
		
		return manageMessage.getClientPicture(clientID);
	}

	@Override
	public boolean changeClientPicture(byte[] picture, String clientID) throws RemoteException {
		
		return manageMessage.changeClientPicture(picture, clientID);
	}
}
