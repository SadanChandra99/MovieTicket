package com.movie.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {
	
	
	
	@Id
	private String movieName;
	private Double moviePrice; //use wrapper class Double
	private String movieDate;  // use Date
	private String movieStartTime; //Use DateAndTime
	private String movieEndTime;
	public Movie(String movieName, Double moviePrice, String movieDate, String movieStartTime,
			String movieEndTime) {
		super();
		this.movieName = movieName;
		
		this.moviePrice = moviePrice;
		this.movieDate = movieDate;
		this.movieStartTime = movieStartTime;
		this.movieEndTime = movieEndTime;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Double getMoviePrice() {
		return moviePrice;
	}
	public void setMoviePrice(Double moviePrice) {
		this.moviePrice = moviePrice;
	}
	public String getMovieDate() {
		return movieDate;
	}
	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}
	public String getMovieStartTime() {
		return movieStartTime;
	}
	public void setMovieStartTime(String movieStartTime) {
		this.movieStartTime = movieStartTime;
	}
	public String getMovieEndTime() {
		return movieEndTime;
	}
	public void setMovieEndTime(String movieEndTime) {
		this.movieEndTime = movieEndTime;
	}
	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + ", moviePrice=" + moviePrice + ", movieDate="
				+ movieDate + ", movieStartTime=" + movieStartTime + ", movieEndTime=" + movieEndTime + "]";
	}
	
	
	

	
	
	
	
	
	
	

}
