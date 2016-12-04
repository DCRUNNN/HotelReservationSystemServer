package uidriver.credit;

import java.rmi.RemoteException;
import java.util.List;

import service.Credit.ShowCreditRecord.ShowCreditRecordService;
import service.Credit.ShowCreditRecord.ShowCreditRecordServiceImpl;
import vo.CreditVO;

public class ShowCreditRecordDriver {

	public static void main(String args[]) throws RemoteException{
		
		ShowCreditRecordService service = new ShowCreditRecordServiceImpl();
		String clientID ="0000001";
		List<CreditVO> volist = service.ShowAllCredit(clientID);
		System.out.println(service.getCreditPoint(clientID));//输出；客户的剩余信用点
		
		for(CreditVO vo:volist){
			show(vo);
		}
	}

	private static void show(CreditVO vo) {
		
		System.out.println("订单编号："+vo.getOrderID());
		System.out.println("客户编号:"+vo.getClientID());
		System.out.println("订单变化原因："+vo.getCause());
		System.out.println("改变的时间:"+vo.getTime());
		System.out.println("信用值变化记录："+vo.getChange());
		System.out.println("------------");
	}
	
}
