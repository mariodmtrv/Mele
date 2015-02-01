package org.mele.api;

import org.mele.api.querying.TextQueryResult;
import org.mele.api.querying.UserQuery;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

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


    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) {

        String uploadedFileLocation = "d://uploaded/" + fileDetail.getFileName();

        // save it
        // writeToFile(uploadedInputStream, uploadedFileLocation);

        String output = "File uploaded to : " + uploadedFileLocation;

        return Response.status(200).entity(output).build();

    }

}
