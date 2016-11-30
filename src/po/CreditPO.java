package po;

/**
 * time        信用变化发生的时间
 * cientID     客户ID
 * orderID     订单ID
 * cause       信用变化发生的原因（订单执行，订单撤销，订单异常，撤销异常订单，充值）
 * change      信用变化情况（+变化幅度，-变化幅度）
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
