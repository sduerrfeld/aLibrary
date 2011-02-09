package org.alibrary.frontend;

import org.alibrary.frontend.pages.HomePage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

public class ALibraryApplication extends WebApplication {

	public void init() {
		super.init();
		addComponentInstantiationListener(new SpringComponentInjector(this));
	}

	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

}
