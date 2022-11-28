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



    @GetMapping("/creates")
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




    @PostMapping("/creates")
    @ResponseBody
    public String postWithPost(@RequestParam (name = "word") String word) {
        return word;
    }


//    Assigment Repositories and JPA

//    Takes me to the create.html
    @GetMapping("/create")
    public String homepageBlog(){
        return "posts/create";
    }

//    Creates new post
    @PostMapping("/create/new")
//    This is the one that sends you to the all-post
    public  String createPost(@RequestParam(name = "body") String body, @RequestParam(name = "title") String title){
        Post post = new Post(body,title);
        postDao.save(post);
        return "redirect:/posts/create/all-post";
    }

////    This is rick roll
//        @PostMapping("/create/new")
//        public  String createPost(@RequestParam(name = "body") String body, @RequestParam(name = "title") String title){
//        Post post = new Post(body,title);
//        postDao.save(post);
//        return "redirect:https://www.youtube.com/watch?v=dQw4w9WgXcQ";
//    }

    @GetMapping("/create/all-post")
    public String allPostsBlog(Model model){
        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/allPost";
    }


    //    relationships exercise


    @GetMapping("/users")
    public String usersHome(){
        return "/posts/users";
    }

    @PostMapping("/users")
    public String insertSupplier(@RequestParam(name = "email")String email,@RequestParam(name = "username")String username,@RequestParam(name = "password")String password) {
        User user = new User(email,username,password);
        userDao.save(user);
        return "redirect:/posts/users";
    }



//    @PostMapping("/new")
//    public String addCoffee(@RequestParam(name="roast") String roast, @RequestParam(name="origin") String origin, @RequestParam(name="brand") String brand, @RequestParam(name="supplier") long id){
//        User users = userDao.findById(id);
//        User user = new User(email, username, password, supplier);
//        coffeeDao.save(coffee);
//        return "redirect:/coffee/all-coffees";
//    }

} // End of PostController


