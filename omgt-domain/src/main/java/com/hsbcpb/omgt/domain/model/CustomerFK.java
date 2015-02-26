package com.hsbcpb.omgt.domain.model;

import com.hsbcpb.omgt.core.FunctionalKeyAbstract;

/**
 * Functional Key of a {@link Customer}
 *
 */
public class CustomerFK extends FunctionalKeyAbstract<Customer> {

	// ********************************************************* Fields
	private CustomerNumber customerNumber;
	
	// ********************************************************* Constructor

	public CustomerFK(CustomerNumber customerNumber) {
		super();
		this.customerNumber = customerNumber;
	}
	
    // ********************************************************* Getters

	public CustomerNumber getCustomerNumber() {
		return customerNumber;
	}
	
}
