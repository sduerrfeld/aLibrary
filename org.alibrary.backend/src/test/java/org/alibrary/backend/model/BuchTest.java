package org.alibrary.backend.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

import org.alibrary.backend.model.Buch;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import sun.dc.pr.PathDasher;

public class BuchTest {

	private Buch buch;
	private Validator validator;

	@Before
	public void setUp() {
		buch = new Buch();
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void einBuchHatEineIsbnNummer() throws Exception {
		String isbn = "1023-3040-I334-44";
		buch.setISBN(isbn);
		assertEquals(isbn, buch.getISBN());
	}

	@Test
	public void einBuchHatEinenTitel() throws Exception {
		String titel = "Refactoring";
		buch.setTitel(titel);
		assertEquals(titel, buch.getTitel());
	}

	@Test
	public void einBuchHatEinenAutor() throws Exception {
		String autor = "Martin Fowler";
		buch.setAutor(autor);
		assertEquals(autor, buch.getAutor());
	}

	@Test
	public void einBuchHatEineMarkierung() throws Exception {
		Markierung markierung = new Markierung();
		buch.setMarkierung(markierung);
		assertEquals(markierung, buch.getMarkierung());
	}

	@Test
	public void einBuchHatEinenAusleihstatus() throws Exception {
		Ausleihstatus status = new Ausleihstatus();
		buch.setAusleihstatus(status);
		assertEquals(status, buch.getAusleihstatus());
	}

	@Test
	public void einBuchHatEinenAusleiher() throws Exception {
		String ausleiher = "Ebe";
		buch.setAusleiher(ausleiher);
		assertEquals(ausleiher, buch.getAusleiher());
	}

	@Test
	public void einBuchHatEinAusleihdatum() throws Exception {
		LocalDate ausleihdatum = new LocalDate();
		buch.setAusleihdatum(ausleihdatum);
		assertEquals(ausleihdatum, buch.getAusleihdatum());
	}
	
	@Test
	public void testNotNullFields() throws Exception {
		Buch buch = new Buch();
		Set<ConstraintViolation<Buch>> result = validator.validate(buch, Default.class);
		assertThat(result.size(), is(4));
	}
	
	@Test
	public void testValidBuch() throws Exception {
		Buch buch = createValidBuch();
		Set<ConstraintViolation<Buch>> result = validator.validate(buch, Default.class);
		assertThat(result.isEmpty(), is(true));
	}
	
	@Test
	public void isbnDarfNichtNullSein() throws Exception {
		Buch buch = createValidBuch();
		buch.setISBN(null);
		
		Set<ConstraintViolation<Buch>> result = validator.validate(buch, Default.class);
		assertThat(result.size(), is(1));
		
		ConstraintViolation<Buch> constraintViolation = result.iterator().next();
		assertThat(constraintViolation.getInvalidValue(), is(nullValue()));
		assertThat(constraintViolation.getPropertyPath().toString(), is("isbn"));
	}
	
	@Test
	public void titelDarfNichtNullSein() throws Exception {
		Buch buch = createValidBuch();
		buch.setTitel(null);
		
		Set<ConstraintViolation<Buch>> result = validator.validate(buch, Default.class);
		assertThat(result.size(), is(1));
		
		ConstraintViolation<Buch> constraintViolation = result.iterator().next();
		assertThat(constraintViolation.getInvalidValue(), is(nullValue()));
		assertThat(constraintViolation.getPropertyPath().toString(), is("titel"));
	}
	
	@Test
	public void titelDarfNichtLeerSein() throws Exception {
		Buch buch = createValidBuch();
		buch.setTitel("");
		
		Set<ConstraintViolation<Buch>> result = validator.validate(buch, Default.class);
		assertThat(result.size(), is(1));
		
		ConstraintViolation<Buch> constraintViolation = result.iterator().next();
		assertThat(constraintViolation.getInvalidValue().toString(), is(""));
		assertThat(constraintViolation.getPropertyPath().toString(), is("titel"));
	}
	
	@Test
	public void markierungDarfNichtNullSein() throws Exception {
		Buch buch = createValidBuch();
		buch.setMarkierung(null);
		
		Set<ConstraintViolation<Buch>> result = validator.validate(buch, Default.class);
		assertThat(result.size(), is(1));
		
		ConstraintViolation<Buch> constraintViolation = result.iterator().next();
		assertThat(constraintViolation.getInvalidValue(), is(nullValue()));
		assertThat(constraintViolation.getPropertyPath().toString(), is("markierung"));
	}
	
	@Test
	public void ausleihstatusDarfNichtNullSein() throws Exception {
		Buch buch = createValidBuch();
		buch.setAusleihstatus(null);
		
		Set<ConstraintViolation<Buch>> result = validator.validate(buch, Default.class);
		assertThat(result.size(), is(1));
		
		ConstraintViolation<Buch> constraintViolation = result.iterator().next();
		assertThat(constraintViolation.getInvalidValue(), is(nullValue()));
		assertThat(constraintViolation.getPropertyPath().toString(), is("ausleihstatus"));
	}
	
	@Test
	public void isbnMussRegexEntsprechen() throws Exception {
		String[] invalidIsbns = {"abc", "ISBN 9-87654321-2"};
		for (String invalidIsbn : invalidIsbns) {
			Buch buch = createValidBuch();
			buch.setISBN(invalidIsbn);
			
			Set<ConstraintViolation<Buch>> result = validator.validate(buch, Default.class);
			assertThat(result.size(), is(1));
			
			ConstraintViolation<Buch> constraintViolation = result.iterator().next();
			assertThat(constraintViolation.getPropertyPath().toString(), is("isbn"));
		}
	}
	
	@Test
	public void testNothing() {
		
	}

	private Buch createValidBuch() {
		Buch buch = new Buch();
		buch.setISBN("ISBN 0 93028 923 4");
		buch.setTitel("Ein Buch");
		buch.setMarkierung(new Markierung());
		buch.setAusleihstatus(new Ausleihstatus());
		return buch;
	}
}
