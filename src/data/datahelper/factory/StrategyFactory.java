package data.datahelper.factory;

import data.datahelper.StrategyDataHelper;
import data.datahelper.xmlhelper.XMLHelper;

public class StrategyFactory {

	public static StrategyDataHelper getStrategyDataHelper() {
		
	    StrategyDataHelper strategydata = null;
	    String name = XMLHelper.getClass("./xml/dataxml/strategydata.xml","class");//�������ļ�����ȡ����
	    
	    try {
	    	//�÷���ʵ��ʵ����
			strategydata = (StrategyDataHelper)Class.forName(name).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	    
		return strategydata;
	}


}
