package com.hsbcpb.omgt.domain;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.hsbcpb.omgt.core.validation.AbstractValidationTest;
import com.hsbcpb.omgt.domain.model.documents.Document;
import com.hsbcpb.omgt.domain.model.documents.Document.DocumentBuilder;

public class DocumentTest extends AbstractValidationTest<Document> {

	private DocumentBuilder documentBuilder;


	@Override
	@Before
	public void setUp() {
		super.setUp();
		documentBuilder = new DocumentBuilder();
		documentBuilder.id("1").code("PDF").dispatchCode("NOR")
				.address(Arrays.asList("Line 1"))
				.customer("Cust#1", "Joe Dassin", null).pages(2)
				.society("Society#1");

	}

	@Test
	public void testValidDocument() {
		Document doc = documentBuilder.build();
		validate(doc);
		testAllConstraintViolations();
	}

	@Test
	public void testNullDocumentCode() {
		Document doc = documentBuilder.code(null).build();
		validate(doc);
		addExpectedConstraintViolation("documentCode.code");
		testAllConstraintViolations();
	}

	public void testDocumentCodeTooLong() {
		Document doc = documentBuilder.code("12345").build();
		validatePropertyWithMsg(doc, "documentCode");
		addExpectedConstraintViolation("documentCode.code", "The document code '12345' must be no more than 4 chars");
		testAllConstraintViolations();
	}

	@Test
	public void testNullDispatchCode() {
		Document doc = documentBuilder.dispatchCode(null).build();
		validate(doc);
		addExpectedConstraintViolation("dispatchCode.code");
		testAllConstraintViolations();
	}
	
	@Test
	public void testNullDispatchCodeAndNullDocumentCode() {
		Document doc = documentBuilder.dispatchCode(null).code(null).build();
		validate(doc);
		addExpectedConstraintViolation("dispatchCode.code");
		addExpectedConstraintViolation("documentCode.code");
		testAllConstraintViolations();
	}
	
	@Test
	public void testAddressWithNoLines() {
		Document doc = documentBuilder.address(new ArrayList<String>()).build();
		validate(doc);
		addExpectedConstraintViolation("address.lines");
		testAllConstraintViolations();
	}
	
}
