package com.hsbcpb.omgt.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hsbcpb.omgt.domain.model.DispatchCode;
import com.hsbcpb.omgt.domain.model.spools.SpoolRouting;
import com.hsbcpb.omgt.domain.service.DispatchCodesRepository;
import com.hsbcpb.omgt.domain.service.SpoolRoutingService;
import com.hsbcpb.omgt.domain.service.impl.SpoolRoutingServiceImpl;
import com.hsbcpb.omgt.persistence.DispatchCodesConfiguration;

public class OutputManagementBatch {

	public static final Logger LOG = LoggerFactory.getLogger(OutputManagementBatch.class);

	public static void main(String[] args) {

		//TODO: Replace it by DI from Spring Fwk or PicoConatainer
		DispatchCodesRepository dispatchCodesConfiguration = new DispatchCodesConfiguration();
		
		//TODO: Remove this and write real flow
		SpoolRoutingService spoolRoutingService = new SpoolRoutingServiceImpl(dispatchCodesConfiguration);
		
		SpoolRouting spoolRooting = spoolRoutingService.calculateSpoolRooting(new DispatchCode("WES"));
		
		LOG.info("spoolRooting=" + spoolRooting);
	}

}
