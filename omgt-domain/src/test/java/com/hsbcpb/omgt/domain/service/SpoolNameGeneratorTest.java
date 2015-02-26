package com.hsbcpb.omgt.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import com.hsbcpb.omgt.domain.model.DispatchCode;
import com.hsbcpb.omgt.domain.model.EnvelopeSize;
import com.hsbcpb.omgt.domain.model.RegionCode;
import com.hsbcpb.omgt.domain.model.spools.Spool;
import com.hsbcpb.omgt.domain.model.spools.SpoolNameGenerator;

/**
 * Class that tests the {@link SpoolNameGenerator} behavior 
 *
 */
public class SpoolNameGeneratorTest {

	
	// ********************************************************* Fixture Fields
	Spool spool;
	String heading;
	
	// ********************************************************* Result Fields
	String spoolName;
	
	
	// ********************************************************* Setup
	@Before
	public void setUp() throws Exception {
		DateTime creationDate = new DateTime(2015, 3, 1, 10, 15, 30);
		spool = setupSpool(EnvelopeSize.C4, "NOR", "OTH", 1, creationDate);
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
		spoolName = SpoolNameGenerator.generateSpoolName(spool, heading);
	}

	private void changeCreationDate(DateTime newCreationDateTime)  {
		when(spool.getCreationDateTime()).thenReturn(newCreationDateTime);
	}
	
	private Spool setupSpool(EnvelopeSize size, String dispatchCode, String regionCode, Integer increment, DateTime creationDateTime) {
		spool = mock(Spool.class);
		when(spool.getSize()).thenReturn(size);
		when(spool.getDispatchCode()).thenReturn(new DispatchCode(dispatchCode));
		when(spool.getRegionCode()).thenReturn(new RegionCode(regionCode));
		when(spool.getIncrement()).thenReturn(increment);
		when(spool.getCreationDateTime()).thenReturn(creationDateTime);
		return spool;
	}

}
