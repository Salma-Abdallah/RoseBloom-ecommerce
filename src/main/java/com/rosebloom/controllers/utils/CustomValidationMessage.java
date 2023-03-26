package com.rosebloom.controllers.utils;

import java.io.Serializable;

public class CustomValidationMessage implements Serializable {


    private Boolean success;
    private String message;

    public CustomValidationMessage(Boolean success, String message){
        this.success = success;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "CustomValidationMessage{" +
                "success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
