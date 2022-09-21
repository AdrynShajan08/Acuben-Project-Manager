package com.example.projectmanager;

import java.util.ArrayList;

public class project {

    public static ArrayList<project> projectArrayList = new ArrayList<>();
    private int id;
    private String title;
    private String description;
    private String subject;
    private String duedate;

    public project(int id, String title, String description, String subject, String duedate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.subject = subject;
        this.duedate = duedate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title;  }
}
