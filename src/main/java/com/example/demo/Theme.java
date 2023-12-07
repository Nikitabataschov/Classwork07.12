package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Theme {

    String name;

    List<String> comments;

    public Theme(String name) {
        this.name = name;
        comments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void newComment(String comment){
        this.comments.add(comment);
    }

    public void deleteComment(int id){
        this.comments.remove(id);
    }

    public void changeComment(int id, String s){
        this.comments.set(id, s);
    }

    public List<String> getComments() {
        return comments;
    }
}
