package org.faboo.test.pages.DataTable;

import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: br
 */
public class DTTestPage extends WebPage {

    public DTTestPage() {

        List<Person> personList = new ArrayList<Person>(Arrays.asList(
                        new Person("name 1", "vorname 1")
                        , new Person("name 2", "vorname 2")
                        , new Person("name 3", "vorname 3")
                        , new Person("name 4", "vorname 4")
                ));

        List<IColumn<Person>> columns = new ArrayList<IColumn<Person>>();

        columns.add(new PropertyColumn<Person>(new Model<String>("Vorname"), "vorname"));
        columns.add(new PropertyColumn<Person>(new Model<String>("Nachname"), "name"));
        columns.add(new AbstractColumn<Person>(Model.of("bla")) {
            public void populateItem(Item<ICellPopulator<Person>> cellItem, String componentId
                    , IModel<Person> rowModel) {

            }
        });

        DataTable table = new DataTable<Person>("datatable", columns
                 , new ListDataProvider<Person>(personList)
                 , 10) {
             @Override
             protected Item<Person> newRowItem(String id, int index, IModel<Person> personIModel) {
                 System.out.println("newRowItem() id=" + id + " index=" + index + " person=" + personIModel.getObject());

                 Item<Person> item = super.newRowItem(id, index, personIModel);
                 System.out.println("\t item=" + item);
                 return item;
             }
        };
        add(table);


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
