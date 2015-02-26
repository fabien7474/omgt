package com.hsbcpb.omgt.domain.model;

import com.hsbcpb.omgt.core.FunctionalKeyAbstract;

public class ClientFK extends FunctionalKeyAbstract<Client> {

	// ********************************************************* Fields
	private CustomerNumber customerNumber;
	
	// ********************************************************* Constructor

	public ClientFK(CustomerNumber customerNumber) {
		super();
		this.customerNumber = customerNumber;
	}
	
    // ********************************************************* Getters

	public CustomerNumber getCustomerNumber() {
		return customerNumber;
	}
	
}
