package com.hsbcpb.omgt.core.validation;

import javax.validation.ConstraintViolation;

import com.hsbcpb.omgt.core.BaseValueObject;

/**
 * Help to test constraint violations
 *
 */
public class SimpleConstraintViolation<T> extends BaseValueObject {

	private String propertyName;

	public SimpleConstraintViolation(String propertyName) {
		super();
		this.propertyName = propertyName;
	}

	public SimpleConstraintViolation(ConstraintViolation<T> constraintViolation) {
		this(constraintViolation.getPropertyPath().toString());
	}

	/**
	 * @return the propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}

}
