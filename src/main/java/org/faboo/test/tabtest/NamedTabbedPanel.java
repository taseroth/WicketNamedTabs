package org.faboo.test.tabtest;

import org.apache.wicket.extensions.markup.html.tabs.TabbedPanel;

import java.util.List;

/**
 * User: br
 */
public class NamedTabbedPanel extends TabbedPanel {

    /**
     * Constructor
     *
     * @param id   component id
     * @param tabs list of ITab objects used to represent tabs
     */
    public NamedTabbedPanel(String id, List<? extends AbstractNamedTab> tabs) {
        super(id, tabs);
    }

    public NamedTabbedPanel setSelectedTab(final String name) throws IllegalArgumentException {

        List<AbstractNamedTab> namedTabs = (List<AbstractNamedTab>) getTabs();

        int index = -1;

        for(int i = 0 ; i <= namedTabs.size(); i++) {
            if(namedTabs.get(i).getName().getObject().equalsIgnoreCase(name)) {
                index = i;
                break;
            }
        }

        if(index == -1 ) throw new IllegalArgumentException("provided tab name <" + name +"< does not exist");

        setSelectedTab(index);

        return this;
    }
}
