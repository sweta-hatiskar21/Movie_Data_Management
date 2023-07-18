package com.movie.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.data.DTO.ActorAndMovieDetails;
import com.movie.data.DTO.Actors;
import com.movie.data.repository.MovieDetailsRepo;
import com.movie.data.repository.SearchActorsByNameRepo;
@Service
public class SearchActorsByNameSvc {
	
	@Autowired SearchActorsByNameRepo searchActorsByNameRepo;
	@Autowired MovieDetailsRepo movieDetailsRepo;
	
	public List<Actors> getActorsByName(String name) {
		System.out.println("getActorsByName start");
		return searchActorsByNameRepo.findByPrimaryNameContainingIgnoreCase(name);
	
	}

	public List<ActorAndMovieDetails> getActorsDetail(String actorname) throws Exception {
		System.out.println("getActorsDetail start");
		return movieDetailsRepo.findByPrimaryName(actorname);
	}
}
