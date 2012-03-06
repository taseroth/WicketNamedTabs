package org.faboo.test.security;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

/**
 * User: br
 */
public class DemoSession extends WebSession {

    private String userName = null;


    public DemoSession(Request request) {
        super(request);
    }


    @Override
    public boolean authenticate(String username, String password) {
        if (username != null && username.length() > 0
                && password != null && password.length() > 0
                && username.equals(password)) {
            this.userName = username;
            return true;
        }
        else return false;
    }

    public static DemoSession get() {
        return (DemoSession)Session.get();
    }

    public String getUserName() {
        return userName;
    }

    public boolean isSignedIn() {
        return userName != null;
    }

}
