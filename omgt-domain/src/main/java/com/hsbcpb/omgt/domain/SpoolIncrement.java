package com.hsbcpb.omgt.domain;

import com.hsbcpb.omgt.commons.BaseValueObject;

public class SpoolIncrement extends BaseValueObject {

	// ********************************************************* Fields
	private Long increment;
	
	// ********************************************************* Constructor
	public SpoolIncrement(Long increment) {
		super();
		this.increment = increment;
	}
	
	// ********************************************************* Getters
	public Long getIncrement() {
		return increment;
	}


}
