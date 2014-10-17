package com.cjemison.endpoint;

import com.cjemison.objectify.HelloWorldEO;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.response.NotFoundException;
import com.googlecode.objectify.cmd.Query;

import java.util.ArrayList;
import java.util.List;

import static com.cjemison.objectify.OfyService.ofy;


/**
 * Created by cjemison on 10/17/14.
 */
@Api(
        name = "helloworld",
        version = "v1"
)
public class HelloWorldEndPoint
{
    public static List<HelloWorldEO> greetings = new ArrayList<HelloWorldEO>();

    static {
        greetings.add(new HelloWorldEO("hello world!"));
        greetings.add(new HelloWorldEO("goodbye world!"));
        ofy().save().entities(greetings).now();
    }

    @ApiMethod(name = "add", httpMethod = "post")
    public HelloWorldEO addGreeting(HelloWorldEO helloWorldEO) throws NotFoundException {
        ofy().save().entity(helloWorldEO).now();
        return helloWorldEO;
    }


    @ApiMethod(name = "find", httpMethod = "post")
    public HelloWorldEO getGreeting(@Named("id") Integer id) throws NotFoundException {

        HelloWorldEO eo = ofy().load().type(HelloWorldEO.class).filter("id", id).first().now();
        if(eo==null)
        {
            throw new NotFoundException(String.format("No object found with id: %s", id.toString()));
        }
        return eo;
    }

    @ApiMethod(name = "list", httpMethod = "get")
    public List<HelloWorldEO> listGreeting() {
        return ofy().load().type(HelloWorldEO.class).list();
    }

}
