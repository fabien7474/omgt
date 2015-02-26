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

/**
 * A spool to be displayed in the PrintShop screen. <br>
 * One spool represents a bunch of pages with a start and end pages (aka
 * banners). This pages are gathered in the same spool because they should be
 * tretated the same way by Application Support persons
 *
 */
@Entity
public class Spool {

	// ********************************************************* Fields
	private DispatchCode dispatchCode;
	private RegionCode regionCode;
	private EnvelopeSize size;
	private Integer increment;
	
	private DateTime creationDateTime;

	private List<DocumentsGroup> documentsGroups = new ArrayList<DocumentsGroup>();

	// ********************************************************* Constructor

	Spool(DispatchCode dispatchCode, RegionCode regionCode, EnvelopeSize size,
			Integer increment, DateTime creationDateTime) {
		this.dispatchCode = dispatchCode;
		this.regionCode = regionCode;
		this.size = size;
		this.increment = increment;
		this.creationDateTime = creationDateTime;
	}

	// ********************************************************* Business Method

	public void addDocumentsGroup(DocumentsGroup group) {
		if (doesUnbreakableGroupBelongToSpool(group)) {
			throw new IllegalArgumentException(
					"The group does not belong to this spool");
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

	public String generateSpoolName(String heading) {
		return SpoolNameGenerator
				.generateSpoolName(this, heading);
	}

	// ********************************************************* Getters

	@NotNull
	@Valid
	public DispatchCode getDispatchCode() {
		return dispatchCode;
	}

	@Min(value = 1)
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
	
	@NotNull
	public DateTime getCreationDateTime() {
		return creationDateTime;
	}
	
	// ********************************************************* Private methods
}
