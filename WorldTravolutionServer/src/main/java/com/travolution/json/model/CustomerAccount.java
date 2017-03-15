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
 * DTO stores customer details. Our customers who plan to enroll for the tour need to provide some
 * basic personal information
 * 
 * @author Darshana
 *
 */
@Repository
@Document(collection = "wt_customer_account")
public class CustomerAccount {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Id
	private Long id;
	
	@NotNull
	@JsonProperty("customer_mobile")
	private Long customerMobile;
	
	@NotNull
	@JsonProperty("customer_email")
	private String email;
	
	@NotNull
	@JsonProperty("customer_firstname")
	private String firstname;
	
	@NotNull
	@JsonProperty("customer_lastname")
	private String lastname;
	
	@NotNull
	@JsonProperty("customer_middlename")
	private String middlename;
	
	@NotNull
	@JsonProperty("customer_doc")
	private String dob;
	
	@NotNull
	@JsonProperty("customer_gender")
	private Character gender;
	
	@NotNull
	@JsonProperty("customer_state")
	private String state;
	
	@NotNull
	@JsonProperty("customer_city")
	private String city;
	
	@NotNull
	@JsonProperty("pincode")
	private String pincode;
	
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

	public Long getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(Long customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
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
