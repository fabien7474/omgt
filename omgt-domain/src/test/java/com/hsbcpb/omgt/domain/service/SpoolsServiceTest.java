package com.hsbcpb.omgt.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.Arrays;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import com.hsbcpb.omgt.domain.model.DispatchCodesConfiguration;
import com.hsbcpb.omgt.domain.model.documents.Document;
import com.hsbcpb.omgt.domain.model.documents.Document.DocumentBuilder;
import com.hsbcpb.omgt.domain.model.documents.UnsortedDocuments;
import com.hsbcpb.omgt.domain.model.spools.Spool;
import com.hsbcpb.omgt.domain.model.spools.SpoolList;
import com.hsbcpb.omgt.domain.service.spools.SpoolsService;
import com.hsbcpb.omgt.domain.service.spools.impl.SpoolsServiceImpl;

public class SpoolsServiceTest {

	private SpoolsService spoolsService;
	private DispatchCodesConfiguration config;

	private UnsortedDocuments documents;
	private DocumentBuilder documentBuilder;
	
	@Before
	public void setUp() throws Exception {
		config = mock(DispatchCodesConfiguration.class);
		spoolsService = new SpoolsServiceImpl(config);
		
		documents = new UnsortedDocuments();
		
		documentBuilder = new DocumentBuilder();
		documentBuilder.id("1").code("0020").dispatchCode("NOR")
				.address(Arrays.asList("Line 1"))
				.client("Cust#1", "Joe Dassin", null).pages(2)
				.society("Society#1");
	}

	@Test
	public void test() {
		DateTime creationDate = new DateTime(2015, 3, 1, 10, 15, 30);
		
		Document doc = documentBuilder.build();
		documents.addDocument(doc);
		
		SpoolList spoolList = spoolsService.generateSpoolList(documents, creationDate);
		
		assertThat(spoolList.getSpools()).hasSize(1);
		
		String spoolName = spoolList.generateSpoolName(0, "A");
		assertThat(spoolName).isEqualTo("AXNOR__001_20150301_101530");
		
	}

}
