package com.movie.ticket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.movie.ticket.entity.Ticket;
@Service
public interface TicketService {
	
	public Ticket addTicket(Ticket ticket);
	public Ticket getTicketById(Integer ticketId);
	public List<Ticket> getAllTickets();
	public Ticket updateTicket(Ticket ticket, Integer ticketId);
	public String deleteTicket(Integer ticketId);
	

}
