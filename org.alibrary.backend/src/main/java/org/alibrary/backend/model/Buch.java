package org.alibrary.backend.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.alibrary.backend.model.Ausleihstatus;
import org.alibrary.backend.model.Markierung;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;

public class Buch {
	
	@NotNull
	@Pattern(regexp = "ISBN\\x20(?=.{13}$)\\d{1,5}([- ])\\d{1,7}\\1\\d{1,6}\\1(\\d|X)$")
	private String isbn;
	@NotEmpty
	private String titel;
	private String autor;
	@NotNull
	private Markierung markierung;
	private String ausleiher;
	private LocalDate ausleihdatum;
	@NotNull
	private Ausleihstatus ausleihstatus;

	public String getISBN() {
		return isbn;
	}

	public void setISBN(final String isbn) {
		this.isbn = isbn;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(final String title) {
		this.titel = title;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(final String author) {
		this.autor = author;
	}

	public void setMarkierung(final Markierung markierung) {
		this.markierung = markierung;
	}

	public Markierung getMarkierung() {
		return markierung;
	}

	public String getAusleiher() {
		return ausleiher;
	}

	public void setAusleiher(final String ausleiher) {
		this.ausleiher = ausleiher;
	}

	public LocalDate getAusleihdatum() {
		return ausleihdatum;
	}

	public void setAusleihdatum(final LocalDate ausleihdatum) {
		this.ausleihdatum = ausleihdatum;
	}

	public Ausleihstatus getAusleihstatus() {
		return ausleihstatus;
	}

	public void setAusleihstatus(final Ausleihstatus status) {
		this.ausleihstatus = status;
	}

}
