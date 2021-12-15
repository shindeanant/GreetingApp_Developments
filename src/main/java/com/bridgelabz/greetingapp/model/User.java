package com.bridgelabz.greetingapp.model;

public class User {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        String str = (firstName != null) ?firstName +"" : "";
        str += (lastName != null) ?lastName  : "";
        return str.trim();
    }
}
