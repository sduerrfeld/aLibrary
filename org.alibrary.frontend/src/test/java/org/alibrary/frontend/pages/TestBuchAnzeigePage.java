package org.alibrary.frontend.pages;

import static org.alibrary.frontend.pages.BuchAnzeigePage.AUTHOR_AUSGABE_ID;
import static org.alibrary.frontend.pages.BuchAnzeigePage.AUTHOR_LABEL_ID;
import static org.alibrary.frontend.pages.BuchAnzeigePage.ISBN_AUSGABE_ID;
import static org.alibrary.frontend.pages.BuchAnzeigePage.ISBN_LABEL_ID;
import static org.alibrary.frontend.pages.BuchAnzeigePage.SAVE_FORM_ID;
import static org.alibrary.frontend.pages.BuchAnzeigePage.TITEL_AUSGABE_ID;
import static org.alibrary.frontend.pages.BuchAnzeigePage.TITEL_LABEL_ID;
import static org.alibrary.frontend.pages.IsbnEingabePage.ISBN_PARAMETER;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.alibrary.backend.dao.BuchDao;
import org.alibrary.backend.model.Buch;
import org.apache.wicket.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.spring.test.ApplicationContextMock;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class TestBuchAnzeigePage extends WicketTester {

	@Test
	public void testBuchAnzeige() {
		PageParameters parameters = new PageParameters();
		parameters.put(ISBN_PARAMETER, "irgendwas");
		this.startPage(BuchAnzeigePage.class, parameters);

		this.assertRenderedPage(BuchAnzeigePage.class);
		this.assertLabel(ISBN_LABEL_ID, "ISBN:");
		this.assertLabel(ISBN_AUSGABE_ID, "irgendwas");

		this.assertLabel(AUTHOR_LABEL_ID, "Author:");
		this.assertLabel(AUTHOR_AUSGABE_ID, "irgendwer");

		this.assertLabel(TITEL_LABEL_ID, "Titel:");
		this.assertLabel(TITEL_AUSGABE_ID, "irgendwie");
	}

	@Test
	public void testBuchSpeichern() throws Exception {
		BuchDao buchDaoMock = mock(BuchDao.class);

		ApplicationContextMock appctx = new ApplicationContextMock();
		appctx.putBean("contactDao", buchDaoMock);

		WicketTester app = new WicketTester();
		app.getApplication()
				.addComponentInstantiationListener(
						new SpringComponentInjector(app.getApplication(),
								appctx, true));

		PageParameters parameters = new PageParameters();
		parameters.put(ISBN_PARAMETER, "irgendwas");
		this.startPage(BuchAnzeigePage.class, parameters);

		FormTester form = this.newFormTester(SAVE_FORM_ID);
		form.submit();

		ArgumentCaptor<Buch> captor = ArgumentCaptor.forClass(Buch.class);
		verify(buchDaoMock).speichereBuch(captor.capture());
		assertEquals("irgendwas", captor.getValue().getISBN());
	}

}
