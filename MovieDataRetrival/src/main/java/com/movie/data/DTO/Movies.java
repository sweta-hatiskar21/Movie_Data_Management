package com.movie.data.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "movie_data")
@Data
public class Movies {
	@Id
	public String tconst;
	public String titleType;
	public String primaryTitle;
	public String originalTitle;
	public Integer isAdult;
	public Integer startYear;
	public Integer endYear;
	public Integer runtimeMinutes;
	public String genres;

}
