package com.hsbcpb.omgt.domain.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.hsbcpb.omgt.core.ObjectFunctionalKeyAware;
import com.hsbcpb.omgt.core.annotations.Entity;

/**
 * Represents a client for the OMgt domain space. 
 *
 */
@Entity
public class Client extends ObjectFunctionalKeyAware {

	// ********************************************************* Fields
	private CustomerNumber customerNumber;
	private String shortName;
	private AccountNumber accountNumber;

	// ********************************************************* Constructor

	public Client(CustomerNumber customerNumber, String shortName, AccountNumber accountNumber) {
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
	 * @return Account number of the {@link Client}
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
	public ClientFK getFunctionalKey() {
		return new ClientFK(getCustomerNumber());
	}

	// ********************************************************* Private methods

}
