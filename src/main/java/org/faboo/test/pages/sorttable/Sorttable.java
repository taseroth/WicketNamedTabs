package org.faboo.test.pages.sorttable;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: br
 */
public class Sorttable extends WebPage {

    private List<Test> testList = new ArrayList<Test>();

    private String att1;
    private String att2;

    public Sorttable() {

        testList.add(new Test("2", "ccc"));
        testList.add(new Test("1", "aaaa"));
        testList.add(new Test("3", "bbb"));

        final WebMarkupContainer wmc = new WebMarkupContainer("wmc") {
            @Override
            public void renderHead(IHeaderResponse response) {
                response.renderJavaScriptReference(new JavaScriptResourceReference(
                        Sorttable.class,
                        "sorttable.js"));
            }
        };
        wmc.setOutputMarkupId(true);
        add(wmc);

        wmc.add(new ListView<Test>("listview", testList) {

            @Override
            protected void populateItem(ListItem<Test> item) {
                item.add(new Label("att1", item.getModelObject().att1));
                item.add(new Label("att2", item.getModelObject().att2));
            }
        });

        Form<Sorttable> form = new Form<Sorttable>("form", new CompoundPropertyModel<Sorttable>(this));
        form.add(new TextField("att1"));
        form.add(new TextField("att2"));
        AjaxSubmitLink ajaxSubmitLink = new AjaxSubmitLink("add") {
                    @Override
                    protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                        testList.add(new Test(att1, att2));
                        target.add(wmc);
                        target.appendJavaScript("sorttable.init();");
                    }

                    @Override
                    protected void onError(AjaxRequestTarget target, Form<?> form) {

                    }
        };
        form.add(ajaxSubmitLink);
        add(form);
    }

    public String getAtt1() {
        return att1;
    }

    public void setAtt1(String att1) {
        this.att1 = att1;
    }

    public String getAtt2() {
        return att2;
    }

    public void setAtt2(String att2) {
        this.att2 = att2;
    }


    class Test implements Serializable {

        private String att1;
        private String att2;

        Test(String att1, String att2) {
            this.att1 = att1;
            this.att2 = att2;
        }

        public String getAtt1() {
            return att1;
        }

        public void setAtt1(String att1) {
            this.att1 = att1;
        }

        public String getAtt2() {
            return att2;
        }

        public void setAtt2(String att2) {
            this.att2 = att2;
        }
    }
}
