package com.railways.thoughtworks.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.railways.thoughtworks.dto.BaseTicket;
import com.railways.thoughtworks.dto.ReturnTicket;
import com.railways.thoughtworks.dto.Ticket;

@Service
public class TicketService {

	public BaseTicket getTicket(String from, String to, boolean isReturn) {
		Map<Integer, String> railwayStationsMap = new HashMap<>();
		railwayStationsMap.put(1, "Chennai Beach");
		railwayStationsMap.put(2, "Chennai Fort");
		railwayStationsMap.put(3, "Chennai Park");
		railwayStationsMap.put(4, "Chennai Egmore");
		railwayStationsMap.put(5, "Chetpet");
		railwayStationsMap.put(6, "Nungambakkam");
		railwayStationsMap.put(7, "Kodambakkam");
		railwayStationsMap.put(8, "Mambalam");
		railwayStationsMap.put(9, "Saidapet");
		railwayStationsMap.put(10, "Guindy");
		railwayStationsMap.put(11, "St. Thomas Mount");
		railwayStationsMap.put(12, "Pazhavanthangal");
		railwayStationsMap.put(13, "Meenambakkam");
		railwayStationsMap.put(14, "Trisulam");
		railwayStationsMap.put(15, "Pallavaram");
		railwayStationsMap.put(16, "Chromepet");
		railwayStationsMap.put(17, "Tambaram Sanatorium");
		railwayStationsMap.put(18, "Tambaram");

		Integer fromStationnumber = getStationNumber(from, railwayStationsMap);
		Integer toStationnumber = getStationNumber(to, railwayStationsMap);

		Integer amounInteger = 10;
		Integer gap = 0;
		if (fromStationnumber < toStationnumber) {
			gap = toStationnumber - fromStationnumber;
		} else {
			gap = fromStationnumber - toStationnumber;
		}
		amounInteger = calculate(fromStationnumber, toStationnumber, amounInteger, gap, railwayStationsMap.size());
		if(isReturn) {
		Double double1 = amounInteger * 1.75;
		ReturnTicket returnTicket =	new ReturnTicket();
		returnTicket.setTicket(from+"-TO-"+to);
		returnTicket.setAmount(double1);
			return returnTicket;
		}
		else {Ticket ticket = new Ticket();
		ticket.setDate(new Date());
		ticket.setFrom(from);
		ticket.setTo(to);
		ticket.setStops(gap);
		ticket.setAmmount(amounInteger);
		return ticket;
			
		}
	}

	private Integer calculate(Integer fromStationnumber, Integer toStationnumber, Integer amounInteger, Integer gap,
			Integer stationMapSize) {
		Integer maxAmount = 20;
		if (gap == stationMapSize - 1) {
			amounInteger = 20;// flat amount for first to last station
		} else if (gap > 5) {
			for (int i = 0; i < gap / 5; i++) {
				amounInteger += 5;
			}
		}

		if (amounInteger > maxAmount) {
			amounInteger = maxAmount;
		}

		return amounInteger;
	}

	private Integer getStationNumber(String stationName, Map<Integer, String> railwayStationsMap) {
		return railwayStationsMap.entrySet().stream()
				.filter(station -> station.getValue().equalsIgnoreCase(stationName)).findFirst().get().getKey();
	}

	public ReturnTicket getreturnTicket(String fromStation, String toStation) {

		
		
		return null;
	}
}
