package com.sonata.Modal;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Event {
	
	@Id
	@GeneratedValue
	private long eventId;
	private String eventCategory;
	private String eventName;
	private String eventDescription;
	private java.sql.Date eventDate;
	private long eventPrice;
	private String eventLocation;
	private String eventStatus;
	
	public Event() { }
	
	public Event(long eventId, String eventCategory, String eventName, String eventDescription, Date eventDate,
			String eventLocation, String eventStatus, long eventPrice) {
		super();
		this.eventId = eventId;
		this.eventCategory = eventCategory;
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.eventDate = eventDate;
		this.eventLocation = eventLocation;
		this.eventStatus = eventStatus;
		this.eventPrice = eventPrice;
	}
	
	public long getEventId() {
		return eventId;
	}
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}
	public String getEventCategory() {
		return eventCategory;
	}
	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public java.sql.Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(java.sql.Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventLocation() {
		return eventLocation;
	}
	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}
	public String getEventStatus() {
		return eventStatus;
	}
	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}
	public long getEventPrice() {
		return eventPrice;
	}
	public void setEventPrice(long eventPrice) {
		this.eventPrice = eventPrice;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventCategory=" + eventCategory + ", eventName=" + eventName
				+ ", eventDescription=" + eventDescription + ", eventDate=" + eventDate + ", eventPrice=" + eventPrice
				+ ", eventLocation=" + eventLocation + ", eventStatus=" + eventStatus + "]";
	}
	
}
