package com.example.springapp.letyclone.messages;

public class RegisterRequest {
    public String username;
    public String password;

    public RegisterRequest() {}
    public RegisterRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
