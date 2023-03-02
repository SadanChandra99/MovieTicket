package com.customer.VO;

public class Movie {
	
	private String movieName;
	private double moviePrice;
	private String movieDate;
	private String movieStartTime;
	private String movieEndTime;
	public Movie(String movieName, double moviePrice, String movieDate, String movieStartTime, String movieEndTime) {
		super();
		this.movieName = movieName;
		this.moviePrice = moviePrice;
		this.movieDate = movieDate;
		this.movieStartTime = movieStartTime;
		this.movieEndTime = movieEndTime;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public double getMoviePrice() {
		return moviePrice;
	}
	public void setMoviePrice(double moviePrice) {
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
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + ", moviePrice=" + moviePrice + ", movieDate=" + movieDate
				+ ", movieStartTime=" + movieStartTime + ", movieEndTime=" + movieEndTime + "]";
	}
	
	

}
