package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import com.codeup.springblog.services.Utils;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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

    private final EmailService emailService;


    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    //    Home Page
    @GetMapping()
    public String home(){
        return "posts/homePage";
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
//        code for the setting user is in utils
        User user = Utils.currentUser();
        post.setUser(user);
        postDao.save(post);
        emailService.prepareAndSend(user, post.getTitle(), post.getBody());
        return "redirect:/posts/create/all-post";
    }



//    This lets you view all your post
    @GetMapping("/create/all-post")
    public String allPostsBlog(Model model){

        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/allPost";
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
        User user = Utils.currentUser();
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts/create/all-post";
    }



//    Delete button




@GetMapping("/{id}/delete")
public String deletePost( Model model, @PathVariable long id){
    Post post = postDao.findById(id);
    model.addAttribute("post", new Post());
    postDao.delete(post);
    return "redirect:/posts/create/all-post";

}


// Profile page
//@GetMapping("/profile")
//public String profile(Model model){
//    User user = userDao.findById(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
//        Post post = new Post();
//        long currentUserId = (((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
//        post.getBody();
//
//    return "posts/profile";
//}




} // End of PostController





