package vo;

import java.io.Serializable;

/**
 * orderID             �������
 * orderStatus         ����״̬
 * orderCreatedDate    ��������ʱ��
 * orderBeginDate      ������סʱ��
 * */
public class SimpleSearchVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2810443120778557522L;

	private String orderID;
	
	private String orderStatus;
	
	private String orderCreatedDate;
	
	private String orderBeginDate;

	public String getOrderID() {
		return orderID;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public String getOrderCreatedDate() {
		return orderCreatedDate;
	}

	public String getOrderBeginDate() {
		return orderBeginDate;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void setOrderCreatedDate(String orderCreatedDate) {
		this.orderCreatedDate = orderCreatedDate;
	}

	public void setOrderBeginDate(String orderBeginDate) {
		this.orderBeginDate = orderBeginDate;
	}
	
	
}
