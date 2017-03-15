package com.travolution.json.model;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travolution.mongo.dao.MongoImpl;

/**
 * Represents the request DTO that is received when a user adds tour details from Admin dashboard 
 * or request to display active tour details to the user
 * 
 * @author Darshana
 *
 */
@Document(collection = "wt_tour")
public class Tour extends MongoImpl{
	@Field("tourLogger")
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Id
    private Long id;
	
	@NotNull
	@JsonProperty("tour_name")
	private String tourName;
	
	@NotNull
	@JsonProperty("tour_date")
	private String tourDate;
	
	@NotNull
	@JsonProperty("tour_type")
	private Integer tourType;
	
	@NotNull
	@JsonProperty("tour_price")
	private Double price;
	
	@NotNull
	@JsonProperty("tour_duration")
	private Integer tourDuration;
	
	@NotNull
	@JsonProperty("tour_total_booking")
	private Integer totalBooking;
	
	@NotNull
	@JsonProperty("tour_booking_done")
	private Integer bookingDone;
	
	@NotNull
	@JsonProperty("tour_booking_expiry")
	private Timestamp bookingExpiry;
	
	@NotNull
	@JsonProperty("tour_description")
	private List<TourDescription> lstTourDescription;
	
	@JsonProperty("tour_media")
	private List<TourMedia> lstTourMedia;
	
	@NotNull
	@JsonProperty("created_on")
	private Timestamp createdOn;
	
	@NotNull
	@JsonProperty("updated_on")
	private Timestamp updatedOn;

	public Integer getTourDuration() {
		return tourDuration;
	}

	@JsonProperty("tour_duration")
	public void setTourDuration(Integer tourDuration) {
		this.tourDuration = tourDuration;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonProperty("tour_name")
	public String getTourName() {
		return tourName;
	}

	@JsonProperty("tour_name")
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public String getTourDate() {
		return tourDate;
	}

	@JsonProperty("tour_date")
	public void setTourDate(String tourDate) {
		this.tourDate = tourDate;
	}

	public Integer getTourType() {
		return tourType;
	}
	
	@JsonProperty("tour_type")
	public void setTourType(Integer tourType) {
		this.tourType = tourType;
	}

	public Double getTourPrice() {
		return price;
	}

	@JsonProperty("tour_price")
	public void setTourPrice(Double tourPrice) {
		this.price = tourPrice;
	}

	public Integer getTourTotalBooking() {
		return totalBooking;
	}
	
	@JsonProperty("tour_total_booking")
	public void setTourTotalBooking(Integer tourTotalBooking) {
		this.totalBooking = tourTotalBooking;
	}

	public Integer getTourBookingDone() {
		return bookingDone;
	}
	
	@JsonProperty("tour_booking_done")
	public void setTourBookingDone(Integer tourBookingDone) {
		this.bookingDone = tourBookingDone;
	}

	public Timestamp getTourBookingExpiry() {
		return bookingExpiry;
	}

	@JsonProperty("tour_booking_expiry")
	public void setTourBookingExpiry(Timestamp tourBookingExpiry) {
		this.bookingExpiry = tourBookingExpiry;
	}

	public List<TourDescription> getLstTourDescription() {
		return lstTourDescription;
	}
	
	@JsonProperty("tour_description")
	public void setLstTourDescription(List<TourDescription> lstTourDescription) {
		this.lstTourDescription = lstTourDescription;
	}

	public List<TourMedia> getLstTourMedia() {
		return lstTourMedia;
	}

	@JsonProperty("tour_media")
	public void setLstTourMedia(List<TourMedia> lstTourMedia) {
		this.lstTourMedia = lstTourMedia;
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
	/**
	 * Converts the dto to mongo document type.
	 * @return
	 */
	public org.bson.Document toDocument(){
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(this);
			return org.bson.Document.parse(json);
		} catch (IOException e) {
			logger.error("Exception occurred :: {}",e);
			return null;
		} 
	}
}

