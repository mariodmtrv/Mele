package org.mele.api.querying;

import java.util.List;

public class TextQueryResult {

    List<String> queryResult;

    String producedTime;
    ResponseStatus status;
    /**
     * Some queries may be executed with a delay
     */
    String query;

    public TextQueryResult(List<String> queryResult, String producedTime, ResponseStatus status, String query) {
        this.queryResult = queryResult;
        this.producedTime = producedTime;
        this.status = status;
        this.query = query;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<String> getQueryResult() {
        return queryResult;
    }


    public String getProducedTime() {
        return producedTime;
    }

    public void setQueryResult(List<String> queryResult) {
        this.queryResult = queryResult;
    }


    public void setProducedTime(String producedTime) {
        this.producedTime = producedTime;
    }
}