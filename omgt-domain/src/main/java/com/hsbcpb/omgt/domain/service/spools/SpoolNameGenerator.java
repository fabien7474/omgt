package com.hsbcpb.omgt.domain.service.spools;

import org.joda.time.DateTime;

import com.hsbcpb.omgt.domain.model.spools.Spool;


public interface SpoolNameGenerator {

	/**
	 * Generate a spool name 
	 * @param spool
	 * @param heading
	 * @param creationDate
	 * @return
	 */
	String generateSpoolName(Spool spool, String heading, DateTime creationDate);
	
}
