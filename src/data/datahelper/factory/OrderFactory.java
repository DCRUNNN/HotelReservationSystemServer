package data.datahelper.factory;

import data.datahelper.OrderDataHelper;
import data.datahelper.xmlhelper.XMLHelper;

public class OrderFactory {

	public static OrderDataHelper getOrderDataHelper() {
		
	    OrderDataHelper orderdata = null;
	    String name = XMLHelper.getClass("./xml/dataxml/orderdata.xml","class");//�������ļ�����ȡ����
	    
	    try {
	    	//�÷���ʵ��ʵ����
			orderdata = (OrderDataHelper)Class.forName(name).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	    
		return orderdata;
	}

}
