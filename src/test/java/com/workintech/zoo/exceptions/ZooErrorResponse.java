package com.workintech.zoo.exceptions;

public class ZooErrorResponse {
    private int status;
    private String message;
    private long timestamp;

    public ZooErrorResponse() {}

    public ZooErrorResponse(int status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    // getter-setterlar
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}
