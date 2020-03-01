package com.example.xulaundryapp;

public class User {
    String TAG = "User.java";
    String fName;
    String lName;
    int xulaId;
    String email;

    public User(String fName, String lName, int xulaId, String email) {
        this.fName = fName;
        this.lName = lName;
        this.xulaId = xulaId;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + fName +  " " + lName + '\'' +
                ", xulaId=" + xulaId +
                ", email='" + email + '\'' +
                '}';
    }
}
