package org.alibrary.frontend.pages;

import static org.alibrary.frontend.pages.BuchAnzeigePage.ISBN_AUSGABE_ID;
import static org.alibrary.frontend.pages.IsbnEingabePage.ISBN_EINGABE_FORM_ID;
import static org.alibrary.frontend.pages.IsbnEingabePage.ISBN_FIELD_ID;

import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Test;

public class TestIsbnEingabePage extends WicketTester {

	@Test
	public void testIsbnEingabe() {
		this.startPage(IsbnEingabePage.class);
		FormTester form = this.newFormTester(ISBN_EINGABE_FORM_ID);
		form.setValue(ISBN_FIELD_ID, "irgendwas");
		form.submit();

		this.assertRenderedPage(BuchAnzeigePage.class);
		this.assertLabel(ISBN_AUSGABE_ID, "irgendwas");
	}

}
