package com.movie.ticket;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.movie.ticket.entity.Ticket;
import com.movie.ticket.repository.TicketRepository;
import com.movie.ticket.serviceimplementation.TicketServiceImplementation;

@ExtendWith(SpringExtension.class)
public class TicketServiceMockito {
	
	@InjectMocks
	private TicketServiceImplementation ticketServiceImplementation;
	@MockBean
	private TicketRepository ticketRepository;
	
	@Test
	void addTicketTest() {
		Ticket ticket = new Ticket();
		ticket.setTicketId(1);
		ticket.setMovieName("The-Call");
		ticket.setSeatsBooked(2);
		ticket.setTicketPrice((double) 300);
//		ticketRepository.save(ticket);
		Mockito.when(ticketRepository.save(ticket)).thenReturn(ticket);
		assertEquals(2, ticket.getSeatsBooked());
	}
	
	@Test
	void getTicketbyid() {
		Ticket ticket = new Ticket();
		ticket.setTicketId(1);
		ticket.setMovieName("The-Call");
		ticket.setSeatsBooked(2);
		ticket.setTicketPrice((double) 300);
		ticketRepository.save(ticket);
		Mockito.when(ticketRepository.findById(1)).thenReturn(Optional.of(ticket));
		Ticket ticket1 = ticketRepository.findById(1).get();
		assertEquals("The-Call", ticket1.getMovieName());
		
	}
	
	@Test
	void getAllTickets() {
		List<Ticket> allTickets = new  ArrayList<Ticket>();
		allTickets.add(new Ticket(1, 300.0, 3, "The-Call"));
		allTickets.add(new Ticket(2, 400.0, 4, "Breaking-Bad"));
		ticketRepository.saveAll(allTickets);
		List<Ticket> allserviceTickets = ticketRepository.findAll();
		
		Mockito.when(ticketRepository.findAll()).thenReturn(allTickets);
		assertEquals(2, allTickets.size());
		
	}

}
