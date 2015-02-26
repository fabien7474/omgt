package com.hsbcpb.omgt.domain.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.hsbcpb.omgt.core.BaseValueObject;
import com.hsbcpb.omgt.core.annotations.ValueObject;

@ValueObject
public class Society extends BaseValueObject {

	// ********************************************************* Fields
	private String number;
	

	// ********************************************************* Constructor

	public Society(String number) {
		this.number = number;
	}

	// ********************************************************* Getters
	@NotNull
	@Size(min=1, max=10)
	public String getNumber() {
		return number;
	}
}
