package com.travolution.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travolution.json.model.Tour;
import com.travolution.json.response.dto.ResponseDTO;
import com.travolution.service.TourService;

/**
 * This is the controller class which is called to insert or retrieve tour details from the underlying backend server.
 * Process the request and send the result back to the client.
 * @author Darshana
 * */
@RestController
@RequestMapping(value="/api/tour")
public class TourController {

	@Autowired
	private TourService tourService;
	
	/**
	 * This method get all the tour related data from the database. Method type is GET and accepts no data additional parameter from
	 * the client
	 * @return ResponseEntity<ResponseDTO> - The DTO has the document which is to be displayed on the client
	 * */
	@RequestMapping(value="/all",method= RequestMethod.GET)
	public ResponseEntity<ResponseDTO> getAllTours() {
		ResponseDTO response = new ResponseDTO();
		response.setData(tourService.getAllRecords());
		return  new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * This method is called to insert tour details in the database. Method accepts POST request and creates a fresh record in the database
	 * @param tourDTO 
	 * @return ResponseEntity - Sends an OK or error response to the calling method
	 * */
	@RequestMapping(value="/ins",method= RequestMethod.POST)
	public ResponseEntity<ResponseDTO> insertRecord(@RequestBody @Valid Tour tourDTO) {
		tourService.insertRecord(tourDTO);
		return  new ResponseEntity<>(HttpStatus.OK);
	}
}
