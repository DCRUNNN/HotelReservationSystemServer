package po;

/**
 * time        ���ñ仯������ʱ��
 * cientID     �ͻ�ID
 * orderID     ����ID
 * cause       ���ñ仯������ԭ�򣨶���ִ�У����������������쳣�������쳣��������ֵ��
 * change      ���ñ仯�����+�仯���ȣ�-�仯���ȣ�
 * */
public class CreditPO {

	private String time;
	
	private String clientID;
	
	private String orderID;
	
	private String cause;
	
	private String change;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}
	
	
	
}
