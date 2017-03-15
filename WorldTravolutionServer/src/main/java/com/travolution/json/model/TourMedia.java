package com.travolution.json.model;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This DTO stores the tour images and video path with tourId as the foreign key which is passed on to the UI
 * for display and also the values are stored from Admin dashboard
 * 
 * @author Darshana
 *
 */
@Repository
@Document(collection = "wt_tour_media")
public class TourMedia {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@NotNull
	@JsonProperty("tour_id")
	private Long tourId;
	
	@NotNull
	@JsonProperty("tour_media_name")
	private String mediaName;
	
	@NotNull
	@JsonProperty("tour_media_description")
	private String mediaDescription;
	
	@NotNull
	@JsonProperty("tour_media_priority")
	private Integer mediaPriority;
	
	@NotNull
	@JsonProperty("tour_media_type")
	private String mediaType;
	
	@NotNull
	@JsonProperty("tour_media_path")
	private String mediaPath;
	
	@NotNull
	@JsonProperty("created_on")
	private Timestamp createdOn;
	
	@NotNull
	@JsonProperty("updated_on")
	private Timestamp updatedOn;

	public Long getTourId() {
		return tourId;
	}

	public void setTourId(Long tourId) {
		this.tourId = tourId;
	}

	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public String getMediaDescription() {
		return mediaDescription;
	}

	public void setMediaDescription(String mediaDescription) {
		this.mediaDescription = mediaDescription;
	}

	public Integer getMediaPriority() {
		return mediaPriority;
	}

	public void setMediaPriority(Integer mediaPriority) {
		this.mediaPriority = mediaPriority;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getMediaPath() {
		return mediaPath;
	}

	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	/**
	 * Converts the dto to mongo document type.
	 * @return
	 */
	public org.bson.Document toDocument(){
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(this);
			return org.bson.Document.parse(json);
		} catch (JsonProcessingException e) {
			logger.error("Exception occurred :: {}",e);
			return null;
		}
	}
}
