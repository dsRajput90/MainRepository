package com.flapper.service;

import java.util.List;

import org.bson.Document;

import com.flapper.mongo.dao.posts.PostDAO;

public class PostService {
	public List<Document> getAllRecords() {
		return new PostDAO().findRecords("posts");
	}
}
