package com.hsbcpb.omgt.domain.service.spools;

import org.joda.time.DateTime;

import com.hsbcpb.omgt.domain.model.documents.UnsortedDocuments;
import com.hsbcpb.omgt.domain.model.spools.SpoolList;

public interface SpoolsService {

	/**
	 * Generate a sorted list of spools out of a list of unsorted documents 
	 * @param documents Unsorted document
	 * @return the lost of spool structured as a {@link SpoolList}
	 */
	SpoolList generateSpoolList(UnsortedDocuments documents, DateTime creationTime);
	
}
