package com.hsbcpb.omgt.domain;

import com.hsbcpb.omgt.commons.ObjectFunctionalKeyAware;

public class Client extends ObjectFunctionalKeyAware {

	// ********************************************************* Fields
	private AccountNumber accountNumber;

	// ********************************************************* Constructor

	public Client(AccountNumber accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}

	// ********************************************************* Business
	// Methods

	// ********************************************************* Getters

	/**
	 * 
	 * @return Account number of the {@link Client}
	 */
	public AccountNumber getAccountNumber() {
		return accountNumber;
	}

	// ********************************************************* Technical
	// Methods
	@Override
	public ClientFK getFunctionalKey() {
		return new ClientFK(getAccountNumber());
	}

	// ********************************************************* Private methods

}
