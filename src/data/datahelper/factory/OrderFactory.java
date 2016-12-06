package data.datahelper.factory;

import data.datahelper.OrderDataHelper;
import data.datahelper.xmlhelper.XMLHelper;

public class OrderFactory {

	public static OrderDataHelper getOrderDataHelper() {
		
	    OrderDataHelper orderdata = null;
	    String name = XMLHelper.getClass("./xml/dataxml/orderdata.xml","class");//用配置文件来读取类名
	    
	    try {
	    	//用反射实现实例化
			orderdata = (OrderDataHelper)Class.forName(name).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	    
		return orderdata;
	}

}
