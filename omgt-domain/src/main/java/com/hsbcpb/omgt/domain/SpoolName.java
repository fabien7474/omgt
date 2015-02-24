package com.hsbcpb.omgt.domain;

import com.hsbcpb.omgt.commons.BaseValueObject;
import com.hsbcpb.omgt.commons.annotations.ValueObject;

@ValueObject
public class SpoolName extends BaseValueObject {
	
	// ********************************************************* Fields
	private String name;

	// ********************************************************* Getters
	public String getName() {
		return name;
	}
}
