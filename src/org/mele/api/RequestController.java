package org.mele.api;

import com.box.sdk.BoxAPIConnection;
import com.box.sdk.BoxFolder;
import com.sun.jersey.multipart.FormDataParam;
import org.junit.Test;
import org.mele.api.querying.ResponseStatus;
import org.mele.api.querying.ResponseStatusCode;
import org.mele.api.querying.TextQueryResult;
import org.mele.api.querying.UserQuery;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.sun.jersey.core.header.FormDataContentDisposition;

/**
 * Created by mariodimitrov on 12/17/14.
 */
@Path("/query")
public class RequestController {
    @POST
    @Path("/text")
    @Consumes("application/json")
    @Produces("application/json")
    public TextQueryResult processQuery(UserQuery query) {
        System.out.println(query.getQueryText());
        ResponseStatus status = new ResponseStatus(ResponseStatusCode.SUCCESS);

        List<String> queryResult = new ArrayList<>();
        queryResult.add("hello");
        Date date = new Date();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String producedTime = dateFormat.format(date);
        TextQueryResult result = new TextQueryResult(queryResult,
                producedTime, status, query.getQueryText());
        return result;
    }


    /*TODO Add file input handling*/

    @GET
    @Path("/test")
    @Produces("text/plain")
    public String testApi() {
        return "Hello, Mele";
    }

/*
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
        String API_KEY = "v8w1s1l9zspdls9906pjxj3hxowe9b4v";
        BoxAPIConnection api = new BoxAPIConnection(API_KEY);
        BoxFolder rootFolder = BoxFolder.getRootFolder(api);
        FileInputStream stream = null;
        try {
            stream = new FileInputStream("My File.txt");
            rootFolder.uploadFile(stream, "My File.txt");
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Response.status(200).entity(output).build();

    }
*/
}
