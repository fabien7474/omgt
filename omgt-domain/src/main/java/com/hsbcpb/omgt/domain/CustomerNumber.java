package com.hsbcpb.omgt.domain;

import com.hsbcpb.omgt.commons.BaseValueObject;
import com.hsbcpb.omgt.commons.annotations.ValueObject;

@ValueObject
public class CustomerNumber extends BaseValueObject {
	
	// ********************************************************* Fields
	private String number;

	// ********************************************************* Constructor
	public CustomerNumber(String number) {
		super();
		this.number = number;
	}

	// ********************************************************* Business Methods
	
    // ********************************************************* Technical Methods
	
    // ********************************************************* Getters

	/**
	 * 
	 * @return Number of the account
	 */
	public String getNumber() {
		return number;
	}
}
