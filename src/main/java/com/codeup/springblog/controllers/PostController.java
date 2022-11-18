package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")

public class PostController {

//    @GetMapping("/post")
//    @ResponseBody
//    public String allPosts() {
//        return "Here are all the post: ";
//    }

    @GetMapping()
    public String allPosts(Model model) {
        Post post1 = new Post(1, "First", "This is my first post!!");
        Post post2 = new Post(2, "Second", "Hey everyone, I'm baaaack!!");
        List<Post> allPosts = new ArrayList<>(List.of(post1, post2));
        model.addAttribute("allPosts", allPosts);
        return "/posts/index";
    }

    @GetMapping("/{id}")
    public String onePost(@PathVariable long id, Model model) {
        Post post1 = new Post(1, "First", "This is my first post!");
        Post post2 = new Post(2, "Second", "Hey everyone, I'm back");
        Post post3 = new Post(3, "Yo", "heye heye heyeee");
        List<Post> allPosts = new ArrayList<>(List.of(post1, post2, post3));
        Post post = null;
        for(Post userPost : allPosts) {
            if(userPost.getId() == id) {
                post = userPost;
            }
        }
        model.addAttribute("post", post);
        return "posts/show";
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
