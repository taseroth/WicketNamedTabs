package org.faboo.test.tabtest.tabs;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

/**
 * User: br
 */
public class APanel extends Panel {

    public APanel(String id) {
        super(id);

       // setRenderBodyOnly(true);

        add(new Label("time", Model.of(System.currentTimeMillis())));
    }
}
