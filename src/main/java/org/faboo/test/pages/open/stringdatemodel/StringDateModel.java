package org.faboo.test.pages.open.stringdatemodel;

import org.apache.wicket.model.IModel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringDateModel implements IModel<Date>
{
   private static final long serialVersionUID = 1L;

   private IModel<String> model;
   DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

   public StringDateModel(IModel<String> model) {
      this.model = model;
   }

   public void detach() {
      if(model != null) {
         model.detach();
      }
   }

   public Date getObject() {
      if(model == null || model.getObject() == null || model.getObject().length() == 0) return null;
      String m = model.getObject();

      try
      {
         return df.parse(m);
      }
      catch (ParseException e)
      {
         System.out.println(m);
         System.out.println("oh je");
         return null;
      }
   }

   public void setObject(Date date) {
      if(date == null) {
         this.model.setObject(null);
         return;
      }

      model.setObject( df.format(date) );
   }
}
