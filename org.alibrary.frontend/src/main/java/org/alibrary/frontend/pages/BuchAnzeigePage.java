package org.alibrary.frontend.pages;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class BuchAnzeigePage  extends WebPage {
	
	static final String ISBN_AUSGABE_ID = "isbnAusgabe";
	static final String ISBN_PARAMETER = "isbn";

	public BuchAnzeigePage(PageParameters params) {
		super(params);
		IModel<String> isbn = new Model<String>(params.getString(ISBN_PARAMETER));
		Label label = new Label(ISBN_AUSGABE_ID, isbn);
		add(label);
	}
	
}
