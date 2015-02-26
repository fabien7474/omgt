package com.hsbcpb.omgt.domain.model.documents;

import com.hsbcpb.omgt.core.FunctionalKeyAbstract;
import com.hsbcpb.omgt.domain.model.Address;
import com.hsbcpb.omgt.domain.model.DispatchCode;
import com.hsbcpb.omgt.domain.model.RegionCode;

public class DocumentsGroupFK extends FunctionalKeyAbstract<Document> {

	// ********************************************************* Fields
	private DispatchCode dispatchCode;
	private RegionCode regionCode; 
	private Address address;

	// ********************************************************* Constructor
	public DocumentsGroupFK(DocumentsGroup group) {
		super();
		this.dispatchCode = group.getDispatchCode();
		this.regionCode = group.getRegionCode();
		this.address = group.getAddress();
	} 
	
	public DocumentsGroupFK(Document doc) {
		super();
		this.dispatchCode = doc.getDispatchCode();
		this.regionCode = doc.getRegionCode();
		this.address = doc.getAddress();
	} 
	// ********************************************************* Getters
	
	public DispatchCode getDispatchCode() {
		return dispatchCode;
	}
	
	public RegionCode getRegionCode() {
		return regionCode;
	}
	
	public Address getAddress() {
		return address;
	}
}
