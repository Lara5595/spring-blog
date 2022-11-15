package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/posts")  We can do RequestMapping if we dont want to add posts to every getMapping

public class PostController {

    @GetMapping("/post")
    @ResponseBody
    public String allPosts() {
        return "Here are all the post: ";
    }


    @GetMapping("/posts/{id}")
    @ResponseBody
    public String onePost(@PathVariable long id){
        return "Here is post number: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "Here is the form to create a post!";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postWithPost(){
        return "Create a new post";
    }




}
