package com.hsbcpb.omgt.domain.service;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import com.hsbcpb.omgt.domain.model.DispatchCode;
import com.hsbcpb.omgt.domain.model.EnvelopeSize;
import com.hsbcpb.omgt.domain.model.RegionCode;
import com.hsbcpb.omgt.domain.model.spools.Spool;
import com.hsbcpb.omgt.domain.service.spools.SpoolNameGenerator;
import com.hsbcpb.omgt.domain.service.spools.impl.SpoolNameGeneratorImpl;

/**
 * Class that tests the {@link SpoolNameGenerator} behavior 
 *
 */
public class SpoolNameGeneratorTest {

	// ********************************************************* Injection Fields
	private SpoolNameGenerator generator;
	
	// ********************************************************* Fixture Fields
	Spool spool;
	String heading;
	DateTime creationDate;
	
	// ********************************************************* Result Fields
	String spoolName;
	
	
	// ********************************************************* Setup
	@Before
	public void setUp() throws Exception {
		generator = new SpoolNameGeneratorImpl();
		spool = setupSpool(EnvelopeSize.C4, "NOR", "OTH", 1);
		creationDate = new DateTime(2015, 3, 1, 10, 15, 30);
		heading = "G";
	}

	// ********************************************************* Test methods
	@Test
	public void testFirstSpoolName() {
		
		generateAndCheckSpoolName("G4NOR_OTH_001_20150301_101530");
		
	}
	
	@Test
	public void testSpoolNameWithModifiedDate() {

		changeCreationDate(new DateTime(2015, 2, 1, 11, 15, 00));
		
		generateAndCheckSpoolName("G4NOR_OTH_001_20150201_111500");
	}
	
	

	// ********************************************************* Private Methods

	private void generateAndCheckSpoolName(String expectedSpoolName) {
		generateSpoolName();
		assertSpoolName(expectedSpoolName);
	}

	private void assertSpoolName(String expectedSpoolName) {
		assertThat(spoolName).isEqualTo(expectedSpoolName);
	}

	private void generateSpoolName() {
		spoolName = generator.generateSpoolName(spool, heading, creationDate);
	}

	private void changeCreationDate(DateTime newCreationDate)  {
		creationDate = newCreationDate;
	}
	
	private Spool setupSpool(EnvelopeSize size, String dispatchCode, String regionCode, Integer increment) {
		Spool spool = mock(Spool.class);
		when(spool.getSize()).thenReturn(size);
		when(spool.getDispatchCode()).thenReturn(new DispatchCode(dispatchCode));
		when(spool.getRegionCode()).thenReturn(new RegionCode(regionCode));
		when(spool.getIncrement()).thenReturn(increment);
		return spool;
	}

}
