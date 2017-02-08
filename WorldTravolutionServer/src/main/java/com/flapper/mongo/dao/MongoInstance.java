package com.flapper.mongo.dao;

import org.apache.log4j.Logger;

import com.flapper.utils.PropertyFileReader;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

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
	
	public MongoClient getClient() throws Exception {
		String mongoUrl = PropertyFileReader.getValue("mongodbUrl");
		String[] mongoUrlArr = mongoUrl.split(":");
		return new MongoClient(mongoUrlArr[0], Integer.parseInt(mongoUrlArr[1]));
	}
	public MongoDatabase getDatabase() throws Exception {
		if (mongoClient !=null){
			return mongoClient.getDatabase(PropertyFileReader.getValue("mongoDatabaseName"));
		} else {
			mongoClient = getClient();
			return mongoClient.getDatabase(PropertyFileReader.getValue("mongoDatabaseName"));
		}
	}
}
