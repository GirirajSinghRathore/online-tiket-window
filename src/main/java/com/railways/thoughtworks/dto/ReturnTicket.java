package com.railways.thoughtworks.dto;

public class ReturnTicket extends BaseTicket{
	private String ticket;
	private double amount;
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
