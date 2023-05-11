package com.sonata.Modal;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue
	private long orderId;
	private String orderStatus;
	private java.sql.Date orderDate;
	private String ticketCategory;
	private long ticketPrice;
	private long ticketQuantity;
	private long userId;
	private long promoCodeDiscount;
	private long eventId;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "eventId", referencedColumnName = "eventId")
//	private Event event;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "userId", referencedColumnName = "userId")
//	private User user;

	
	public Orders() {}
	
	public Orders(long orderId, String orderStatus, Date orderDate, String ticketCategory, long ticketPrice,
			long ticketQuantity, long userId, long promoCodeId, long eventId) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.ticketCategory = ticketCategory;
		this.ticketPrice = ticketPrice;
		this.ticketQuantity = ticketQuantity;
		this.userId = userId;
		this.promoCodeDiscount = promoCodeId;
		this.eventId = eventId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public java.sql.Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(java.sql.Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getTicketCategory() {
		return ticketCategory;
	}

	public void setTicketCategory(String ticketCategory) {
		this.ticketCategory = ticketCategory;
	}

	public long getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(long ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public long getTicketQuantity() {
		return ticketQuantity;
	}

	public void setTicketQuantity(long ticketQuantity) {
		this.ticketQuantity = ticketQuantity;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getPromoCodeDiscount() {
		return promoCodeDiscount;
	}

	public void setPromoCodeDiscount(long promoCodeId) {
		this.promoCodeDiscount = promoCodeId;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate
				+ ", ticketCategory=" + ticketCategory + ", ticketPrice=" + ticketPrice + ", ticketQuantity="
				+ ticketQuantity + ", userId=" + userId + ", promoCodeId=" + promoCodeDiscount + ", eventId=" + eventId + "]";
	}
	
}
