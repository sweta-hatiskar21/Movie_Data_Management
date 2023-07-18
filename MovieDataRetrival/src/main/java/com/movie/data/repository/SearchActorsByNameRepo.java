package com.movie.data.repository;
  
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.data.DTO.Actors;
 
	@Repository
	public interface SearchActorsByNameRepo  extends JpaRepository<Actors, String> {
	
		
		List<Actors> findByPrimaryNameContainingIgnoreCase(String primaryName);
		// it will return the data on the basis of actor name ignoring the case.
	}
 