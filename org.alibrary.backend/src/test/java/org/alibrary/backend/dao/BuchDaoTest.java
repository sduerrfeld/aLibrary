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

	@Resource
	private BuchDao buchDao;

	@Test
	public void testSpeichereBuch() {
		Buch buch = new Buch();
		buch.setISBN("ISBN 0 93028 923 4");
		buch.setTitel("Ein Buch");
		buch.setAusleihstatus("Nicht ausgeliehen");
		buch.setMarkierung("Roter Punkt");
		
		Buch gespeichertesBuch = buchDao.speichereBuch(buch);
		
		Buch buchAusDatenbank = buchDao.ladeBuch(gespeichertesBuch.getId());
		
		assertEquals(gespeichertesBuch, buchAusDatenbank);
	}
	
}
