package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import service.Hotel.MaintainHotelMessage.MaintainHotelMessageService;
import service.Hotel.MaintainHotelMessage.MaintainHotelMessageServiceImpl;
import service.Order.BrowseOrder_hotelWorker.BrowseOrder_hotelWorkerService;
import service.Order.BrowseOrder_hotelWorker.BrowseOrder_hotelWorkerServiceImpl;
import service.Order.ExecuteOrder.ExecuteOrderService;
import service.Order.ExecuteOrder.ExecuteOrderServiceImpl;
import service.Room.ChangeRoomInfo.ChangeRoomInfoService;
import service.Room.ChangeRoomInfo.ChangeRoomInfoServiceImpl;
import service.Room.CheckOutRoom.CheckOutRoomService;
import service.Room.CheckOutRoom.CheckOutRoomServiceImpl;
import service.Room.CreateRoom.CreateRoomInfoService;
import service.Room.CreateRoom.CreateRoomInfoServiceImpl;
import service.Strategy.ManageHotelStrategy.ManageHotelStrategyService;
import service.Strategy.ManageHotelStrategy.ManageHotelStrategyServiceImpl;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;
import vo.StrategyVO;

public class HotelWorkerDataRemoteObject extends UnicastRemoteObject implements MaintainHotelMessageService,
           CreateRoomInfoService,ManageHotelStrategyService,ExecuteOrderService,CheckOutRoomService,BrowseOrder_hotelWorkerService,ChangeRoomInfoService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7508423553737111134L;
	
	private MaintainHotelMessageService maintainHotel;
	private CreateRoomInfoService createRoom;
	private ManageHotelStrategyService hotelStrategy;
	private ExecuteOrderService executeOrder;
	private CheckOutRoomService checkOut;
	private BrowseOrder_hotelWorkerService browseOrder;
	private ChangeRoomInfoService changeRoom;
	
	public HotelWorkerDataRemoteObject() throws RemoteException {
		
		super();
		maintainHotel = new MaintainHotelMessageServiceImpl();
		createRoom = new CreateRoomInfoServiceImpl();
		hotelStrategy = new ManageHotelStrategyServiceImpl();
		executeOrder = new ExecuteOrderServiceImpl();
		checkOut = new CheckOutRoomServiceImpl();
		browseOrder = new BrowseOrder_hotelWorkerServiceImpl();
		changeRoom = new ChangeRoomInfoServiceImpl();
	}

	@Override
	public OrderVO getOrder(String orderID) throws RemoteException{
		
		return browseOrder.getOrder(orderID);
	}

	@Override
	public List<OrderVO> getExecutedOrders(String hotelID)throws RemoteException {
		
		return browseOrder.getExecutedOrders(hotelID);
	}

	@Override
	public List<OrderVO> getUnexecutedOrders(String hotelID) throws RemoteException{
		
		return browseOrder.getUnexecutedOrders(hotelID);
	}

	@Override
	public List<OrderVO> getWithdrawnOrders(String hotelID)throws RemoteException {
		
		return browseOrder.getWithdrawnOrders(hotelID);
	}

	@Override
	public List<OrderVO> getAbnormalOrders(String hotelID)throws RemoteException {
		
		return browseOrder.getAbnormalOrders(hotelID);
	}

	@Override
	public String checkOutRoom(String clientID, String hotelID)throws RemoteException {
	
		return checkOut.checkOutRoom(clientID, hotelID);
	}

	@Override
	public List<OrderVO> getUnexecutedOrders(String hotelID, String clientID)throws RemoteException {
	
		return executeOrder.getUnexecutedOrders(hotelID, clientID);
	}

	@Override
	public List<OrderVO> getAbnormalOrders(String hotelID, String clientID) throws RemoteException{
		
		return executeOrder.getAbnormalOrders(hotelID, clientID);
	}

	@Override
	public String getAllRoomType(String orderID) throws RemoteException{
		
		return executeOrder.getAllRoomNumber(orderID);
	}

	@Override
	public String getAllRoomNumber(String orderID) throws RemoteException{
		
		return executeOrder.getAllRoomNumber(orderID);
	}

	@Override
	public String getDelayRoomNumber(String orderID)throws RemoteException {
		
		return executeOrder.getDelayRoomNumber(orderID);
	}

	@Override
	public void setRoomPeople(String roomNumber, int peopleNumebr) throws RemoteException{
		
		executeOrder.setRoomPeople(roomNumber, peopleNumebr);
	}

	@Override
	public void setRoomChild(String roomNumber, boolean hasChild)throws RemoteException {
		
		executeOrder.setRoomChild(roomNumber, hasChild);
	}

	@Override
	public boolean executeOrder() throws RemoteException{
		
		return executeOrder.executeOrder();
	}

	@Override
	public List<StrategyVO> getAllHotelStrategy(String hotelID) throws RemoteException{
		
		return hotelStrategy.getAllHotelStrategy(hotelID);
	}

	@Override
	public boolean addHotelStrategy(StrategyVO vo) throws RemoteException{
		
		return hotelStrategy.addHotelStrategy(vo);
	}

	@Override
	public boolean changeHotelStrategy(StrategyVO vo) throws RemoteException{
		
		return hotelStrategy.changeHotelStrategy(vo);
	}

	@Override
	public boolean deleteHotelStrategy(String strategyID)throws RemoteException {
		
		return hotelStrategy.deleteHotelStrategy(strategyID);
	}

	@Override
	public boolean CreateRoom(RoomVO roomVO)throws RemoteException {
		
		return createRoom.CreateRoom(roomVO);
	}

	@Override
	public String getAllRoomTypeAndPrice(String hotelID) throws RemoteException{
		
		return createRoom.getAllRoomTypeAndPrice(hotelID);
	}

	@Override
	public boolean changeHotelInfo(String hotelID, String hotelProvince, String hotelCity, String hotelCBD,
			String hotelAddress, String hotelName, String introduction, String facilities, int star,
			String roomTypeAndPrices) throws RemoteException{
		
		return maintainHotel.changeHotelInfo(hotelID, hotelProvince, hotelCity, hotelCBD, hotelAddress, hotelName, introduction, facilities, star, roomTypeAndPrices);
	}

	@Override
	public boolean changeHotelInfo(String hotelID, HotelVO vo) throws RemoteException{
		
		return maintainHotel.changeHotelInfo(hotelID, vo);
	}

	@Override
	public HotelVO getHotelVO(String hotelID) throws RemoteException{
		
		return maintainHotel.getHotelVO(hotelID);
	}

	@Override
	public boolean addCompany(String hotelID, String companyAddress) throws RemoteException{
		
		return maintainHotel.addCompany(hotelID, companyAddress);
	}

	@Override
	public boolean deleteCompany(String hotelID, String companyAddress)throws RemoteException {
		
		return maintainHotel.deleteCompany(hotelID, companyAddress);
	}

	@Override
	public List<RoomVO> getAllRoomList(String hotelID) throws RemoteException {
	
		return changeRoom.getAllRoomList(hotelID);
	}

	@Override
	public RoomVO getRoomByNum(String hotelID, String roomId) throws RemoteException {
		
		return changeRoom.getRoomByNum(hotelID, roomId);
	}

	@Override
	public List<RoomVO> getRoomByState(String hotelID, String state) throws RemoteException {
		
		return changeRoom.getRoomByState(hotelID, state);
	}

	@Override
	public List<RoomVO> getRoomByType(String hotelID, String type) throws RemoteException {
		
		return changeRoom.getRoomByType(hotelID, type);
	}

	@Override
	public boolean changeRoomPrice(String type, double price, String hotelId) throws RemoteException {
		
		return changeRoom.changeRoomPrice(type, price, hotelId);
	}

	@Override
	public boolean changeRoomState(String hotelId, String roomId, String state) throws RemoteException {
		
		return changeRoom.changeRoomState(hotelId, roomId, state);
	}

	@Override
	public boolean deleteRoom(String hotelId, String roomId) throws RemoteException {
		
		return changeRoom.deleteRoom(hotelId, roomId);
	}

	@Override
	public List<String> getRoomType(String hotelId) throws RemoteException {
		
		return changeRoom.getRoomType(hotelId);
	}

	@Override
	public List<String> getRoomState(String hotelId) throws RemoteException {
		
		return changeRoom.getRoomState(hotelId);
	}
}
