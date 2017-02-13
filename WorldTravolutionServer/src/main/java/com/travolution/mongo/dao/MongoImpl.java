package com.travolution.mongo.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
/**
 * This class is the data access class which performs database operation on all the Collections specified.
 * Generic class for connectivity with MongoDB
 * @author Darshana
 * */
@Repository
public class MongoImpl {
	private Logger logger = Logger.getLogger(MongoImpl.class);
	
	private MongoDatabase mongoDB;
	
	/**
	 * Method finds all the records in the database for the collection specified
	 * @param collectionName
	 * @return List<Document>
	 * */
	public List<Document> findRecords(String collectionName) {
		try{
			mongoDB = MongoInstance.INSTANCE.getDatabase();
			MongoCollection<Document> mongoCollection = mongoDB.getCollection(collectionName);
			return mongoCollection.find().into(new ArrayList<Document>());
		}catch(Exception e){
			logger.error("Exception occurred while fetching data :: {} " , e);
			return Collections.emptyList();
		}
	}
	/**
	 * Insert a new record in a particular collection.
	 * 
	 * @param collectionName
	 * @param record
	 */
	public void insertData(String collectionName, Bson record) {
		if (mongoDB == null) {
			try {
				mongoDB = MongoInstance.INSTANCE.getDatabase();
			} catch (Exception e) {
				logger.error(e);

			}
		} else {
			MongoCollection<Document> collection = mongoDB
					.getCollection(collectionName);
			Document recordDocument = (Document) record;
			collection.insertOne(recordDocument);
		}

	}
	
	/**
	 * Finds and update the record in the database
	 * @param key - collection name
	 * @param classValue - class type
	 * @return T - returns object of stated type
	 * */
	public <T> T findAndModify(String key, Class<T> classValue){
		MongoOperations mongoOperation = null;
		//get sequence id
		  Query query = new Query(Criteria.where("_id").is(key));

		  //increase sequence id by 1
		  Update update = new Update();
		  update.inc("seq", 1);

		  //return new increased id
		  FindAndModifyOptions options = new FindAndModifyOptions();
		  options.returnNew(true);
		  mongoOperation = new MongoTemplate(MongoInstance.INSTANCE.getClient(), MongoInstance.INSTANCE.getDatabaseName());
		  return (T)mongoOperation.findAndModify(query, update, options, classValue);
	}
}
