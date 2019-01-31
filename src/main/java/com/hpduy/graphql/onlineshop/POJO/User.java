package com.hpduy.graphql.onlineshop.POJO;

public class User {
    private String id;
    private String username;
    private String password;
    private String email;
    private String fullname;
    private String phone;
    private String address;
    private int role;

    public User(String id, String username, String password, String email, String fullname, String phone, String address, int role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }

    public User( String username, String password, String email, String fullname, String phone, String address, int role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }
    public User(String id, String username, String password, String fullname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = "";
        this.fullname = fullname;
        this.phone = "";
        this.address = "";
        this.role = 0;
    }
    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = "";
        this.fullname = "";
        this.phone = "";
        this.address = "";
        this.role = 0;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setId(String id) {
        this.id = id;
    }
}
