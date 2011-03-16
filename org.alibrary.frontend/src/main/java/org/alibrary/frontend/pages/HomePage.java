package org.alibrary.frontend.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	public HomePage() {
		add(new Label("message", "Hello World"));
	}

}
