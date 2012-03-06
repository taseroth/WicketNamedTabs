package org.faboo.test.tabtest;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.html.WebMarkupContainer;

import java.util.List;

/**
 * User: br
 */
public class MyAjaxTabbedPanel extends AjaxTabbedPanel {

    private final WebMarkupContainer contentContainer;

    public MyAjaxTabbedPanel(String id, List<ITab> tabs, WebMarkupContainer contentContainer) {
        super(id, tabs);
        this.contentContainer = contentContainer;
    }

    @Override
    public MarkupContainer addOrReplace(Component... childs) {
        for (Component child : childs)
        		{
        			if (child == null)
        			{
        				throw new IllegalArgumentException("argument child must be not null");
        			}

        			checkHierarchyChange(child);

        			if (get(child.getId()) == null)
        			{
        				contentContainer.add(child);
        			}
        			else
        			{
        				contentContainer.replace(child);
        			}
        		}

        return this;
    }
}
