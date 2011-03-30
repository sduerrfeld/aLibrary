package org.alibrary.frontend;

import org.alibrary.frontend.pages.IsbnEingabePage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

public class ALibraryApplication extends WebApplication {

	public void init() {
		super.init();
		addComponentInstantiationListener(new SpringComponentInjector(this));
	}

	public Class<IsbnEingabePage> getHomePage() {
		return IsbnEingabePage.class;
	}

}
