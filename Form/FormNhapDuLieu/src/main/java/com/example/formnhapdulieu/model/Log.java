package com.example.formnhapdulieu.model;

import java.io.Serializable;

public class Log implements Serializable {
    public static final String INSERT = "INSERT";
    public static final String UPDATE = "UPDATE";
    public static final String DELETE = "DELETE";
    public static final String LOGIN_SERVICE = "LOGIN";
    public static final String REGISTER_SERVICE = "REGISTER";

    // log levels
    public static final String LOG_LVL_INFO = "INFO";
    public static final String LOG_LVL_WARN = "WARN";
    public static final String LOG_LVL_ALERT = "ALERT";

    int id;
    String action;
    String level;
    String username;
    String ip;
    String value;
    String time;

    public Log(String action, String level, String username, String ip, String value) {
        this.action = action;
        this.level = level;
        this.username = username;
        this.ip = ip;
        this.value = value;
    }

    public Log(){

    }

    public Log(int id, String action, String level, String username,  String time, String ip, String value) {
        this.id = id;
        this.action = action;
        this.level = level;
        this.username = username;
        this.ip = ip;
        this.value = value;
        this.time = time;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public void setUser(String user) {
        this.username = user;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
