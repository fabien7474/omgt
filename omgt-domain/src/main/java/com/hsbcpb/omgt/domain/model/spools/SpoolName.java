package com.hsbcpb.omgt.domain.model.spools;

import com.hsbcpb.omgt.core.BaseValueObject;
import com.hsbcpb.omgt.core.annotations.ValueObject;

@ValueObject
public class SpoolName extends BaseValueObject {
	
	// ********************************************************* Fields
	private String name;

	// ********************************************************* Getters
	public String getName() {
		return name;
	}
}
