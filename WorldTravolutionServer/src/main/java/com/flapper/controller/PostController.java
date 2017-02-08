package com.flapper.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flapper.json.response.dto.ResponseDTO;
import com.flapper.service.PostService;

@RestController
@RequestMapping(value="/api/post")
public class PostController {
	
	@RequestMapping(value="/all",method = RequestMethod.GET)
	public ResponseEntity<ResponseDTO> getAllPosts() {
		ResponseDTO response = new ResponseDTO();
		response.setData(new PostService().getAllRecords());
		return  new ResponseEntity<>(response, HttpStatus.OK);
	}
}
