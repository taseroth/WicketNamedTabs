package org.faboo.test.radio;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

/**
 * User: br
 */
public class RadioTestPage extends WebPage {


    private String selection;

    public RadioTestPage() {


        Form<RadioTestPage> form = new Form<RadioTestPage>("form") {
            @Override
            protected void onSubmit() {
                super.onSubmit();
                System.out.println("selection:" + selection);
            }
        };
        add(form);

        RadioGroup<RadioTestPage> radioGroup = new RadioGroup<RadioTestPage>("radiochoicegroup"
                , new PropertyModel<RadioTestPage>(this, "selection"));
        form.add(radioGroup);

        radioGroup.add(new Radio<String>("radio1", Model.of("C1")));
        radioGroup.add(new Radio<String>("radio2", Model.of("C2")));
    }


    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }
}
