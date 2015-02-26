package com.hsbcpb.omgt.domain.service;

import com.hsbcpb.omgt.domain.model.DispatchCode;
import com.hsbcpb.omgt.domain.model.EnvelopeSize;
import com.hsbcpb.omgt.domain.model.documents.Document;
import com.hsbcpb.omgt.domain.model.documents.DocumentsGroup;
import com.hsbcpb.omgt.domain.model.spools.SpoolRouting;

/**
 * Domain Services for {@link SpoolRouting}
 *
 */
public interface SpoolRoutingService {

	/**
	 * Calculate the {@link SpoolRouting} for a given {@link Document}
	 * @param document The {@link Document} to calculate the {@link SpoolRouting}s
	 * @return The calculated {@link SpoolRouting}
	 */
	SpoolRouting calculateSpoolRooting(DispatchCode docDispatchCode);
	
	EnvelopeSize calculateEnvelopeSize(DocumentsGroup group);

	
}
