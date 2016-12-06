package data.datahelper.factory;

import data.datahelper.HotelDataHelper;
import data.datahelper.xmlhelper.XMLHelper;

public class HotelFactory {

	public static HotelDataHelper getHotelDataHelper() {
		
	    HotelDataHelper hoteldata = null;
	    String name = XMLHelper.getClass("./xml/dataxml/hoteldata.xml","class");//�������ļ�����ȡ����
	    
	    try {
	    	//�÷���ʵ��ʵ����
			hoteldata = (HotelDataHelper)Class.forName(name).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	    
		return hoteldata;
	}

}
