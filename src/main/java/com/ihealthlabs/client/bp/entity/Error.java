package com.ihealthlabs.client.bp.entity;

public class Error {

    private int errorCode;
    private String error;
    private String errorDescription;

    public Error(int errorCode, String error, String errorDescription) {
        this.errorCode = errorCode;
        this.error = error;
        this.errorDescription = errorDescription;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
