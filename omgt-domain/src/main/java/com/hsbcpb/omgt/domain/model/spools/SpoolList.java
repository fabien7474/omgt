package com.hsbcpb.omgt.domain.model.spools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.joda.time.DateTime;

import com.hsbcpb.omgt.core.annotations.Aggregate;
import com.hsbcpb.omgt.domain.model.EnvelopeSize;
import com.hsbcpb.omgt.domain.model.documents.DocumentsGroup;
import com.hsbcpb.omgt.domain.service.SpoolRoutingService;

/**
 * Represents the list of the spools to be printed
 *
 */
@Aggregate
public class SpoolList {

	// ********************************************************* Injected Service
	private SpoolRoutingService spoolRoutingService;
	
	
	// ********************************************************* Fields
	private DateTime creationDateTime;

	private List<Spool> spools = new ArrayList<Spool>();

	// ********************************************************* Constructor
	public SpoolList(DateTime creationDateTime, SpoolRoutingService spoolRoutingService) {
		this.creationDateTime = creationDateTime;
		this.spoolRoutingService = spoolRoutingService;
	}

	// ********************************************************* Business Method

	public void insertDocumentsGroupsInSpools(List<DocumentsGroup> groups) {
		for (DocumentsGroup group : groups) {
			insertDocumentsGroupInSpool(group);
		}
	}
	
	public void insertDocumentsGroupInSpool(DocumentsGroup group) {
		
		EnvelopeSize size = spoolRoutingService.calculateEnvelopeSize(group);
		
		Spool matchingSpool = searchMatchingSpool(group, size);
		if (matchingSpool != null) {
			matchingSpool.addDocumentsGroup(group);
		} else {
			Spool spool = new Spool(group.getDispatchCode(), group.getRegionCode(), size, 1, creationDateTime);
			spools.add(spool);
		}
	}

	/**
	 * Search the matching spool for a given document group.
	 * 
	 * @param doc
	 *            Document to be inserted into the spool
	 * @param size
	 *            Size of the envelope
	 */
	public Spool searchMatchingSpool(DocumentsGroup group, EnvelopeSize size) {
		Spool matchingSpool = CollectionUtils.find(spools, new DocumentsGroupPredicate(group, size));
		return matchingSpool;

	}

	// ********************************************************* Getters
	public DateTime getCreationDateTime() {
		return creationDateTime;
	}
	
	public List<Spool> getSpools() {
		return Collections.unmodifiableList(spools);
	}

	// ********************************************************* Private inner classes
	private final class DocumentsGroupPredicate implements Predicate<Spool> {
		DocumentsGroup group;
		EnvelopeSize size;

		public DocumentsGroupPredicate(DocumentsGroup group, EnvelopeSize size) {
			this.group = group;
			this.size = size;
		}
		
		@Override
		public boolean evaluate(Spool spool) {
			return spool.getDispatchCode().equals(group.getDispatchCode())
					&& spool.getRegionCode().equals(group.getRegionCode())
					&& spool.getSize().equals(size);
		}
	}



}
