package com.example.helloworld.models;

import java.util.List;

public class Errors {
    private List<String> name = null;
    private List<String> email = null;
    private List<String> password = null;
    private List<String> confPassword = null;

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public List<String> getPassword() {
        return password;
    }

    public void setPassword(List<String> password) {
        this.password = password;
    }

    public List<String> getConfPassword() {
        return confPassword;
    }

    public void setConfPassword(List<String> confPassword) {
        this.confPassword = confPassword;
    }
}
