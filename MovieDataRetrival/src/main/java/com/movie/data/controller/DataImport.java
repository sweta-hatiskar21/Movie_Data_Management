package com.movie.data.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.movie.data.service.DataReadSvc;

@RestController
public class DataImport {

	@Autowired DataReadSvc dataReadSvc;
	
	@GetMapping(value = "/getTsvFile")
	public ResponseEntity<String> getTsvFile(@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println("getTsvFile started");
		try {
			if (file.getOriginalFilename().equals("name.basics.small"))
			dataReadSvc.readDataAndSaveActors(file);
			if (file.getOriginalFilename().equals("title.basics.small"))
			dataReadSvc.readDataAndSaveMovies(file);
			if (file.getOriginalFilename().equals("title.principals.small"))
			dataReadSvc.readDataAndSaveTitleMapping(file);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("getTsvFile completed");
		return ResponseEntity.ok("success");
		
	}
}
