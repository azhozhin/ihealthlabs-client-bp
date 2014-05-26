package com.ihealthlabs.client.bp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class ResponseBase {
    @JsonProperty("Error")
    private String error;

    @JsonProperty("ErrorCode")
    private int errorCode;

    @JsonProperty("ErrorDescription")
    private String errorDescription;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
