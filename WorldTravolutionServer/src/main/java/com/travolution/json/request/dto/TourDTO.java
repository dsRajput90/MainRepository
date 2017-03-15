package com.travolution.json.request.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.travolution.json.model.Tour;
import com.travolution.json.model.TourDescription;
import com.travolution.json.model.TourMedia;
/**
 * Represents request DTO when user enters tour details from admin dashboard
 * 
 * @author Darshana
 *
 */
public class TourDTO {
	
	@NotNull
	private Tour tour;
	
	@NotNull
	private List<TourDescription> tourDescription;
	
	private List<TourMedia> tourMedia;

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	public List<TourDescription> getTourDescription() {
		return tourDescription;
	}

	public void setTourDescription(List<TourDescription> tourDescription) {
		this.tourDescription = tourDescription;
	}

	public List<TourMedia> getTourMedia() {
		return tourMedia;
	}

	public void setTourMedia(List<TourMedia> tourMedia) {
		this.tourMedia = tourMedia;
	}
	
}
