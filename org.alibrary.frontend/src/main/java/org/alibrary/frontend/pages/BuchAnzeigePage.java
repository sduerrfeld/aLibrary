package org.alibrary.frontend.pages;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class BuchAnzeigePage  extends WebPage {
	static final String ISBN_PARAMETER = "isbn";
	
	public static final String ISBN_LABEL_ID = "isbnLabel";
	public static final String ISBN_AUSGABE_ID = "isbnAusgabe";
	public static final String AUTHOR_LABEL_ID = "authorLabel";
	public static final String AUTHOR_AUSGABE_ID = "authorAusgabe";
	public static final String TITEL_LABEL_ID = "titelLabel";
	public static final String TITEL_AUSGABE_ID = "titelAusgabe";

	public BuchAnzeigePage(PageParameters params) {
		super(params);
		IModel<String> isbn = new Model<String>(params.getString(ISBN_PARAMETER));
		Label isbnAusgabe = new Label(ISBN_AUSGABE_ID, isbn);
		Label isbnLabel = new Label(ISBN_LABEL_ID, "ISBN:");
		Label authorLabel = new Label(AUTHOR_LABEL_ID, "Author:");
		Label authorAusgabe = new Label(AUTHOR_AUSGABE_ID, "irgendwer");
		Label titelLabel = new Label(TITEL_LABEL_ID, "Titel:");
		Label titelAusgabe = new Label(TITEL_AUSGABE_ID, "irgendwie");
		add(isbnLabel);
		add(isbnAusgabe);
		add(authorLabel);
		add(authorAusgabe);
		add(titelLabel);
		add(titelAusgabe);
	}
	
}
