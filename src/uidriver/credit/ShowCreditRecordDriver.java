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
		System.out.println(service.getCreditPoint(clientID));//������ͻ���ʣ�����õ�
		
		for(CreditVO vo:volist){
			show(vo);
		}
	}

	private static void show(CreditVO vo) {
		
		System.out.println("������ţ�"+vo.getOrderID());
		System.out.println("�ͻ����:"+vo.getClientID());
		System.out.println("�����仯ԭ��"+vo.getCause());
		System.out.println("�ı��ʱ��:"+vo.getTime());
		System.out.println("����ֵ�仯��¼��"+vo.getChange());
		System.out.println("------------");
	}
	
}
