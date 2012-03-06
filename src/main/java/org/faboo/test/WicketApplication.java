package org.faboo.test;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.faboo.test.pages.open.HomePage;
import org.faboo.test.radio.RadioListPage;
import org.faboo.test.security.AuthStrategy;
import org.faboo.test.security.DemoSession;
import org.faboo.test.tabtest.TabbedPage;

/**
 * Application object for your web application.
 */
public class WicketApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<HomePage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

        getSecuritySettings().setAuthorizationStrategy(new AuthStrategy());

        mountPage("tabbedPage", TabbedPage.class);
        mountPage("rg", RadioListPage.class);
	}


    @Override
    public Session newSession(Request request, Response response) {
        return new DemoSession(request);
    }
}
