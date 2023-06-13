package com.example.yuan.mytest.entity;

public class User {
    public static String password ="111111";
    public static String name;
    public static String number;
    public static Boolean sex;

    public User(String password, String name, String number) {
        this.password = password;
        this.name = name;
        this.number = number;
    }

    public User() {
    }
}
