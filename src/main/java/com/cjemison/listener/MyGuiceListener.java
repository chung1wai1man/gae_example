package com.cjemison.listener;

import com.cjemison.module.MyGuiceModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Created by cjemison on 10/17/14.
 */
public class MyGuiceListener extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new MyGuiceModule());
    }
}
