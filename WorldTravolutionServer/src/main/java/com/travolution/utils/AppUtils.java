package com.travolution.utils;

import java.util.Collection;

public class AppUtils {

	//Null check
    public static boolean isNull(Object value){
    	
    	if(value instanceof String)
    		return (value == null || ((String) value).isEmpty());
    	else if(value instanceof Collection)
    		return (value == null || ((Collection) value).isEmpty());
    	else
    		return value == null;
    	
    }
    /**
     * Method to check null values in variable arguments 
     * @param values
     * @return boolean
     */
    public static boolean isNull(String... values){
    	for(String value : values){
    		if(value == null || value.isEmpty())
    			return true;
    	}	
    	return false;
    }
    
}
