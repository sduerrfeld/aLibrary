package org.alibrary.backend.model;

import static org.junit.Assert.assertEquals;

import org.alibrary.backend.model.Buch;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class BuchTest {

	private Buch buch;

	@Before
	public void setUp() {
		buch = new Buch();
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
}
