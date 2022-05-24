package com.example.helloworld.models;

import java.util.List;

public class Errors {
    private List<String> name;
    private List<String> email;
    private List<String> password;
    private List<String> conf_password;

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

    public List<String> getConf_password() {
        return conf_password;
    }

    public void setConf_password(List<String> conf_password) {
        this.conf_password = conf_password;
    }
}
