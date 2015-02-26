package com.hsbcpb.omgt.domain.model.documents;

import com.hsbcpb.omgt.core.FunctionalKeyAbstract;

public class DocumentFK extends FunctionalKeyAbstract<Document> {

	// ********************************************************* Fields
	private String id;

	// ********************************************************* Constructor
	public DocumentFK(String id) {
		super();
		this.id = id;
	} 
	
	public DocumentFK(Document doc) {
		this(doc.getId());
	}
	
	// ********************************************************* Getters
	public String getId() {
		return id;
	}
}
