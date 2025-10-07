package com.revature.spring.di;

public class SMSService implements MessageService {
    private String message;

    public SMSService() {
        this.message = "This is a constructor injected SMS message.";
    }

    public SMSService(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void printMessage() {
        System.out.println(this.message);
    }
}