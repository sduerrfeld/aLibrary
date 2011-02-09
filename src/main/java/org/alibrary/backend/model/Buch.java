package org.alibrary.backend.model;

import org.alibrary.backend.model.Ausleihstatus;
import org.alibrary.backend.model.Markierung;
import org.joda.time.LocalDate;

public class Buch {

	private String isbn;
	private String titel;
	private String autor;
	private Markierung markierung;
	private String ausleiher;
	private LocalDate ausleihdatum;
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
