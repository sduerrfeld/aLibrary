package org.alibrary.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;

@Entity
public class Buch {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull(message="isbn may not be null")
	@Pattern(regexp = "ISBN\\x20(?=.{13}$)\\d{1,5}([- ])\\d{1,7}\\1\\d{1,6}\\1(\\d|X)$", message="isbn not valid")
	private String isbn;
	
	@NotEmpty(message="titel may not be null")
	private String titel;
	private String autor;
	
	@NotEmpty(message="markierung may not be empty")
	private String markierung;
	
	private String ausleiher;
	
	@Type(type="org.joda.time.contrib.hibernate.PersistentLocalDate")
	private LocalDate ausleihdatum;
	
	@NotEmpty(message="ausleihstatus may not be empty")
	private String ausleihstatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public void setMarkierung(final String markierung) {
		this.markierung = markierung;
	}

	public String getMarkierung() {
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

	public String getAusleihstatus() {
		return ausleihstatus;
	}

	public void setAusleihstatus(final String status) {
		this.ausleihstatus = status;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Buch)) {
			return false;
		}
		Buch buch = (Buch) obj;
		
		return this.id == buch.id;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}
	
}
