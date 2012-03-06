package org.faboo.test.pages.open.stringdatemodel;

import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import java.util.Date;

/**
 * User: br
 */
public class StringDateModelTestPage extends WebPage {

    Date date;
    String dateString;

    public StringDateModelTestPage() {

        setDefaultModel(new CompoundPropertyModel<StringDateModelTestPage>(this));

        final Form<StringDateModelTestPage> form = new Form<StringDateModelTestPage>("form");

        add(form);

        form.add(new SubmitLink("submit") {

            @Override
            public void onSubmit() {
                super.onSubmit();
                System.out.println("date: " + date);
                System.out.println("dateString: " + dateString);
            }
        });

        DateTextField dateTextField = new DateTextField("date");
        dateTextField.add(new DatePicker());
        form.add(dateTextField);

        DateTextField stringDateField = new DateTextField("dateString"
                , new StringDateModel(new PropertyModel<String>(StringDateModelTestPage.this, "dateString"))
                ,"yyyy-MM-dd");

        stringDateField.add(new DatePicker());
        form.add(stringDateField);

    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
