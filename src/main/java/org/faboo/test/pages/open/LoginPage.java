package org.faboo.test.pages.open;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.faboo.test.pages.secured.SecureBasePage;
import org.faboo.test.security.DemoSession;

/**
 * User: br
 */
public class LoginPage extends WebPage {

    private String username;
    private String password;

    public LoginPage() {

        add(new FeedbackPanel("feedbackpanel"));
        Form<LoginPage> form = new Form<LoginPage>("loginform", new CompoundPropertyModel<LoginPage>(this)) {
            @Override
            protected void onSubmit() {
                if(DemoSession.get().authenticate(username,password)) {
                    if(! continueToOriginalDestination()) {
                        setResponsePage(SecureBasePage.class);
                    }

                } else {
                    error("username and password must be equal");
                }
            }
        };
        form.add(new TextField<String>("username").setRequired(true));
        form.add(new PasswordTextField("password").setRequired(true));
        form.add(new SubmitLink("submit"));
        add(form);
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
