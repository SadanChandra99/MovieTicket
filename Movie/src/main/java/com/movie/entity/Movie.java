package com.movie.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;




@Entity
@Table(name =  "movie")
public class Movie {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	private Long movieId;
	@Column(name = "movie_Name")
	private String movieName;
	@Column(name = "movie_language")
	private String movieLanguage;
	@Column(name = "movie_duration")
	private String movieDuration;
	@Column(name = "movie_releaseDate")
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
