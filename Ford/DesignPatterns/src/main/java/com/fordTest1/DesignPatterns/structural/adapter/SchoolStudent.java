package com.fordTest1.DesignPatterns.structural.adapter;

public class SchoolStudent {

    private String firstname;
    private String lastname;
    private String email;

    public SchoolStudent(String name, String surname, String email) {
        this.firstname = name;
        this.lastname = surname;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }
}
