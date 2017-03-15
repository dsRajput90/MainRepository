package com.travolution.json.response.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseDTO implements Serializable{
	
	@JsonProperty(value="request_type")
	private String requestType;
	
	private Object data;
	
	@JsonProperty(value="error")
	private ErrorResponseDTO errorResponseDTO;

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ErrorResponseDTO getErrorResponseDTO() {
		return errorResponseDTO;
	}

	public void setErrorResponseDTO(ErrorResponseDTO errorResponseDTO) {
		this.errorResponseDTO = errorResponseDTO;
	}
	
	
}
