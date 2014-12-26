package org.mele.api;

import org.mele.api.querying.TextQueryResult;
import org.mele.api.querying.UserQuery;

import javax.ws.rs.*;

/**
 * Created by mariodimitrov on 12/17/14.
 */
@Path("query")
public class RequestController {
    @POST
    @Path("text")
    @Consumes("application/json")
    @Produces("text/plain")
    public String processQuery(UserQuery query) {
        System.out.println(query.getQueryText());
        return query.getQueryText().toUpperCase();
    }
  /* public TextQueryResult processTextQuery(UserQuery query) {
        return null;
    }*/

    /*TODO Add file input handling*/

    @GET
    @Path("test")
    @Produces("text/plain")
    public String testApi() {
        return "Hello, Mele";
    }
}
