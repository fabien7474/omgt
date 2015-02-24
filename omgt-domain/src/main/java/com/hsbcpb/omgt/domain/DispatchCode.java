package com.hsbcpb.omgt.domain;

import com.hsbcpb.omgt.commons.BaseValueObject;
import com.hsbcpb.omgt.commons.annotations.ValueObject;

@ValueObject
public class DispatchCode extends BaseValueObject {

    // ********************************************************* Fields

	private String code;

	// ********************************************************* Constructor

	public DispatchCode(String code) {
		super();
		this.code = code;
	}

	// ********************************************************* Business Methods
	
    // ********************************************************* Technical Methods
	
    // ********************************************************* Getters
	
	/**
	 * 
	 * @return Code of the {@link DispatchCode}
	 */
	public String getCode() {
		return code;
	}

    // ********************************************************* Private methods
	
}
