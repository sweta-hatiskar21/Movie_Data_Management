package com.movie.data.DTO;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "actors_name")
@Data
public class Actors {
	@Id
	public String nconst;
	@Column(name="primaryName")
	public String primaryName;
	@Column(name ="birthYear")
	public Integer birthYear;
	@Column(name = "deathYear")
	public Integer deathYear;
	@Column(name = "primaryProfession")
	public String primaryProfession;
	@Column(name = "knownForTitles")
	public String knownForTitles;

	
}
