package org.mele.api;

import org.mele.api.querying.TextQueryResult;
import org.mele.api.querying.UserQuery;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by mariodimitrov on 12/17/14.
 */
@Path("query")
public class RequestController {
    @Path("text")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public TextQueryResult processTextQuery(UserQuery query) {
        return null;
    }

    /*TODO Add file input handling*/
}
