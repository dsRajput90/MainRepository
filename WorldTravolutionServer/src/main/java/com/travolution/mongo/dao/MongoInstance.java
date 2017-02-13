package com.travolution.mongo.dao;

import org.apache.log4j.Logger;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.travolution.utils.PropertyFileReader;

public enum MongoInstance {

	INSTANCE;
	private MongoClient mongoClient;
	private final Logger logger = Logger.getLogger(MongoInstance.class);

	private MongoInstance() {
		try {
			if (mongoClient == null) {
				mongoClient = getClient();
			}
		} catch (Exception ex) {
			logger.debug(ex);
		}
	}
	
	public MongoClient getClient() {
		String mongoUrl = PropertyFileReader.getValue("mongodbUrl");
		String[] mongoUrlArr = mongoUrl.split(":");
		return new MongoClient(mongoUrlArr[0], Integer.parseInt(mongoUrlArr[1]));
	}
	public MongoDatabase getDatabase() {
		if (mongoClient !=null){
			return mongoClient.getDatabase(PropertyFileReader.getValue("mongoDatabaseName"));
		} else {
			mongoClient = getClient();
			return mongoClient.getDatabase(PropertyFileReader.getValue("mongoDatabaseName"));
		}
	}
	
	public String getDatabaseName() {
		return PropertyFileReader.getValue("mongoDatabaseName");
	}
}
