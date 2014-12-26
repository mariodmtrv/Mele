package org.mele.api.querying;

/**
 * Created by mariodimitrov on 12/17/14.
 */
public class UserQuery {
    String queryText;
    String sessionId;

    public UserQuery(String queryText, String sessionId) {
        this.queryText = queryText;
        this.sessionId = sessionId;
    }

    public UserQuery() {
    }

    public String getQueryText() {
        return queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
