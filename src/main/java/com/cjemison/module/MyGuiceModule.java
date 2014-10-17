package com.cjemison.module;

import com.cjemison.endpoint.HelloWorldEndPoint;
import com.google.api.server.spi.guice.GuiceSystemServiceServletModule;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cjemison on 10/17/14.
 */
public class MyGuiceModule extends GuiceSystemServiceServletModule
{
    @Override
    protected void configureServlets() {
        super.configureServlets();
        Set<Class<?>> serviceClasses = new HashSet<Class<?>>();
        serviceClasses.add(HelloWorldEndPoint.class);
        this.serveGuiceSystemServiceServlet("/_ah/spi/*", serviceClasses);
    }
}
