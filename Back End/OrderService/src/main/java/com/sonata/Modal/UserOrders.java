package com.sonata.Modal;

import java.util.List;

public class UserOrders {
	private List<Orders> userOrderList;
	private long totalPrice;
	
	public List<Orders> getUserOrderList() {
		return userOrderList;
	}
	public void setUserOrderList(List<Orders> userOrderList) {
		this.userOrderList = userOrderList;
	}
	public long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
}
