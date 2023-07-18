package com.movie.data.DTO;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "titles_mapping")
@Data
public class title_mapping {
	@Id
	public String nconst;
	@Column(name="ordering")
	public Integer ordering;
	@Column(name ="tconst")
	public String tconst;
	@Column(name = "category")
	public String category;
	@Column(name = "job")
	public String job;
	@Column(name = "characters")
	public String characters;

	
}
