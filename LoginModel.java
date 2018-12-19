package com.example.shri.weight_and_watch;

import android.support.annotation.NonNull;

public class LoginModel {
    private String id,name,email,password ;
    private String contact_numbers;


    LoginModel() {

    }

    String getNames() {
        return name;
    }

    public String getId() {
        return id;
    }

    String getContactNumbers() {
        return contact_numbers;
    }

    String getEmail() {
        return email;
    }

    String getPassword() {
        return password;
    }


    public void setId(String id) {
        this.id = id;
    }

    void setEmail(String email) {
        this.email= email;
    }

    void setPassword(String password) {
        this.password = password;
    }

    void setContactNames(String name) {
        this.name = name;
    }

    void setContactNumbers(String contact_numbers) {
        this.contact_numbers = contact_numbers;
    }


    @NonNull
    public String toString() {
        return "ID: " + id + " Email: " + email + " Contact Names: " + name + " Contact Numbers: " + contact_numbers;

    }

}