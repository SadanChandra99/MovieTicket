package com.movie.ticket.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.ticket.entity.Ticket;
import com.movie.ticket.exception.TicketAlreadyExistsException;
import com.movie.ticket.exception.TicketCannotUpdateException;
import com.movie.ticket.exception.TicketNotFoundException;
import com.movie.ticket.repository.TicketRepository;
import com.movie.ticket.service.TicketService;

@Service
public class TicketServiceImplementation implements TicketService{
	
	@Autowired
	private TicketRepository ticketRepository;
	
	

	@Override
	public Ticket addTicket(Ticket ticket) throws TicketAlreadyExistsException {
		// TODO Auto-generated method stub
		Ticket addTicket = ticketRepository.save(ticket);
		
		return addTicket;
	}

	@Override
	public Ticket getTicketById(Integer ticketId) throws TicketNotFoundException {
		// TODO Auto-generated method stub
		Ticket getTicket = ticketRepository.findById(ticketId).get();
		return getTicket;
	}

	@Override
	public List<Ticket> getAllTickets() throws TicketNotFoundException{
		// TODO Auto-generated method stub
		List<Ticket> allTickets = ticketRepository.findAll();
		return allTickets;
	}

	@Override
	public Ticket updateTicket(Ticket ticket, Integer ticketId)  throws TicketCannotUpdateException{
		// TODO Auto-generated method stub
		Ticket updateticket = ticketRepository.findById(ticketId).get();
		updateticket.setMovieName(ticket.getMovieName());
		updateticket.setSeatsBooked(ticket.getSeatsBooked());
		updateticket.setTicketPrice(ticket.getTicketPrice());
		ticketRepository.save(updateticket);
		
		return updateticket;
	}

	@Override
	public String deleteTicket(Integer ticketId) throws TicketNotFoundException{
		// TODO Auto-generated method stub
		ticketRepository.deleteById(ticketId);
		return "Ticket is Deleted";
	}

	

}
