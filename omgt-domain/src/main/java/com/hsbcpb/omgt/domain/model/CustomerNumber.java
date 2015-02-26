package com.hsbcpb.omgt.domain.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.hsbcpb.omgt.core.BaseValueObject;
import com.hsbcpb.omgt.core.annotations.ValueObject;

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
	@NotNull
	@Size(min=1, max=40)
	public String getNumber() {
		return number;
	}
}
