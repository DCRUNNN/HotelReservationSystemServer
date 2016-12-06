package data.datahelper.factory;

import data.datahelper.StrategyDataHelper;
import data.datahelper.xmlhelper.XMLHelper;

public class StrategyFactory {

	public static StrategyDataHelper getStrategyDataHelper() {
		
	    StrategyDataHelper strategydata = null;
	    String name = XMLHelper.getClass("./xml/dataxml/strategydata.xml","class");//用配置文件来读取类名
	    
	    try {
	    	//用反射实现实例化
			strategydata = (StrategyDataHelper)Class.forName(name).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	    
		return strategydata;
	}


}
