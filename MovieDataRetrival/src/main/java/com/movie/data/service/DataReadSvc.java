package com.movie.data.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.movie.data.DTO.Actors;
import com.movie.data.DTO.Movies;
import com.movie.data.DTO.title_mapping;
import com.movie.data.repository.MovieRepo;
@Service
public class DataReadSvc {
	
	@Autowired MovieRepo movieRepo;
	
	public void readDataAndSaveActors(MultipartFile file) throws Exception {
		System.out.println("readDataAndSaveActors started");
		BufferedReader reader=new BufferedReader(new InputStreamReader(file.getInputStream()));
		String line=reader.readLine();
		while ((line=reader.readLine())!=null) {
			String [] columndata=line.split("\t");
			Actors actors=new Actors();
			actors.setNconst((columndata[0]).equals("\\N")?null:(columndata[0]));
			actors.setPrimaryName((columndata[1]).equals("\\N")?null:(columndata[1]));
			actors.setBirthYear((columndata[2]).equals("\\N")?null:Integer.valueOf(columndata[2]));
			actors.setDeathYear((columndata[3]).equals("\\N")?null:Integer.valueOf(columndata[3]));
			actors.setPrimaryProfession((columndata[4]).equals("\\N")?null:(columndata[4]));
			actors.setKnownForTitles((columndata[5]).equals("\\N")?null:(columndata[5]));
			movieRepo.save(actors);
			System.out.println(line);
		}
		reader.close();
		System.out.println("readDataAndSaveActors end");
	}
	public void readDataAndSaveMovies(MultipartFile file) throws Exception {
		System.out.println("readDataAndSaveMovies started");
		BufferedReader reader=new BufferedReader(new InputStreamReader(file.getInputStream()));
		String line=reader.readLine();
		while ((line=reader.readLine())!=null) {
			String [] columndata=line.split("\t");
			Movies movies=new Movies();
			movies.setTconst((columndata[0]).equals("\\N")?null:(columndata[0]));
			movies.setTitleType((columndata[1]).equals("\\N")?null:(columndata[1]));
            movies.setPrimaryTitle((columndata[2]).equals("\\N")?null:(columndata[2]));
			movies.setOriginalTitle((columndata[3]).equals("\\N")?null:(columndata[3]));
			movies.setIsAdult((columndata[4]).equals("\\N")?null:Integer.valueOf(columndata[4]));
			movies.setStartYear((columndata[5]).equals("\\N")?null:Integer.valueOf(columndata[5]));
			movies.setEndYear((columndata[6]).equals("\\N")?null:Integer.valueOf(columndata[6]));
			movies.setRuntimeMinutes((columndata[7]).equals("\\N")?null:Integer.valueOf(columndata[7]));
			movies.setGenres((columndata[8]).equals("\\N")?null:(columndata[8]));

			//movieRepo.save(movies);
			System.out.println(line);
		}
		reader.close();
		System.out.println("readDataAndSaveActors end");
	}
	
	public void readDataAndSaveTitleMapping(MultipartFile file) throws Exception {
		System.out.println("readDataAndSaveMovies started");
		BufferedReader reader=new BufferedReader(new InputStreamReader(file.getInputStream()));
		String line=reader.readLine();
		while ((line=reader.readLine())!=null) {
			String [] columndata=line.split("\t");
			title_mapping movies=new title_mapping();
			movies.setTconst((columndata[0]).equals("\\N")?null:(columndata[0]));
			movies.setOrdering((columndata[1]).equals("\\N")?null:Integer.valueOf(columndata[1]));
            movies.setNconst((columndata[2]).equals("\\N")?null:(columndata[2]));
			movies.setCategory((columndata[3]).equals("\\N")?null:(columndata[3]));
			movies.setJob((columndata[4]).equals("\\N")?null:(columndata[4]));
			movies.setCharacters((columndata[5]).equals("\\N")?null:(columndata[5]));
			

			//movieRepo.save(movies);
			System.out.println(line);
		}
		reader.close();
		System.out.println("readDataAndSaveActors end");
	}
}
