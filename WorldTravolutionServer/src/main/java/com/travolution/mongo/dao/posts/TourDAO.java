package com.travolution.mongo.dao.posts;

import java.util.List;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Repository;

import com.travolution.exception.SequenceException;
import com.travolution.json.model.Tour;
import com.travolution.json.model.constants.ModelConstants;
import com.travolution.json.model.service.SequenceDao;
import com.travolution.mongo.dao.MongoImpl;

/**
 * This class is the data access class which performs database operation on tour table 
 * in the database
 * @author Darshana
 * */
@Repository
public class TourDAO extends MongoImpl{
	
	@Field("tourDaoLogger")
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SequenceDao sequenceDao;
	/**
	 * This method returns the list of documents for the specified table
	 * */
	public List<Document> getAllRecords(){
		return super.findRecords(ModelConstants.TOUR.getValue());
	}
	
	/**
	 * Insert record into database 
	 * @param tourDTO
	 * */
	public void insertRecord(Tour tour){
		
		if(tour != null){
			try {
				tour.setId(sequenceDao.getNextSequenceId(ModelConstants.TOUR.getValue()));
			} catch (SequenceException e) {
				logger.error("SequenceException occurred :: {}",e);
				return;
			}
			super.insertData(ModelConstants.TOUR.getValue(), tour.toDocument());
		}
	}
}
