package com.hsbcpb.omgt.domain.model.spools;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

import com.hsbcpb.omgt.core.annotations.Entity;
import com.hsbcpb.omgt.domain.model.DispatchCode;
import com.hsbcpb.omgt.domain.model.EnvelopeSize;
import com.hsbcpb.omgt.domain.model.RegionCode;
import com.hsbcpb.omgt.domain.model.documents.Document;
import com.hsbcpb.omgt.domain.model.documents.DocumentsGroup;
import com.hsbcpb.omgt.domain.service.spools.SpoolNameGenerator;

@Entity
public class Spool {

	// ********************************************************* Injected Service
	private SpoolNameGenerator spoolNameGenerator;
	
	// ********************************************************* Fields
	private DispatchCode dispatchCode;
	private RegionCode regionCode;
	private EnvelopeSize size;
	private Integer increment;
	
	private List<DocumentsGroup> documentsGroups = new ArrayList<DocumentsGroup>();

	// ********************************************************* Constructor
	
	Spool(DispatchCode dispatchCode, RegionCode regionCode, EnvelopeSize size, Integer increment) {
		this.dispatchCode = dispatchCode;
		this.regionCode = regionCode;
		this.size = size;
		this.increment = increment;
	}
	
	// ********************************************************* Business Method
	
	public void addDocumentsGroup(DocumentsGroup group) {
		if (doesUnbreakableGroupBelongToSpool(group)) {
			throw new IllegalArgumentException("The group does not belong to this spool");
		}
		documentsGroups.add(group);
	}
	
	public boolean doesUnbreakableGroupBelongToSpool(DocumentsGroup group) {
		if (!group.getDispatchCode().equals(getDispatchCode())) {
			return false;
		}
		if (!group.getRegionCode().equals(getRegionCode())) {
			return false;
		}
		return true;
	}
	
	public List<Document> retrieveSortedDocuments() {
		List<Document> docs = new ArrayList<Document>();
		for (DocumentsGroup group : documentsGroups) {
			docs.addAll(group.getDocuments());
		}
		return docs;
	}
	
	public String generateSpoolName(String heading, DateTime creationDate) {
		return spoolNameGenerator.generateSpoolName(this, heading, creationDate);
	}

	// ********************************************************* Getters


	@NotNull
	@Valid
	public DispatchCode getDispatchCode() {
		return dispatchCode;
	}
	
	@Min(value= 1)
	public Integer getIncrement() {
		return increment;
	}
	
	@NotNull
	@Valid
	public RegionCode getRegionCode() {
		return regionCode;
	}
	
	@NotNull
	public EnvelopeSize getSize() {
		return size;
	}
	
	// ********************************************************* Private methods
}
