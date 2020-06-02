package com.example.person;

public class User {

    private String Name, Id, Email, Username, Phone, Website;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public User(String name, String id, String email, String username, String phone, String website) {
        Name = name;
        Id = id;
        Email = email;
        Username = username;
        Phone = phone;
        Website = website;
    }

    public User() {
    }
}

