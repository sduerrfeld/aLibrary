package org.alibrary.frontend.pages;

import static org.alibrary.frontend.pages.BuchAnzeigePage.ISBN_AUSGABE_ID;
import static org.alibrary.frontend.pages.IsbnEingabePage.ISBN_EINGABE_FORM_ID;
import static org.alibrary.frontend.pages.IsbnEingabePage.ISBN_FIELD_ID;

import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

public class TestIsbnEingabePage
{
	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester();
	}

	@Test
	public void testIsbnEingabe() {
		tester.startPage(IsbnEingabePage.class);
		FormTester form = tester.newFormTester(ISBN_EINGABE_FORM_ID);
		form.setValue(ISBN_FIELD_ID, "irgendwas");
		form.submit();
		
		tester.assertRenderedPage(BuchAnzeigePage.class);
		tester.assertLabel(ISBN_AUSGABE_ID, "irgendwas");
		
	}
}
