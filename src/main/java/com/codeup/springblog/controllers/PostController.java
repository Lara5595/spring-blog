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

//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String createPost(){
//        return "Here is the form to create a post!";
//    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return
                "<h1>Testing Post Map</h1>\n" +
                        "    <form method=\"post\" action=\"/posts/create\">\n" +
                        "        <label for=\"word\">Press button to Test!:</label>\n" +
                        "        <input type=\"text\" name=\"word\" id=\"word\">\n" +
                        "        <button type=\"submit\">Testing PostMapping</button>\n" +
                        "    </form>";
    }




    @PostMapping("/posts/create")
    @ResponseBody
    public String postWithPost(@RequestParam (name = "word") String word) {
        return word;
    }



//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String postWithPost(){
//        return "Create a new post";
//    }




}
