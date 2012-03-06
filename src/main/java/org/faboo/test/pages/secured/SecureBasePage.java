package org.faboo.test.pages.secured;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.faboo.test.security.DemoSession;

/**
 * User: br
 */
public class SecureBasePage extends WebPage {

    public SecureBasePage() {

        add(new Label("username", Model.of(DemoSession.get().getUserName())));

    }
}
