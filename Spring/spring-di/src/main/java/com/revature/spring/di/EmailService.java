package com.revature.spring.di;

public class EmailService implements MessageService {
    private String email;

    public EmailService() {
        this.email = "This is a constructor injected email message.";
    }

    public EmailService(String email) {
        this.email = email;
    }

    public String getMessage() {
        return this.email;
    }

    @Override
    public void printMessage() {
        System.out.println(getMessage());
    }

    @Override
    public void setMessage(String message) {
        // No implementation needed for EmailService
    }
}
