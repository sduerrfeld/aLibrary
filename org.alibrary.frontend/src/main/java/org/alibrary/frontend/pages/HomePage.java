package org.alibrary.frontend.pages;

import org.alibrary.backend.dao.MessageDao;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	@SpringBean
	private MessageDao messageDao;

	public HomePage() {
		messageDao.saveMessage("Hello World");
		add(new Label("message", messageDao.readMessage()));
	}

}
