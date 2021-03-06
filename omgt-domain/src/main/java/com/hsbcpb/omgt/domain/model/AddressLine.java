package com.hsbcpb.omgt.domain.model;

import com.hsbcpb.omgt.core.BaseValueObject;

/**
 * Line of an {@link Address}
 *
 */
public class AddressLine extends BaseValueObject {

	// ********************************************************* Fields
	private String line;
	
	// ********************************************************* Constructor
	public AddressLine(String line) {
		super();
		this.line = line;
	}

	// ********************************************************* Getters
	public String getLine() {
		return line;
	}
	
}
