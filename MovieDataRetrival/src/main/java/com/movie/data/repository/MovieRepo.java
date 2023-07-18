
  package com.movie.data.repository;
  
  import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import
  org.springframework.stereotype.Repository;

import com.movie.data.DTO.ActorAndMovieDetails;
import com.movie.data.DTO.Actors;
  
	@Repository
	public interface MovieRepo  extends JpaRepository<Actors, String> {
  
		@Query(value = "SELECT a.nconst, a.primaryName, a.birthYear, a.deathYear, a.primaryProfession, m.tconst, m.titleType, m.primaryTitle, m.originalTitle, m.isAdult, m.startYear, m.endYear, m.runtimeMinutes, m.genres, t.category, t.job, t.characters FROM Actors as a inner join Movies as m on find_in_set(m.tconst,a.knownForTitles)>0 inner join title_mapping as t on t.nconst=a.nconst where a.primaryName=:name",nativeQuery = true)
		List<ActorAndMovieDetails> findByPrimaryName(@Param("name")String primaryName);
  }
 