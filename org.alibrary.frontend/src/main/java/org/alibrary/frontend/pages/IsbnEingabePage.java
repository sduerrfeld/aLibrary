package org.alibrary.frontend.pages;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class IsbnEingabePage extends WebPage {

	static final String ISBN_PARAMETER = "isbn";
	static final String ISBN_FIELD_ID = "isbnField";
	static final String ISBN_EINGABE_FORM_ID = "isbnEingabeForm";
	private static final long serialVersionUID = 1L;

	public IsbnEingabePage() {
		final Model<String> model = new Model<String>("Bitte ISBN eingeben");

		Form<IModel<String>> form = new Form<IModel<String>>(ISBN_EINGABE_FORM_ID) {
			
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				PageParameters params = new PageParameters();
				params.put(ISBN_PARAMETER, model.getObject());
				setResponsePage(BuchAnzeigePage.class, params);
			}
		};
		add(form);

		TextField<String> isbnField = new TextField<String>(ISBN_FIELD_ID, model);
		form.add(isbnField);
	}

}
