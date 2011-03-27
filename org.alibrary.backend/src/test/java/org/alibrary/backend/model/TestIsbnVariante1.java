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

public class TestIsbnVariante1 {

	private Validator validator;

	@Before
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void isbnMussRegexEntsprechen1() throws Exception {
		Buch buch = ObjectMother.createValidBuch();
		buch.setISBN("abc");

		Set<ConstraintViolation<Buch>> result = validator.validate(buch,
				Default.class);
		assertThat(result.size(), is(1));

		ConstraintViolation<Buch> constraintViolation = result.iterator()
				.next();
		assertThat(constraintViolation.getPropertyPath().toString(), is("isbn"));
	}

	@Test
	public void isbnMussRegexEntspreche2() throws Exception {
		Buch buch = ObjectMother.createValidBuch();
		buch.setISBN("ISBN 9-87654321-2");

		Set<ConstraintViolation<Buch>> result = validator.validate(buch,
				Default.class);
		assertThat(result.size(), is(1));

		ConstraintViolation<Buch> constraintViolation = result.iterator()
				.next();
		assertThat(constraintViolation.getPropertyPath().toString(), is("isbn"));
	}

	@Test
	public void isbnMussRegexEntspreche3() throws Exception {
		Buch buch = ObjectMother.createValidBuch();
		buch.setISBN("9-87654321-23");

		Set<ConstraintViolation<Buch>> result = validator.validate(buch,
				Default.class);
		assertThat(result.size(), is(1));

		ConstraintViolation<Buch> constraintViolation = result.iterator()
				.next();
		assertThat(constraintViolation.getPropertyPath().toString(), is("isbn"));
	}
}
