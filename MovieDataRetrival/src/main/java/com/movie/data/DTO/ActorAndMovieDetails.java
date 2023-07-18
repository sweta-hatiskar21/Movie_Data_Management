package com.movie.data.DTO;

import java.util.List;

import jakarta.persistence.SqlResultSetMapping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ActorAndMovieDetails {

	public String nconst;
	public String primaryName;
	public Integer birthYear;
	public Integer deathYear;
	public String primaryProfession;
	public String knownForTitles;
	public List<MovieDTO> movies;
	
	
}
