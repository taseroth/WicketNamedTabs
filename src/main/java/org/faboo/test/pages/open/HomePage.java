package org.faboo.test.pages.open;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.faboo.test.pages.DataTable.DTTestPage;
import org.faboo.test.pages.open.stringdatemodel.StringDateModelTestPage;
import org.faboo.test.pages.secured.SecurePage1;
import org.faboo.test.pages.sorttable.Sorttable;
import org.faboo.test.radio.RadioListPage;
import org.faboo.test.radio.RadioTestPage;
import org.faboo.test.tabtest.TabbedPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
		add(new Link<Void>("demo1") {
            @Override
            public void onClick() {
                setResponsePage(SecurePage1.class);
            }
        });

        add(new Link<TabbedPage>("tabbed") {

            @Override
            public void onClick() {
                setResponsePage(TabbedPage.class);
            }
        });
        add(new Link<TabbedPage>("tabbed1") {

            @Override
            public void onClick() {
                setResponsePage(TabbedPage.class, new PageParameters("tab=T1"));
            }
        });
        add(new Link<TabbedPage>("tabbed2") {

            @Override
            public void onClick() {
                setResponsePage(TabbedPage.class, new PageParameters("tab=T2"));
            }
        });
        add(new Link<TabbedPage>("tabbed3") {

            @Override
            public void onClick() {
                setResponsePage(TabbedPage.class, new PageParameters("tab=T3"));
            }
        });

        add(new Link<RadioTestPage>("radio") {

            @Override
            public void onClick() {
                setResponsePage(new RadioTestPage());
            }
        });

        add(new Link<RadioListPage>("radioList") {

            @Override
            public void onClick() {
                setResponsePage(new RadioListPage());
            }
        });

        add(new Link<DTTestPage>("datatable") {

            @Override
            public void onClick() {
                setResponsePage(new DTTestPage());
            }
        });

        add(new Link<DTTestPage>("sorttable") {

            @Override
            public void onClick() {
                setResponsePage(new Sorttable());
            }
        });
        add(new Link<StringDateModelTestPage>("stringDateModel") {

            @Override
            public void onClick() {
                setResponsePage(new StringDateModelTestPage());
            }
        });

    }
}
