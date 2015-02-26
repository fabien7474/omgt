package com.hsbcpb.omgt.domain.service.spools.impl;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.hsbcpb.omgt.domain.model.spools.Spool;
import com.hsbcpb.omgt.domain.service.spools.SpoolNameGenerator;

public class SpoolNameGeneratorImpl implements SpoolNameGenerator {

	// ********************************************************* Implemented Services
	@Override
	public String generateSpoolName(Spool spool, String heading,
			DateTime creationDate) {
		StringBuffer spoolName = new StringBuffer();
		spoolName.append(heading);
		spoolName.append(printSize(spool));
		spoolName.append(printDispatchCode(spool));
		spoolName.append("_");
		spoolName.append(printRegionCode(spool));
		spoolName.append("_");
		spoolName.append(printIncrement(spool));
		spoolName.append("_");
		spoolName.append(printDate(creationDate));
		spoolName.append("_");
		spoolName.append(printTime(creationDate));
		return spoolName.toString(); 

	}

	// ********************************************************* Private methods
	private String printRegionCode(Spool spool) {
		return spool.getRegionCode().getCode();
	}

	private String printDispatchCode(Spool spool) {
		return spool.getDispatchCode().getCode();
	}
	
	private String printSize(Spool spool) {
		switch (spool.getSize()) {
		case C4:
			return "4";
		case C5:
			return "5";
		case X:
			return "X";
		default:
			throw new AssertionError();
		}
	}
	
	private String printIncrement(Spool spool) {
		NumberFormat formatter = new DecimalFormat("000");
		String incrementStr = formatter.format(spool.getIncrement());
		return incrementStr;
	}
	
	
	private String printDate(DateTime creationDate) {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyyMMdd");
		String dateStr = fmt.print(creationDate);
		return dateStr;
	}

	private String printTime(DateTime creationDate) {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("HHmmss");
		String timeStr = fmt.print(creationDate);
		return timeStr;
	}
	


}
