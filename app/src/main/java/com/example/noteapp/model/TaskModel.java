package com.example.noteapp.model;

import java.io.Serializable;

public class TaskModel implements Serializable {
    String title;

    public TaskModel(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
