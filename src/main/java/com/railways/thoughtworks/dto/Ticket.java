package com.railways.thoughtworks.dto;

import java.util.Date;
/**
 * 
 * @author Ishwar
 *
 */
public class Ticket extends BaseTicket{
	private Date date;
	private String from;
	private String to;
	private Integer stops;
	private Integer ammount;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Integer getStops() {
		return stops;
	}
	public void setStops(Integer stops) {
		this.stops = stops;
	}
	public Integer getAmmount() {
		return ammount;
	}
	public void setAmmount(Integer ammount) {
		this.ammount = ammount;
	}
	
}
