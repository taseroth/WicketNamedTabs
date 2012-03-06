package org.faboo.test.radio;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: br
 */
public class RadioListPage extends WebPage {

    private Person selected;

    public RadioListPage() {

        Form<RadioListPage> form = new Form<RadioListPage>("form"
                , new CompoundPropertyModel<RadioListPage>(this)) {
            @Override
            protected void onSubmit() {
                super.onSubmit();
                System.out.println("selected:" + selected);
            }
        };
        add(form);

        final RadioGroup<Person> personRadioGroup = new RadioGroup<Person>("selected");

        ListView<Person> personListView = new ListView<Person>("persons",
                new ArrayList<Person>(Arrays.asList(
                                        new Person("name 1", "vorname 1")
                                        , new Person("name 2", "vorname 2")
                                        , new Person("name 3", "vorname 3")
                                        , new Person("name 4", "vorname 4")
                                ))
        ) {
            @Override
            protected void populateItem(ListItem<Person> item) {

                item.add(new Label("name", Model.of(item.getModelObject().name)));
                item.add(new Label("vorname", Model.of(item.getModelObject().vorname)));
                item.add(new Radio<Person>("radio", new Model<Person>(item.getModelObject())));
            }
        };
        form.add(personRadioGroup);
        personRadioGroup.add(personListView);

    }




    class Person implements Serializable {

        private final String name;
        private final String vorname;

        Person(String name, String vorname) {
            this.name = name;
            this.vorname = vorname;
        }


        public String getName() {
            return name;
        }

        public String getVorname() {
            return vorname;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", vorname='" + vorname + '\'' +
                    '}';
        }
    }

}
