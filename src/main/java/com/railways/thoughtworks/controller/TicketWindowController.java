package com.railways.thoughtworks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.railways.thoughtworks.dto.BaseTicket;
import com.railways.thoughtworks.service.TicketService;

@RestController
public class TicketWindowController {

	@Autowired
	TicketService ticektService;

	@GetMapping("/get-ticket")
	public ResponseEntity<BaseTicket> getTicket(@RequestParam(name = "from") String fromStation,
			@RequestParam(name = "to") String toStation, @RequestParam(name = "return", required = false) boolean isReturn) {
		BaseTicket ticket = ticektService.getTicket(fromStation, toStation, isReturn);
		return new ResponseEntity<BaseTicket>(ticket,HttpStatus.OK);
	}
}
