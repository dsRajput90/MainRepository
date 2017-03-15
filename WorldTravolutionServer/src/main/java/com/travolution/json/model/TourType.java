package com.travolution.json.model;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO stores day 0 details about the different types of tours organized
 * Eg : trek only / adventurous or sporting tours , Sightseeing, Shore Excursion Tours, Combining
 * 
 * @author Darshana
 *
 */
@Repository
@Document(collection = "tour_type")
public class TourType {
	@Id
	private Integer id;
	
	@NotNull
	@JsonProperty("type_id")
	private Integer typeId;
	
	@NotNull
	@JsonProperty("type_description")
	private String description;
	
	@NotNull
	@JsonProperty("created_on")
	private Timestamp createdOn;
	
	@NotNull
	@JsonProperty("updated_on")
	private Timestamp updatedOn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

}
