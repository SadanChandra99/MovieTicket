package com.movie.ticket.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_id")
	private Integer ticketId;
	@Column(name = "ticket_price")
	@NotEmpty(message = "Ticket Price should not be Null")
	private Double ticketPrice;
	@Column(name = "seats_booked")
	@NotEmpty(message = "Seats Booked are Empty")
	private Integer seatsBooked;
	@Column(name = "movie_name")
	@NotEmpty(message = "Movie Name is Empty")
	private String movieName;
	
	
	public Ticket(Integer ticketId, Double ticketPrice, Integer seatsBooked, String movieName) {
		super();
		this.ticketId = ticketId;
		this.ticketPrice = ticketPrice;
		this.seatsBooked = seatsBooked;
		this.movieName = movieName;
	}
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getTicketId() {
		return ticketId;
	}
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	public Double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public Integer getSeatsBooked() {
		return seatsBooked;
	}
	public void setSeatsBooked(Integer seatsBooked) {
		this.seatsBooked = seatsBooked;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", ticketPrice=" + ticketPrice + ", seatsBooked=" + seatsBooked
				+ ", movieName=" + movieName + "]";
	}
	
	

}
