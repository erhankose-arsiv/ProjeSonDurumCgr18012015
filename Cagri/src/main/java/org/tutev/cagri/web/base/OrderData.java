package org.tutev.cagri.web.base;

public class OrderData {
	String sortField;
	OrderType orderType;
	
	public OrderData(String sortField,OrderType order) {
		this.orderType=order;
		this.sortField=sortField;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
	
	

}
