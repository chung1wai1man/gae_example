package com.cjemison.objectify;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by cjemison on 10/17/14.
 */
@Entity
public class HelloWorldEO
{
    @Id
    public Long id;
    public String greeting="";

    public HelloWorldEO() {
    }

    public HelloWorldEO(String greeting) {
        this.greeting = greeting;
    }

}
