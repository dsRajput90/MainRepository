package com.travolution.utils;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.travolution.json.model.Tour;
import com.travolution.json.model.TourDescription;
import com.travolution.json.model.TourMedia;

public class Test {
	/*
	public static void main(String[] args) {
		
		Tour tour = new Tour();
		tour.setId(1L);
		tour.setTourName("Kasol");
		tour.setTourPrice(new Double(5000.00));
		tour.setTourTotalBooking(5);
		tour.setTourDuration(10);
		tour.setTourBookingDone(0);
		tour.setTourBookingExpiry(new Timestamp(System.currentTimeMillis()));
		tour.setTourType(1);
		tour.setUpdatedOn(new Timestamp(System.currentTimeMillis()));
		tour.setCreatedOn(new Timestamp(System.currentTimeMillis()));
		tour.setTourDate(DateUtils.formatDate(new Date(), "dd-MMM-yyyy"));

		List<TourDescription> lstDesc = new ArrayList<>(2);
		TourDescription tourDescription = new TourDescription();
		tourDescription.setTourId(tour.getId());
		tourDescription.setTourDescription("Trek to Kasol delhi");
		tourDescription.setTourTypeDescription(1);
		tourDescription.setUpdatedOn(new Timestamp(System.currentTimeMillis()));
		tourDescription.setCreatedOn(new Timestamp(System.currentTimeMillis()));

		TourDescription tourDescription1 = new TourDescription();
		tourDescription1.setTourId(tour.getId());
		tourDescription1.setTourDescription("Trek to Kasol delhi 2");
		tourDescription1.setTourTypeDescription(2);
		tourDescription1.setUpdatedOn(new Timestamp(System.currentTimeMillis()));
		tourDescription1.setCreatedOn(new Timestamp(System.currentTimeMillis()));
		lstDesc.add(tourDescription);
		lstDesc.add(tourDescription1);
		tour.setLstTourDescription(lstDesc);
		
		TourMedia tourMedia = new TourMedia();
		tourMedia.setTourId(tour.getId());
		tourMedia.setMediaName("Yogalife thailand");
		tourMedia.setMediaPath("images/YogaLife-Thumbnail.png");
		tourMedia.setMediaPriority(1);
		tourMedia.setMediaType("I");
		tourMedia.setMediaDescription("On yogalife in thailand");
		tourMedia.setUpdatedOn(new Timestamp(System.currentTimeMillis()));
		tourMedia.setCreatedOn(new Timestamp(System.currentTimeMillis()));
		List<TourMedia> lstMedia = new ArrayList<>(1);
		lstMedia.add(tourMedia);
		tour.setLstTourMedia(lstMedia);
		
		ObjectWriter mapperObj = new ObjectMapper().writer();
		 String jsonStr = null;
        try {
            // get Employee object as a json string
            jsonStr = mapperObj.writeValueAsString(tour);
            System.out.println(jsonStr);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
        ObjectMapper reader = new ObjectMapper();
        try {
            // get Employee object as a json string
            Object obj = reader.readValue(jsonStr,Class.forName("com.travolution.json.request.dto.TourDTO"));
            System.out.println(obj);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
		
}
