package com.hsbcpb.omgt.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.constraints.Size;

import com.hsbcpb.omgt.core.BaseValueObject;
import com.hsbcpb.omgt.core.annotations.ValueObject;

/** 
 * Mailing address of a customer
 *
 */
@ValueObject
public class Address extends BaseValueObject {

	// ********************************************************* Fields
	private List<String> lines = new ArrayList<String>();

	// ********************************************************* Constructor
	
	public Address(List<String> lines) {
		super();
		this.lines = lines;
	}

	// ********************************************************* Business Methods
	public String getLine(int lineNumber) {
		return lines.get(lineNumber);
	}

	// ********************************************************* Technical Methods

	// ********************************************************* Getters
	@Size(min = 1)
	public List<String> getLines() {
		return Collections.unmodifiableList(lines);
	}
	
}
