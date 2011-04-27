package org.alibrary.frontend.pages;

import static org.alibrary.frontend.pages.BuchAnzeigePage.AUTHOR_AUSGABE_ID;
import static org.alibrary.frontend.pages.BuchAnzeigePage.AUTHOR_LABEL_ID;
import static org.alibrary.frontend.pages.BuchAnzeigePage.ISBN_AUSGABE_ID;
import static org.alibrary.frontend.pages.BuchAnzeigePage.ISBN_LABEL_ID;
import static org.alibrary.frontend.pages.BuchAnzeigePage.TITEL_AUSGABE_ID;
import static org.alibrary.frontend.pages.BuchAnzeigePage.TITEL_LABEL_ID;
import static org.alibrary.frontend.pages.IsbnEingabePage.ISBN_EINGABE_FORM_ID;
import static org.alibrary.frontend.pages.IsbnEingabePage.ISBN_FIELD_ID;

import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Test;


public class TestBuchAnzeigePage extends WicketTester {
	
	@Test
	public void testBuchAnzeige() {
		this.startPage(IsbnEingabePage.class);
		FormTester form = this.newFormTester(ISBN_EINGABE_FORM_ID);
		form.setValue(ISBN_FIELD_ID, "irgendwas");
		form.submit();
		
		this.assertRenderedPage(BuchAnzeigePage.class);
		this.assertLabel(ISBN_LABEL_ID, "ISBN:");
		this.assertLabel(ISBN_AUSGABE_ID, "irgendwas");
		
		this.assertLabel(AUTHOR_LABEL_ID, "Author:");
		this.assertLabel(AUTHOR_AUSGABE_ID, "irgendwer");
		
		this.assertLabel(TITEL_LABEL_ID, "Titel:");
		this.assertLabel(TITEL_AUSGABE_ID, "irgendwie");
	}

}
