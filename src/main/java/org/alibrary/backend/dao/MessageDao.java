package org.alibrary.backend.dao;

import javax.inject.Named;

import org.alibrary.backend.model.PersistentMessage;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Named
public class MessageDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void saveMessage(final String message) {
		PersistentMessage persitentMessage = new PersistentMessage();
		persitentMessage.setMessage(message);
		getSession().save(persitentMessage);
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public String readMessage() {
		return ((PersistentMessage) getSession().get(PersistentMessage.class, 1L)).getMessage();
	}

}
