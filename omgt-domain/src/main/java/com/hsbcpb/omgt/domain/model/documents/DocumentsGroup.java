package com.hsbcpb.omgt.domain.model.documents;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;

import com.hsbcpb.omgt.core.ObjectFunctionalKeyAware;
import com.hsbcpb.omgt.core.annotations.Entity;
import com.hsbcpb.omgt.domain.model.Address;
import com.hsbcpb.omgt.domain.model.DispatchCode;
import com.hsbcpb.omgt.domain.model.RegionCode;

/**
 * Documents grouped by common characteristics.
 * Documents in the same group cannot be split up by spools.
 */
@Entity
public class DocumentsGroup extends ObjectFunctionalKeyAware {

	// ********************************************************* Fields
	private DispatchCode dispatchCode;
	private RegionCode regionCode;
	private Address address;
	
	private List<Document> documents = new ArrayList<Document>();

	// ********************************************************* Constructor

	public DocumentsGroup(Document doc) {
		this.dispatchCode = doc.getDispatchCode();
		this.regionCode = doc.getRegionCode();
		this.address = doc.getAddress();
		addDocument(doc);
	}

	// ********************************************************* Business

	public void addDocument(Document doc) {
		if (!doesDocumentBelongsToGroup(doc)) {
			throw new IllegalArgumentException("Document is not compatible");
		}
		documents.add(doc);
	}

	public boolean doesDocumentBelongsToGroup(Document doc) {
		return getFunctionalKey().equals(new DocumentsGroupFK(doc));
	}

	// ********************************************************* Getters
	@Min(value=1)
	public List<Document> getDocuments() {
		return documents;
	}

	public DispatchCode getDispatchCode() {
		return dispatchCode;
	}

	public RegionCode getRegionCode() {
		return regionCode;
	}

	public Address getAddress() {
		return address;
	}

	// ********************************************************* Technical
	@Override
	public DocumentsGroupFK getFunctionalKey() {
		return new DocumentsGroupFK(this);
	}

}
