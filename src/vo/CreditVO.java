package vo;

import po.CreditPO;

/**
 * time        ���ñ仯ʱ��
 * clientID    �ͻ����
 * orderID     �������
 * cause       �������ñ仯��ԭ��
 * change      �仯����
 * */
public class CreditVO {

    private String time;
	
	private String clientID;
	
	private String orderID;
	
	private String cause;
	
	private String change;
	
	public CreditVO(CreditPO po){
		this.time = po.getTime();
		this.clientID = po.getClientID();
		this.orderID = po.getOrderID();
		this.cause = po.getCause();
		this.change = po.getChange();
	}
	
	public CreditVO(String time,String clientID,String orderID,String cause,String change){
		this.time = time;
		this.clientID = clientID;
		this.orderID = orderID;
		this.cause = cause;
		this.change = change;
	}

	public String getTime() {
		return time;
	}

	public String getClientID() {
		return clientID;
	}

	public String getOrderID() {
		return orderID;
	}

	public String getCause() {
		return cause;
	}

	public String getChange() {
		return change;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public void setChange(String change) {
		this.change = change;
	}
	
	
}
