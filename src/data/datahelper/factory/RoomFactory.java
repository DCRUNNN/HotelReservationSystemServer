package data.datahelper.factory;

import data.datahelper.RoomDataHelper;
import data.datahelper.xmlhelper.XMLHelper;

public class RoomFactory {

	public static RoomDataHelper getRoomDataHelper() {
		
	    RoomDataHelper roomdata = null;
	    String name = XMLHelper.getClass("./xml/dataxml/roomdata.xml","class");//用配置文件来读取类名
	    
	    try {
	    	//用反射实现实例化
			roomdata = (RoomDataHelper)Class.forName(name).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	    
		return roomdata;
	}

	
}
