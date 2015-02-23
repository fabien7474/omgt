package com.hsbcpb.omgt.domain;

import com.hsbcpb.omgt.commons.BaseValueObject;

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
