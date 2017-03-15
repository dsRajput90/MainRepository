package com.travolution.mongo.dao.posts;

import java.util.List;

import org.bson.Document;

import com.travolution.mongo.dao.MongoImpl;

public class PostDAO extends MongoImpl{
	
	public List<Document> getAllRecords() throws Exception{
		return super.findRecords("posts");
	}
}
