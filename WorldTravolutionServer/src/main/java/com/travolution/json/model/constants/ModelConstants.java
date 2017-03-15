package com.travolution.json.model.constants;

public enum ModelConstants {

	TOUR("wt_tour");
	
	String constantValue;
	
	ModelConstants(String constantValue){
		this.constantValue = constantValue;
	}
	
	public String getValue(){
		return constantValue;
	}
}
