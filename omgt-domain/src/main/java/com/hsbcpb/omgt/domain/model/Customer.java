package com.hsbcpb.omgt.domain.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.hsbcpb.omgt.core.ObjectFunctionalKeyAware;
import com.hsbcpb.omgt.core.annotations.Entity;

/**
 * Represents a customer for the OMgt domain space. 
 *
 */
@Entity
public class Customer extends ObjectFunctionalKeyAware {

	// ********************************************************* Fields
	private CustomerNumber customerNumber;
	private String shortName;
	private AccountNumber accountNumber;

	// ********************************************************* Constructor

	public Customer(CustomerNumber customerNumber, String shortName, AccountNumber accountNumber) {
		super();
		this.customerNumber = customerNumber;
		this.shortName = shortName;
		this.accountNumber = accountNumber;
	}

	// ********************************************************* Business

	// ********************************************************* Getters

	@NotNull
	@Valid
	public CustomerNumber getCustomerNumber() {
		return customerNumber;
	}
	
	/**
	 * 
	 * @return Account number of the {@link Customer}
	 */
	public AccountNumber getAccountNumber() {
		return accountNumber;
	}
	
	@NotNull
	@Size(min=1, max=40)
	public String getShortName() {
		return shortName;
	}
	
	// ********************************************************* Technical
	@Override
	public CustomerFK getFunctionalKey() {
		return new CustomerFK(getCustomerNumber());
	}

	// ********************************************************* Private methods

}
