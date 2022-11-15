package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/post")
    @ResponseBody
    public String post() {
        return "posts index page";
    }


    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postWithID(@PathVariable String id){
        return "View an " + id + " post";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postWithCreate(){
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postWithPost(){
        return "Create a new post";
    }




}
