package com.movie.data.repository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.movie.data.DTO.ActorAndMovieDetails;
import com.movie.data.DTO.MovieDTO;
import com.movie.data.constant.MoviesQueryConstant;
@Repository
public class MovieDetailsRepo {

	public JdbcTemplate jdbcTemplate = new JdbcTemplate();
	@Autowired
	public void setdatasource(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	 public List<ActorAndMovieDetails> findByPrimaryName(String actorname) throws Exception{
		 System.out.println("findByPrimaryName started");
		 //it will find all data of actor
		 List<ActorAndMovieDetails> movieDetails=new ArrayList<>();
		 String originalquery=MoviesQueryConstant.SQL_TO_SELECT_MOVIES2;
		 try {
		 movieDetails=jdbcTemplate.query(con->{PreparedStatement pStatement=con.prepareStatement(MoviesQueryConstant.SQL_TO_SELECT_MOVIES);
			pStatement.setString(1, actorname);
			return pStatement;
			},new BeanPropertyRowMapper<>(ActorAndMovieDetails.class)); 
			 for (ActorAndMovieDetails actorAndMovieDetails : movieDetails) {
				 //from here it will find the data of movies done by actor
				 String[] noofarguments=actorAndMovieDetails.getKnownForTitles().split(",");
				 StringBuilder query=new StringBuilder(MoviesQueryConstant.SQL_TO_SELECT_MOVIES2);
				 for (int i = 0; i < noofarguments.length; i++) {
					query.append("?");
					if (i<noofarguments.length-1) {
						query.append(",");
					}
				}
				 query.append(")");
				 MoviesQueryConstant.SQL_TO_SELECT_MOVIES2=query.toString();
				 List<MovieDTO> list=jdbcTemplate.query(con->{PreparedStatement pStatement=con.prepareStatement(MoviesQueryConstant.SQL_TO_SELECT_MOVIES2);
					pStatement.setString(1, actorAndMovieDetails.getNconst());
					for (int i = 0; i < noofarguments.length; i++) {
						pStatement.setString(i+2,noofarguments[i]);
					}
					return pStatement;
					},new BeanPropertyRowMapper<>(MovieDTO.class)); 
				 actorAndMovieDetails.setMovies(list);
				 MoviesQueryConstant.SQL_TO_SELECT_MOVIES2=originalquery;
				 System.out.println("findByPrimaryName end");
			}
			 return movieDetails; // we are returning the actors along with list of movies, fetching the data from 3 tables
		 }
		 catch (Exception e) {
			 //throws the exception caught
			 throw new Exception(e.getMessage());	}
		 finally {
			 MoviesQueryConstant.SQL_TO_SELECT_MOVIES2=originalquery;
		}
		}
}
