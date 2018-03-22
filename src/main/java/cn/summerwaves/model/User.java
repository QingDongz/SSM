package cn.summerwaves.model;

import com.google.gson.annotations.SerializedName;

public class User {
    private double id;

    private String username;

    private String password;

    private double age;

    private double total = age + id;

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}