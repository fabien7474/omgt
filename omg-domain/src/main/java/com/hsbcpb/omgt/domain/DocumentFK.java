package com.hsbcpb.omgt.domain;

import com.hsbcpb.omgt.commons.FunctionalKeyAbstract;

public class DocumentFK extends FunctionalKeyAbstract<Document> {

	// ********************************************************* Fields
	private String id;

	// ********************************************************* Constructor
	public DocumentFK(String id) {
		super();
		this.id = id;
	} 
	
	// ********************************************************* Getters
	public String getId() {
		return id;
	}
}
