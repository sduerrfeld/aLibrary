package org.alibrary.backend.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

import org.alibrary.backend.model.testsupport.ObjectMother;
import org.junit.Before;
import org.junit.Test;


public class TestIsbnVariante2 {

	private Validator validator;

	@Before
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	public void isbnMussRegexEntsprechen() throws Exception {
		String[] invalidIsbns = {"abc", "ISBN 9-87654321-2" ,"9-87654321-23"};
		for (String invalidIsbn : invalidIsbns) {
			Buch buch = ObjectMother.createValidBuch();
			buch.setISBN(invalidIsbn);
			
			Set<ConstraintViolation<Buch>> result = validator.validate(buch, Default.class);
			assertThat(result.size(), is(1));
			
			ConstraintViolation<Buch> constraintViolation = result.iterator().next();
			assertThat(constraintViolation.getPropertyPath().toString(), is("isbn"));
		}
	}	
}
