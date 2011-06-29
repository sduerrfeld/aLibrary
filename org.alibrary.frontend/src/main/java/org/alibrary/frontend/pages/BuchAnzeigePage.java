package org.alibrary.frontend.pages;

import static org.alibrary.frontend.pages.IsbnEingabePage.ISBN_PARAMETER;

import org.alibrary.backend.dao.BuchDao;
import org.alibrary.backend.model.Buch;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class BuchAnzeigePage extends WebPage {
	
	static final String ISBN_LABEL_ID = "isbnLabel";
	static final String ISBN_AUSGABE_ID = "isbnAusgabe";
	static final String AUTHOR_LABEL_ID = "authorLabel";
	static final String AUTHOR_AUSGABE_ID = "authorAusgabe";
	static final String TITEL_LABEL_ID = "titelLabel";
	static final String TITEL_AUSGABE_ID = "titelAusgabe";
	static final String SAVE_FORM_ID = "saveForm";
	
	@SpringBean
	private BuchDao buchDao;
	
	@SuppressWarnings("serial")
	public BuchAnzeigePage(PageParameters params) {
		super(params);
		final IModel<String> isbn = new Model<String>(params.getString(ISBN_PARAMETER));
		Label isbnAusgabe = new Label(ISBN_AUSGABE_ID, isbn);
		Label isbnLabel = new Label(ISBN_LABEL_ID, "ISBN:");
		Label authorLabel = new Label(AUTHOR_LABEL_ID, "Author:");
		Label authorAusgabe = new Label(AUTHOR_AUSGABE_ID, "irgendwer");
		Label titelLabel = new Label(TITEL_LABEL_ID, "Titel:");
		Label titelAusgabe = new Label(TITEL_AUSGABE_ID, "irgendwie");
		Form<Buch> saveForm = new Form<Buch>(SAVE_FORM_ID){
			@Override
			protected void onSubmit() {
				Buch buch = new Buch();
				buch.setISBN(isbn.getObject());
				buchDao.speichereBuch(buch );
			}
		};
		add(isbnLabel);
		add(isbnAusgabe);
		add(authorLabel);
		add(authorAusgabe);
		add(titelLabel);
		add(titelAusgabe);
		add(saveForm);
	}
	
}
