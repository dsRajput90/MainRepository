package com.travolution.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travolution.json.response.dto.ResponseDTO;
import com.travolution.service.TourService;

@RestController
@RequestMapping(value="/api/post")
public class PostController {
	
	@RequestMapping(value="/all",method = RequestMethod.GET)
	public ResponseEntity<ResponseDTO> getAllPosts() {
		ResponseDTO response = new ResponseDTO();
		response.setData(new TourService().getAllRecords());
		return  new ResponseEntity<>(response, HttpStatus.OK);
	}
}
