package com.app.nace.exception;

public class CustomErrorMessage {
    private String errorMessage;
    private String details;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public CustomErrorMessage(String errorMessage, String details) {
        this.errorMessage = errorMessage;
        this.details = details;
    }
}
