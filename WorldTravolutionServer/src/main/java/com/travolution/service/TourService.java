package com.travolution.service;

import java.util.List;

import org.bson.Document;

import com.travolution.mongo.dao.posts.TourDAO;

public class TourService {
	public List<Document> getAllRecords() {
		return new TourDAO().findRecords("wt_tour");
	}
}
