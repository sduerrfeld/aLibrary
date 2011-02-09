package org.alibrary.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PersistentMessage {
	
	@SuppressWarnings("unused")
	@Id
	@GeneratedValue
	private Long id;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
