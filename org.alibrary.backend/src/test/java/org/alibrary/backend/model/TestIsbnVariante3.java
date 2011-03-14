package org.alibrary.backend.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

import org.junit.Before;
import org.junit.Test;

public class TestIsbnVariante3 {

	private Buch buch;
	private Validator validator;

	@Before
	public void setUp() {
		buch = new Buch();
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void isbnMussRegexEntsprechen() throws Exception {
		Buch buch = createValidBuch();
		buch.setISBN("abc");

		Set<ConstraintViolation<Buch>> result = validator.validate(buch,
				Default.class);
		assertThat(result.size(), is(1));

		ConstraintViolation<Buch> constraintViolation = result.iterator()
				.next();
		assertThat(constraintViolation.getPropertyPath().toString(), is("isbn"));

		buch.setISBN("ISBN 9-87654321-2");

		result = validator.validate(buch, Default.class);
		assertThat(result.size(), is(1));

		constraintViolation = result.iterator().next();
		assertThat(constraintViolation.getPropertyPath().toString(), is("isbn"));

		buch.setISBN("9-87654321-23");

		result = validator.validate(buch, Default.class);
		assertThat(result.size(), is(1));

		constraintViolation = result.iterator().next();
		assertThat(constraintViolation.getPropertyPath().toString(), is("isbn"));
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
