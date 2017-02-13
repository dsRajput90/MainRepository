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
 * This DTO stores promotional information if at all required 
 * 
 * @author Darshana
 *
 */
@Repository
@Document(collection = "wt_tour_promo")
public class TourPromo {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Id
	private Long id;
	
	@NotNull
	@JsonProperty("tour_id")
	private Long tourId;

	@NotNull
	@JsonProperty("tour_discount")
	private Integer discount;
	
	@NotNull
	@JsonProperty("tour_limit")
	private Integer limit;
	
	@NotNull
	@JsonProperty("tour_promo_validity")
	private Timestamp promoValidity;
	
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

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Timestamp getPromoValidity() {
		return promoValidity;
	}

	public void setPromoValidity(Timestamp promoValidity) {
		this.promoValidity = promoValidity;
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

