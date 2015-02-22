package com.hsbcpb.omgt.domain;

import com.hsbcpb.omgt.commons.ObjectFunctionalKeyAware;
/**
 * Represents a document to be printed
 *
 */
public class Document extends ObjectFunctionalKeyAware  {
	
	// ********************************************************* Fields
	private DispatchCode dispatchCode;
	private RegionCode regionCode;
	private DocumentPages pages;
	private String id;
	private Address address; 
	private DocumentType documentType;
	
	// ********************************************************* Constructor
	
	// ********************************************************* Business Methods

	// ********************************************************* Technical Methods
	
	@Override
	public DocumentFK getFunctionalKey() {
		return new DocumentFK(getId());
	}
	
	// ********************************************************* Getters
	
	/**
	 * 
	 * @return The dispatch code of this {@link Document}
	 */
	public DispatchCode getDispatchCode() {
		return dispatchCode;
	}
	
	/**
	 * 
	 * @return The region code of this {@link Document}
	 */
	public RegionCode getRegionCode() {
		return regionCode;
	}
	
	/**
	 * 
	 * @return {@link DocumentPages} of this {@link Document}
	 */
	public DocumentPages getPages() {
		return pages;
	}
	
	/**
	 * 
	 * @return Unique identifier of this {@link Document}
	 */
	public String getId() {
		return id;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public DocumentType getDocumentType() {
		return documentType;
	}
}
