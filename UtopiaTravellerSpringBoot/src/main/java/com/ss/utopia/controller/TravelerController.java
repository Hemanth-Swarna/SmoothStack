package com.ss.utopia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ss.utopia.service.BookingTicketService;
import com.ss.utopia.service.CancellingTicketService;

@RestController
@RequestMapping("/traveler")
public class TravelerController {

	@Autowired
	BookingTicketService bts;
	
	@Autowired
	CancellingTicketService cts;

	@PostMapping("/booking")
	public void bookingTicket(@RequestParam String user_id, @RequestParam String ori_airport,
			@RequestParam String des_airport, @RequestParam String seat_name) {
		int id = Integer.parseInt(user_id);
		bts.bookATicket(id, ori_airport, des_airport, seat_name);
	}
	
	@PostMapping("/cancelling")
	public void cancelTicket(@RequestParam String user_id, @RequestParam String booking_id, @RequestParam String seat_id) {
		int u_id = Integer.parseInt(user_id);
		int b_id = Integer.parseInt(booking_id);
		int s_id = Integer.parseInt(seat_id);
		cts.cancelATicket(u_id, b_id, s_id);
	}

}
