package com.demoWeb.models;

public class RegisterUser {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public RegisterUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public RegisterUser setPassword(String password) {
        this.password = password;
        return this;
    }
}