package com.travolution.service;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travolution.json.model.Tour;
import com.travolution.mongo.dao.posts.TourDAO;
/**
 * Service class for tour which calls the DAO class to get the data from database
 * and performs additional operations on the data to send the request data back to the client
 * @author Darshana
 * */
@Service
public class TourService {
	@Autowired
	private TourDAO tourDAO;
	
	/**
	 * This method returns the list of documents for the specified table
	 * */
	public List<Document> getAllRecords() {
		return tourDAO.getAllRecords();
	}
	
	/**
	 * This method inserts the tour data into the database
	 * @param tour
	 * */
	public void insertRecord(Tour tour) {
		
		if(tour != null){
			tourDAO.insertRecord(tour);
		}
	}
}
