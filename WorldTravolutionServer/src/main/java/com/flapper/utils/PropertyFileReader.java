package com.flapper.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.WatchService;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertyFileReader {
	private final Logger logger = Logger.getLogger(PropertyFileReader.class);
	//variable which stores property file location
	private final String propertyFileLocation="/opt/dev/FootySpace/FlapperWebProj/flapperProjProperties.properties";
	
	private static Properties properties = null;
	
	private PropertyFileReader(){
		
		loadProperties();
		
	}
	
	// loading properties from property file
	private void loadProperties() {
		
		final File file = new File(propertyFileLocation);
		if (file.isFile()) {

			try (FileInputStream fis = new FileInputStream(file);) {
				final Properties prop = new Properties(properties);
				prop.load(fis);
				properties = new Properties(prop);
			} catch (IOException ex) {
				logger.error("Error while loading properties: {} ", ex);
			}
		}
	}
	
	/**
	 * @param key - property key
	 * @return property value
	 */
	public static String getValue(String key) {
		if (properties == null) {
			new PropertyFileReader();
		}

		return properties.getProperty(key);
	}
}
