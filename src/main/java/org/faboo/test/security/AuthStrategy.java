package org.faboo.test.security;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.authorization.Action;
import org.apache.wicket.authorization.IAuthorizationStrategy;
import org.apache.wicket.authorization.IUnauthorizedComponentInstantiationListener;
import org.apache.wicket.request.component.IRequestableComponent;
import org.faboo.test.pages.open.LoginPage;
import org.faboo.test.pages.secured.SecureBasePage;

/**
 * User: br
 */
public class AuthStrategy implements IAuthorizationStrategy,
        IUnauthorizedComponentInstantiationListener {


    public <T extends IRequestableComponent> boolean isInstantiationAuthorized(Class<T> componentClass) {

        if (!Page.class.isAssignableFrom(componentClass)) {
            // only check Pages
            return true;
        }

        if(SecureBasePage.class.isAssignableFrom(componentClass) && !DemoSession.get().isSignedIn()) {
            throw new RestartResponseAtInterceptPageException(LoginPage.class);
        }

        return true;
    }

    public boolean isActionAuthorized(Component component, Action action) {
        return true;
    }

    public void onUnauthorizedInstantiation(Component component) {
        if(SecureBasePage.class.isAssignableFrom(component.getClass())) {
        			throw new RestartResponseAtInterceptPageException(LoginPage.class);
        		}
    }
}
