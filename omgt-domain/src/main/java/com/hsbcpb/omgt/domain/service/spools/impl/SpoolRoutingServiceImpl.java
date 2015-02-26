package com.hsbcpb.omgt.domain.service.spools.impl;

import java.util.Collection;

import com.hsbcpb.omgt.domain.model.DispatchCode;
import com.hsbcpb.omgt.domain.model.DispatchCodesConfiguration;
import com.hsbcpb.omgt.domain.model.EnvelopeSize;
import com.hsbcpb.omgt.domain.model.documents.DocumentsGroup;
import com.hsbcpb.omgt.domain.model.spools.SpoolRouting;
import com.hsbcpb.omgt.domain.service.spools.SpoolRoutingService;

/**
 * 
 *
 */
public class SpoolRoutingServiceImpl implements SpoolRoutingService {

	// ********************************************************* Fields
	private DispatchCodesConfiguration dispatchCodesConfiguration;

	// ********************************************************* Constructor
	public SpoolRoutingServiceImpl(DispatchCodesConfiguration dispatchCodesConfiguration) {
		super();
		this.dispatchCodesConfiguration = dispatchCodesConfiguration;
	}

	// ********************************************************* Implemented
	// Services
	/**
	 * {@inheritDoc}
	 */
	@Override
	public SpoolRouting calculateSpoolRooting(DispatchCode docDispatchCode) {

		// Retrieve configured automatic dispatch codes
		Collection<DispatchCode> automaticDispatchCodes = dispatchCodesConfiguration
				.listAllAutomaticDispatchCodes();

		// Test whether the Document Dispatch Code is in the configured
		// automatic dispatch codes
		boolean isDocDispatchCodeAutomatic = automaticDispatchCodes
				.contains(docDispatchCode);

		// If not automatic then routing is Manual
		SpoolRouting result = isDocDispatchCodeAutomatic ? SpoolRouting.Automatic
				: SpoolRouting.Manual;

		return result;
	}

	@Override
	// TODO: Refactor when C4/C5 story to be implemented
	public EnvelopeSize calculateEnvelopeSize(DocumentsGroup group) {
		SpoolRouting routing = calculateSpoolRooting(group.getDispatchCode());
		if (routing == SpoolRouting.Manual) {
			return EnvelopeSize.X;
		} else {
			return EnvelopeSize.C4;
		}
	}
}
