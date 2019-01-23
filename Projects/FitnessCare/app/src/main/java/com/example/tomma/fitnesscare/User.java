package com.example.tomma.fitnesscare;

import java.io.Serializable;

public class User implements Serializable {
    private String email;
    private String pass;


    public User() {
        this.email = " ";
        this.pass = " ";
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}