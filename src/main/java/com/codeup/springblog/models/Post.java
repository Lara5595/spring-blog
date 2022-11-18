package com.codeup.springblog.models;

public class Post {
//  Instances

    private String title;

    private String body;

// Getters and Setters


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


//    Constructor


    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(){}
}
