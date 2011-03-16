package org.alibrary.backend.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

import org.junit.Before;
import org.junit.Test;

public class BuchTest {

	private Validator validator;

	@Before
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
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
