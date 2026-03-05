package com.priacc.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

public class ErrorMessage {
    private String message;
    private Date timeStamp;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorMessage(String message, Date timeStamp, String status) {
        this.message = message;
        this.timeStamp = timeStamp;
        this.status = status;
    }

    public ErrorMessage() {
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "message='" + message + '\'' +
                ", timeStamp=" + timeStamp +
                ", status='" + status + '\'' +
                '}';
    }
}
