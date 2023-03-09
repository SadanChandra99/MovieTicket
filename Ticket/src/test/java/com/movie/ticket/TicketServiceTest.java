package com.movie.ticket;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.movie.ticket.entity.Ticket;
import com.movie.ticket.repository.TicketRepository;
import com.movie.ticket.serviceimplementation.TicketServiceImplementation;

@SpringBootTest
public class TicketServiceTest {
	
	@Autowired
	private TicketServiceImplementation ticketServiceImplementation;
	@Autowired
	private TicketRepository ticketRepository;
	
	@Test
	void addTicketTest() {
		Ticket ticket =  new Ticket(3, 370.0, 4,"KGF");
		ticketRepository.save(ticket);
		Ticket ticket2 = ticketRepository.findById(3).get();
		assertEquals("KGF", ticket2.getMovieName());
		
	
		
	}
	
	@Test
	void getTicketById() {
		List<Ticket> tickets = new ArrayList<>();
		tickets.add(new Ticket(4,340.0,5,"KGF"));
		tickets.add(new Ticket(5,239.0, 6,"DON"));
		ticketRepository.saveAll(tickets);
		
		List<Ticket> alltickets = ticketServiceImplementation.getAllTickets();
		assertEquals("KGF", alltickets.get(3).getMovieName());
		assertEquals(5, alltickets.get(3).getSeatsBooked());
		assertEquals(340.0, alltickets.get(3).getTicketPrice());
	
	}
	
	@Test
	void getAllTickets() {
		List<Ticket> tickets = new ArrayList<>();
		tickets.add(new Ticket(6,300.0,5,"KGF-2"));
		tickets.add(new Ticket(7,259.0, 6,"DON-2"));
		ticketRepository.saveAll(tickets);
		List<Ticket> alltickets = ticketRepository.findAll();
		
		assertEquals(7, alltickets.size());
		
	}

}
