package org.alibrary.backend.dao;

import javax.annotation.Resource;
import javax.inject.Named;

import org.alibrary.backend.model.Buch;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Named
public class BuchDaoImpl implements BuchDao {

	@Resource
	private SessionFactory sessionFactory;
	
	@Transactional
	public Buch speichereBuch(Buch buch) {
		return (Buch) sessionFactory.getCurrentSession().merge(buch);
	}

	@Transactional(readOnly=true)
	public Buch ladeBuch(Long id) {
		return (Buch) sessionFactory.getCurrentSession().get(Buch.class, id);
	}

}
