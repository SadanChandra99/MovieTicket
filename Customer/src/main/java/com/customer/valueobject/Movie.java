package com.customer.valueobject;

public class Movie {
	
	private Long movieId;
	
	private String movieName;
	
	private String movieLanguage;

	private String movieDuration;

	private String movieReleaseDate;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(Long movieId, String movieName, String movieLanguage, String movieDuration, String movieReleaseDate) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieLanguage = movieLanguage;
		this.movieDuration = movieDuration;
		this.movieReleaseDate = movieReleaseDate;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public String getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(String movieDuration) {
		this.movieDuration = movieDuration;
	}

	public String getMovieReleaseDate() {
		return movieReleaseDate;
	}

	public void setMovieReleaseDate(String movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieLanguage=" + movieLanguage
				+ ", movieDuration=" + movieDuration + ", movieReleaseDate=" + movieReleaseDate + "]";
	}
	
	
	
	
}
