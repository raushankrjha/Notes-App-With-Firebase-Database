package com.example.todoappwithfirease.Model;

public class Listdata {

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
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String id;
    public String title;
    public String desc;

    public Listdata() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Listdata(String id,String title, String desc) {
        this.id=id;
        this.title = title;
        this.desc = desc;

    }

}