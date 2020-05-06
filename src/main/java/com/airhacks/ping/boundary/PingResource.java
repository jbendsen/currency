package com.airhacks.ping.boundary;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Path("ping")
public class PingResource {

       
    @GET
    public String ping() {
        return "Hello from wildfly 19 running on docker!";
    }

}
