package service.Hotel.AddHotel;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.HotelVO;
import vo.PersonnelVO;

public interface AddHotelService extends Remote{

	/**
	 * @param HotelPO
	 * 记住调用顺序，一定要先增添一个hotel，才能增加对应的hotelworker
	 * @return 添加成功的话，返回酒店编号，不成功的话，返回""
	 * */
	public String addHotel(HotelVO vo)throws RemoteException;
	
	/**
	 * @param vo
	 * @return 往数据层添加一个持久化数据PersonnelPO,成功的话返回true，否则false
	 * */
	public boolean addHotelWorker(PersonnelVO vo)throws RemoteException;
	
	/**
	 * @param personnelID 工作人员编号
	 * @param password 密码
	 * @return 返回保存密码是否成功
	 * */
	public boolean savePassword(String personnelID,String password)throws RemoteException;
	
	/**
	 * @param vo 酒店信息
	 * @return 根据酒店省份，酒店所在市，酒店所在商圈，酒店详细地址和酒店名称来判断酒店是否已经存在
	 * */
	public boolean isExist(HotelVO vo)throws RemoteException;
}
