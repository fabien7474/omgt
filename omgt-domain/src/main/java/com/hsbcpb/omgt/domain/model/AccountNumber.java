package com.hsbcpb.omgt.domain.model;

import javax.validation.constraints.NotNull;

import com.hsbcpb.omgt.core.BaseValueObject;
import com.hsbcpb.omgt.core.annotations.ValueObject;

/**
 * Account NUmber of a customer
 *
 */
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
	@NotNull
	public String getNumber() {
		return number;
	}
}
