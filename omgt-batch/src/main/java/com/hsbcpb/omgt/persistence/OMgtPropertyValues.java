package com.hsbcpb.omgt.persistence;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.hsbcpb.omgt.exceptions.TechnicalException;

public class OMgtPropertyValues {

	// ********************************************************* Static fields & methods
	/** Singleton predicate instance */
	public static OMgtPropertyValues INSTANCE;

	/**
	 * Factory returning the singleton instance.
	 * 
	 * @return the singleton instance
	 */
	public static OMgtPropertyValues getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new OMgtPropertyValues();
			INSTANCE.loadProps();	
		}
		return INSTANCE;
	}
	
	// ********************************************************* Fields
	private Properties prop = new Properties();
	private String propFileName = "omgt.properties";
	
	// ********************************************************* API
	public String getValue(String key) {
		return prop.getProperty(key);
	}

	// ********************************************************* Private methods
	private void loadProps() {
		InputStream inputStream = getClass().getClassLoader()
				.getResourceAsStream(propFileName);
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			throw new TechnicalException("Cannot find and/or read correctly property file " + propFileName);
		}
	}
}
