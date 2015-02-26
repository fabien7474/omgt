package com.hsbcpb.omgt.domain.model;

import com.hsbcpb.omgt.core.BaseValueObject;
import com.hsbcpb.omgt.core.annotations.ValueObject;

@ValueObject
public class AccountNumber extends BaseValueObject {
	
	// ********************************************************* Fields
	private String number;

	// ********************************************************* Constructor
	public AccountNumber(String number) {
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
