package com.revature.spring.ioc;

public class MessageService {
    private String message;

    public MessageService() {
        this.message = "Default Constructor Message";
    }

    public MessageService(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
