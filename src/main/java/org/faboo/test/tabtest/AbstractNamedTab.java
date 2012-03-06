package org.faboo.test.tabtest;

import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.model.IModel;

/**
 * User: br
 */
public abstract class AbstractNamedTab extends AbstractTab {


    private final IModel<String> name;

    public AbstractNamedTab(IModel<String> title, IModel<String> name) {
        super(title);
        this.name = name;
    }

    public IModel<String> getName() {
        return name;
    }
}
