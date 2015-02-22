package com.hsbcpb.omgt.domain;

import com.hsbcpb.omgt.commons.FunctionalKeyAbstract;

public class ClientFK extends FunctionalKeyAbstract<Client> {

	// ********************************************************* Fields
	private AccountNumber accountNumber;
	
	// ********************************************************* Constructor

	public ClientFK(AccountNumber accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}
	
    // ********************************************************* Getters

	public AccountNumber getAccountNumber() {
		return accountNumber;
	}
	
}
