package com.hsbcpb.omgt.domain;

import org.joda.time.DateTime;


public class Spool {

	// ********************************************************* Fields
	private SpoolName spoolName;
	private SpoolIncrement increment;
	private DateTime creationTime;

	// ********************************************************* Constructor

	// ********************************************************* Getters
	
	public SpoolName getSpoolName() {
		return spoolName;
	}
	
	public DateTime getCreationTime() {
		return creationTime;
	}
}
