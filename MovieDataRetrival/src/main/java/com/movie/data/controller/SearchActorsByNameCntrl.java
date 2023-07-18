package com.movie.data.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.movie.data.DTO.ActorAndMovieDetails;
import com.movie.data.DTO.Actors;
import com.movie.data.constant.MoviesConstant;
import com.movie.data.constant.RequestApi;
import com.movie.data.service.DataReadSvc;
import com.movie.data.service.SearchActorsByNameSvc;

@RestController
public class SearchActorsByNameCntrl {

	@Autowired SearchActorsByNameSvc searchActorsByNameSvc;
	//endpoint created for searching actors and its related data by actor's name
	@PostMapping(value = "/getActorsByName")
	public ResponseEntity<Object> getActorsByName(@RequestBody RequestApi requestApi) throws IOException {
		System.out.println("getActorsByName started");
		System.out.println("we will search actor:"+requestApi.getActorname());
		List<Actors> actors =new ArrayList<>();
		try {
			if (requestApi.getActorname().isEmpty()) { //checks if actorsname coming is empty
				return ResponseEntity.badRequest().body(MoviesConstant.DATA_NOT_FOUND);
			}
			actors= searchActorsByNameSvc.getActorsByName(requestApi.getActorname());
		if (actors.size()==0) {     //checks if data after retriving from database is empty
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MoviesConstant.EMPTY_SET);
		}
		} catch (Exception e) {
			e.printStackTrace(); //if we get any exception the the given error message is returned
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(MoviesConstant.ERROR_MSG);
		}
		System.out.println("getActorsByName completed");
		return ResponseEntity.ok(actors); //if everything is working fine then the list of data is returned to the user
		
	}

	//endpoint created for searching actors and its related data and all movies list by actor's name
	@PostMapping(value = "/getActorsDetail")
	public ResponseEntity<Object> getActorsDetail(@RequestBody RequestApi requestApi) throws IOException {
		System.out.println("getActorsDetail started");
		System.out.println("we will search actor:"+requestApi.getActorname());
		List<ActorAndMovieDetails> actors =new ArrayList<>();
		try {
			if (requestApi.getActorname().isEmpty()) {   //checks if actorsname coming is empty
				return ResponseEntity.badRequest().body(MoviesConstant.DATA_NOT_FOUND);
			}
			actors= searchActorsByNameSvc.getActorsDetail(requestApi.getActorname());
		if (actors==null || actors.size()==0) { //checks if data after retriving from database is empty
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MoviesConstant.EMPTY_SET);
		}
		} catch (Exception e) {
			e.printStackTrace();//if we get any exception the the given error message is returned
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(MoviesConstant.ERROR_MSG);
		}
		System.out.println("getActorsDetail completed");
		return ResponseEntity.ok(actors);//if everything is working fine then the list of data is returned to the user
		
	}
}
