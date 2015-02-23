package com.hsbcpb.omgt.domain;

import org.joda.time.DateTime;


public class Spool {

	// ********************************************************* Fields
	private SpoolName spoolName;
	
	private SpoolIncrement increment;
	private DateTime creationTime;
	private DispatchCode dispatchCode;
	private RegionCode regionCode;

	// ********************************************************* Constructor

	// ********************************************************* Getters
	
	public SpoolName getSpoolName() {
		return spoolName;
	}
	
	public DateTime getCreationTime() {
		return creationTime;
	}
	
	public DispatchCode getDispatchCode() {
		return dispatchCode;
	}
	
	public SpoolIncrement getIncrement() {
		return increment;
	}
	
	public RegionCode getRegionCode() {
		return regionCode;
	}
}
