package com.travolution.json.model;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Stores transaction information as to who have applied or enquired for the trek with different status as to applied, enquired or 
 * are planning to go for the trek
 * 
 * @author Darshana
 *
 */
@Repository
@Document(collection = "wt_transaction")
public class TourTransaction {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Id
	private Long id;
	
	@NotNull
	@JsonProperty("tour_id")
	private Long tourId;

	@NotNull
	@JsonProperty("customer_id")
	private Long customerId;
	
	//1 - Applied/enquired , 2 - Enrolled
	@NotNull
	@JsonProperty("status")
	private Integer status;
	
	@NotNull
	@JsonProperty("created_on")
	private Timestamp createdOn;
	
	@NotNull
	@JsonProperty("updated_on")
	private Timestamp updatedOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTourId() {
		return tourId;
	}

	public void setTourId(Long tourId) {
		this.tourId = tourId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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
