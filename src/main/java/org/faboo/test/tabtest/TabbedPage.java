package org.faboo.test.tabtest;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.*;
import org.faboo.test.tabtest.tabs.APanel;

import java.util.ArrayList;
import java.util.List;

/**
 * User: br
 */
public class TabbedPage extends WebPage {

    private final String selectedTab;

    public TabbedPage(PageParameters params) {

        System.out.println("namedParams=" + params.getNamedKeys());
        StringValue tab = params.get("tab");
        System.out.println("tab=" + tab);
        selectedTab = tab.toString();

    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        List<AbstractNamedTab> tabs = new ArrayList<AbstractNamedTab>();
        tabs.add(new AbstractNamedTab(Model.of("empty Tab"), Model.of("T1")) {
            @Override
            public WebMarkupContainer getPanel(String panelId) {
                return new EmptyPanel(panelId);
            }
        });
        tabs.add(new AbstractNamedTab(Model.of("tab 2"), Model.of("T2")) {
            @Override
            public WebMarkupContainer getPanel(String panelId) {
                return new APanel(panelId);
            }
        });

        NamedTabbedPanel tabsPanel = new NamedTabbedPanel("tabs", tabs);
        add(tabsPanel);

        if(selectedTab != null) tabsPanel.setSelectedTab(selectedTab);

    }
}
