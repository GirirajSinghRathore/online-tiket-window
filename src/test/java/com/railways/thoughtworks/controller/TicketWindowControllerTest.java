package com.railways.thoughtworks.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.railways.thoughtworks.dto.ReturnTicket;
import com.railways.thoughtworks.dto.Ticket;
import com.railways.thoughtworks.service.TicketService;

public class TicketWindowControllerTest {

	MockMvc mockMvc;
	
	@InjectMocks
	private TicketWindowController controller;
	@Mock
	TicketService service;
	ReturnTicket returnTicket;
	Ticket ticket ;
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		 ticket = new Ticket();
		ticket.setDate(new Date());
		ticket.setAmmount(20);
		ticket.setStops(17);
		ticket.setFrom("Tambaram");
		ticket.setTo("Chennai Beach");
		
		returnTicket = new ReturnTicket();
		returnTicket.setAmount(35.0);
		returnTicket.setTicket(ticket.getFrom()+"-TO-"+ticket.getTo());
	}
	
	@Test
	public void getTiket_shouldReturnSuccessful() throws Exception {
		mockMvc.perform(get("/get-ticket").param("from", "Tambaram").param("to", "Chennai Beach")).andExpect(status().is2xxSuccessful());
		
	}
	
	@Test
	public void getTiket_shouldGetTickeSuccessfully() throws Exception {
		when(service.getTicket(Mockito.anyString(), Mockito.anyString(), Mockito.anyBoolean())).thenReturn(ticket);
	MvcResult result =	 mockMvc.perform(get("/get-ticket").param("from", "Tambaram").param("to", "Chennai Beach")).andExpect(status().is2xxSuccessful()).andReturn();
	System.out.println(result.getResponse().getContentAsString());
	}
	
	@Test
	public void getTiket_shouldGetReturnTickeSuccessfully() throws Exception {
		when(service.getTicket(Mockito.anyString(), Mockito.anyString(), Mockito.anyBoolean())).thenReturn(returnTicket);
	MvcResult result =	 mockMvc.perform(get("/get-ticket").param("from", "Tambaram").param("to", "Chennai Beach").param("return", "true")).andExpect(status().is2xxSuccessful()).andReturn();
	System.out.println(result.getResponse().getContentAsString());
	}
}
