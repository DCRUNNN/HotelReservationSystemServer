package data.datahelper.factory;

import data.datahelper.HotelDataHelper;
import data.datahelper.xmlhelper.XMLHelper;

public class HotelFactory {

	public static HotelDataHelper getHotelDataHelper() {
		
	    HotelDataHelper hoteldata = null;
	    String name = XMLHelper.getClass("./xml/dataxml/hoteldata.xml","class");//用配置文件来读取类名
	    
	    try {
	    	//用反射实现实例化
			hoteldata = (HotelDataHelper)Class.forName(name).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	    
		return hoteldata;
	}

}
