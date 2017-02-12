package com.travolution.mongo.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class MongoImpl {
	private Logger logger = Logger.getLogger(MongoImpl.class);
	
	private MongoDatabase mongoDB;
	
	public List<Document> findRecords(String collectionName) {
		try{
			mongoDB = MongoInstance.INSTANCE.getDatabase();
			MongoCollection<Document> mongoCollection = mongoDB.getCollection(collectionName);
			return mongoCollection.find().into(new ArrayList<Document>());
		}catch(Exception e){
			logger.error("Exception occurred while fetching data :: {} " , e);
			return Collections.EMPTY_LIST;
		}
	}
	
	
}
