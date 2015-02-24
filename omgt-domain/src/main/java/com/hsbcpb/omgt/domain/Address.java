package com.hsbcpb.omgt.domain;

import com.hsbcpb.omgt.commons.BaseValueObject;
import com.hsbcpb.omgt.commons.annotations.ValueObject;

/** 
 * Mailing address
 *
 */
@ValueObject
public class Address extends BaseValueObject {

	// ********************************************************* Fields
	private String lines;

	// ********************************************************* Constructor
	
	public Address(String lines) {
		super();
		this.lines = lines;
	}

	// ********************************************************* Business Methods

	// ********************************************************* Technical Methods

	// ********************************************************* Getters
	public String getLines() {
		return lines;
	}
}
