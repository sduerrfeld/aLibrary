package org.alibrary.backend.dao;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.alibrary.backend.model.Buch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-backend.xml"})
public class BuchDaoTest {

	private static final String MARKIERUNG = "Roter Punkt";
	private static final String AUSLEIHSTATUS = "Nicht ausgeliehen";
	private static final String TITEL = "Ein Buch";
	private static final String ISBN = "ISBN 0 93028 923 4";
	
	@Resource
	private BuchDao buchDao;

	@Test
	public void testSpeichereBuch() {
		Buch buch = new Buch();
		buch.setISBN(ISBN);
		buch.setTitel(TITEL);
		buch.setAusleihstatus(AUSLEIHSTATUS);
		buch.setMarkierung(MARKIERUNG);
		
		Buch gespeichertesBuch = buchDao.speichereBuch(buch);
		
		Buch buchAusDatenbank = buchDao.ladeBuch(gespeichertesBuch.getId());
		
		assertEquals(gespeichertesBuch, buchAusDatenbank);
		assertEquals(ISBN, buchAusDatenbank.getISBN());
		assertEquals(TITEL, buchAusDatenbank.getTitel());
		assertEquals(AUSLEIHSTATUS, buchAusDatenbank.getAusleihstatus());		
		assertEquals(MARKIERUNG, buchAusDatenbank.getMarkierung());		
	}
	
}
