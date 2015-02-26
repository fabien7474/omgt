/**
 * 
 */
package com.hsbcpb.omgt.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.hsbcpb.omgt.domain.model.DispatchCode;
import com.hsbcpb.omgt.domain.model.documents.Document;
import com.hsbcpb.omgt.domain.model.spools.SpoolRouting;
import com.hsbcpb.omgt.domain.service.impl.SpoolRoutingServiceImpl;

/**
 * Test suite for SpoolRouting business rules
 */
public class SpoolRoutingServiceTest {
	
	private SpoolRoutingService spoolRoutingService;
	private DispatchCodesRepository config;
	private Document doc;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		config = mock(DispatchCodesRepository.class);
		spoolRoutingService = new SpoolRoutingServiceImpl(config);
		doc = mock(Document.class);
	}

	@Test
	public void whenDocumentDispatchCodeIsConfiguredAsAutomaticCodeThenSpoolRoutingIsAutomatic() {
		
		SpoolRouting spoolRootingResult = calculateSpoolRooting("NOR", "NOR");
		
		assertThat(spoolRootingResult).isEqualTo(SpoolRouting.Automatic);
		
	}
	
	@Test
	public void whenDocumentDispatchCodeIsContainedInAutomaticCodesThenSpoolRoutingIsAutomatic() {
		
		SpoolRouting spoolRootingResult = calculateSpoolRooting("NOR", "111", "NOR");
		
		assertThat(spoolRootingResult).isEqualTo(SpoolRouting.Automatic);
		
	}

	@Test
	public void whenDocumentDispatchCodeIsNotConfiguredAsAutomaticCodeThenSpoolRoutingIsManual() {
		
		SpoolRouting spoolRootingResult = calculateSpoolRooting("111", "NOR");
		
		assertThat(spoolRootingResult).isEqualTo(SpoolRouting.Manual);
		
	}
	
	@Test
	public void whenNoAutomaticCodesConfiguredThenSpoolRoutingIsManual() {
		
		SpoolRouting spoolRootingResult = calculateSpoolRooting("NOR");
		
		assertThat(spoolRootingResult).isEqualTo(SpoolRouting.Manual);
		
	}
	
	
	// ********************************************************* Private methods

	private SpoolRouting calculateSpoolRooting(String docCode, String... automaticCodes) {
		//Populate Configuration
		setupDispatchCodesConfiguration(automaticCodes);
		
		//Populate dispatch code of a document
		when(doc.getDispatchCode()).thenReturn(new DispatchCode(docCode));
		
		//Calculate the spool routing
		SpoolRouting spoolRootingResult = spoolRoutingService.calculateSpoolRooting(doc.getDispatchCode());
		return spoolRootingResult;
	}
	
	private DispatchCodesRepository setupDispatchCodesConfiguration(String... automaticCodes) {
		
		List<DispatchCode> returnedAutomaticCodes = new ArrayList<DispatchCode>();
		for (String automaticCode : automaticCodes) {
			returnedAutomaticCodes.add(new DispatchCode(automaticCode));
		}
		
		when(config.listAllAutomaticDispatchCodes()).thenReturn(returnedAutomaticCodes);
		return config;
	}

}
