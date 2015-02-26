package com.hsbcpb.omgt.domain.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Pages {

	// ********************************************************* Fields
	@NotNull
	@Min(1)
	private Integer numPages;
	
	// ********************************************************* Constructor
	public Pages(Integer numPages) {
		super();
		this.numPages = numPages;
	}

	// ********************************************************* Getters
	public Integer getNumPages() {
		return numPages;
	}
}
