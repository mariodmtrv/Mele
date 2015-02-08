package org.mele.api.querying;

/**
 * Created by mariodimitrov on 12/17/14.
 */
public class ResponseStatus {
    String sessionId;
    ResponseStatusCode responseStatus;
    String queryMessage;

    public ResponseStatus(ResponseStatusCode responseStatus, String queryMessage) {
        this.responseStatus = responseStatus;
        this.queryMessage = queryMessage;
    }

    public ResponseStatus(ResponseStatusCode responseStatus) {
        this.responseStatus = responseStatus;
        this.queryMessage = "";
    }

    public ResponseStatusCode getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatusCode responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getQueryMessage() {
        return queryMessage;
    }

    public void setQueryMessage(String queryMessage) {
        this.queryMessage = queryMessage;
    }
}
