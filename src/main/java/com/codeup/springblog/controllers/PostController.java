package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")

public class PostController {
    //    We are creating a coffee repo and constructor from the coffee repo instance class

    private final PostRepository postDao;

    private final UserRepository userDao;


    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }


//    Assigment Repositories and JPA

//    Takes me to the create.html which is main page that says Create your post
    @GetMapping("/create")
    public String homepageBlog(Model model){
        List<User>users = userDao.findAll();
        model.addAttribute("users", users);
        model.addAttribute("post", new Post());
        return "posts/create";
    }


    // This lets you add a post i refactor it to form model binding also the html
    @PostMapping("/new")
    public String addPostWithUser(@ModelAttribute Post post){
        postDao.save(post);
        return "redirect:/posts/create/all-post";
    }



//    This lets you view all your post
    @GetMapping("/create/all-post")
    public String allPostsBlog(Model model){
        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/allPost";
    }


    //    relationships exercise


//    This takes you to the page where you can create a user refactor to model binding
    @GetMapping("/users")
    public String usersHome(Model model){
        model.addAttribute("user", new  User());
        return "/posts/users";
    }


    @PostMapping("/users")
    public String insertUser(@ModelAttribute User user) {
        userDao.save(user);
        return "redirect:/posts/users";
    }



//    Edit your post

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable long id){
        Post post = postDao.findById(id);
        model.addAttribute("post", post);
        return "/posts/edit";
    }


    @PostMapping("/{id}/edit")
    public String editPost(@ModelAttribute Post post, @PathVariable long id){
        postDao.save(post);

        return "redirect:/posts/create/all-post";
    }




} // End of PostController





