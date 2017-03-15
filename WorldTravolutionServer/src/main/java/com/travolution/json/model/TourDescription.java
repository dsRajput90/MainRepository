package com.travolution.json.model;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * This DTO stores the tour description that is to be displayed to the user and description is stored from Admin dashboard
 * 
 * @author Darshana
 *
 */
@Document(collection = "wt_tour_description")
public class TourDescription {
	
	@NotNull
	@JsonProperty("tour_id")
	private Long tourId;
	
	@NotNull
	@JsonProperty("tour_description")
	private String description;
	
	@NotNull
	@JsonProperty("tour_type_description")
	private Integer typeDescription;
	
	@NotNull
	@JsonProperty("created_on")
	private Timestamp createdOn;
	
	@NotNull
	@JsonProperty("updated_on")
	private Timestamp updatedOn;

	public Long getTourId() {
		return tourId;
	}

	@JsonProperty("tour_id")
	public void setTourId(Long tourId) {
		this.tourId = tourId;
	}

	public String getTourDescription() {
		return description;
	}

	@JsonProperty("tour_description")
	public void setTourDescription(String tourDescription) {
		this.description = tourDescription;
	}

	public Integer getTourTypeDescription() {
		return typeDescription;
	}

	@JsonProperty("tour_type_description")
	public void setTourTypeDescription(Integer tourTypeDescription) {
		this.typeDescription = tourTypeDescription;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	@JsonProperty("created_on")
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	@JsonProperty("updated_on")
	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}
}
