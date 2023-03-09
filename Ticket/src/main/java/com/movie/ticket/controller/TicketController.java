package com.movie.ticket.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.ticket.entity.Ticket;
import com.movie.ticket.service.TicketService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@PostMapping(value = "/add")
	public ResponseEntity<Ticket> createTicket(@Valid @RequestBody  Ticket ticket){
		Ticket creaetTicket = ticketService.addTicket(ticket);
		return ResponseEntity.ok(creaetTicket);
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Ticket> getTicketById(@PathVariable("id") Integer ticketId){
		Ticket getTicketbyid = ticketService.getTicketById(ticketId);
		return ResponseEntity.ok(getTicketbyid);
	}
	
	@GetMapping(value = "/getall")
	public ResponseEntity<List<Ticket>> getAllTickets(){
		List<Ticket> allTickets = ticketService.getAllTickets();
		return ResponseEntity.ok(allTickets);
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket,@PathVariable("id") Integer ticketId){
		Ticket updateTicket =  ticketService.updateTicket(ticket, ticketId);
		return ResponseEntity.ok(updateTicket);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteTicketById(@PathVariable("id") Integer ticketId){
		ticketService.deleteTicket(ticketId);
		return ResponseEntity.ok("Ticket is Deleted Successfully");
	}

}
