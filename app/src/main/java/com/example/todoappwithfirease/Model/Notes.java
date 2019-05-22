package com.example.todoappwithfirease.Model;

public class Notes {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String title;
    public String desc;

    public Notes() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Notes(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

}