package com.example.myapplication.domain;

import com.example.myapplication.InvalidDataException;
import com.example.myapplication.util.UserInfoUtil;

/**
 * ManagementUser is responsible for processing data of managementUsers.
 */

public class ManagementUser extends User {
    String email;
    String username;
    String password;
    String description;
    int id;

    public ManagementUser(String email, String username, String password, String description, int id){
        this.email = email;
        this.username = username;
        this.password = password;
        this.description = description;
        this.id = id;
    }

    public String getMail() {
        return email;
    }

    public void setMail(String email) throws InvalidDataException {
        if (email.isEmpty()) {
            throw new InvalidDataException("Invalid email");
        }
        if (!UserInfoUtil.isEmail(email)) {
            throw new InvalidDataException("Invalid email format");
        }
        this.email = email;
    }

    public String getUserName(){
        return username;
    }

    public void setUserName(String name) throws InvalidDataException{
        if (name.isEmpty()) {
            throw new InvalidDataException("Invalid name");
        }
        username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InvalidDataException{
        if (password.isEmpty()) {
            throw new InvalidDataException("Invalid password");
        }
        this.password = com.example.myapplication.util.PasswordProtector.md5(password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
