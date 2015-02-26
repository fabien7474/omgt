package com.hsbcpb.omgt.domain.model;

import javax.validation.constraints.NotNull;

import com.hsbcpb.omgt.core.BaseValueObject;
import com.hsbcpb.omgt.core.annotations.ValueObject;

@ValueObject
public class RegionCode extends BaseValueObject {

    // ********************************************************* Fields

	@NotNull
	private String code;

	// ********************************************************* Constructor

	public RegionCode(String code) {
		super();
		this.code = code;
	}

	// ********************************************************* Business Methods
	
    // ********************************************************* Technical Methods
	
    // ********************************************************* Getters
	
	/**
	 * 
	 * @return Code of the {@link RegionCode}
	 */
	public String getCode() {
		return code;
	}

    // ********************************************************* Private methods
	
}
