package com.hsbcpb.omgt.domain;

import com.hsbcpb.omgt.commons.BaseValueObject;

public class DocumentType extends BaseValueObject {

	// ********************************************************* Fields
	private String type;

	// ********************************************************* Constructor
	
	public DocumentType(String type) {
		super();
		this.type = type;
	}

	// ********************************************************* Business Methods

	// ********************************************************* Technical Methods

	// ********************************************************* Getters
	public String getType() {
		return type;
	}
}
