package com.dao.model;

/**
 * Created by ganluting on 17/1/9.
 */
public class WiselyResponse {
    private String responseMessage;

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public WiselyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public WiselyResponse() {}
}
