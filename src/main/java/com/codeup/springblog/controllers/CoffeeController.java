package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/coffee")
public class CoffeeController {

    @GetMapping
    public String coffee(){
        return "coffee"; // <- This is our coffee.html
    }

    @GetMapping("/{roast}")
    public String roast(@PathVariable String roast, Model model){
//        Model makes the information available to the view
        model.addAttribute("roast", roast);
        return "coffee";
    }


    @PostMapping
    public String signUp(@RequestParam(name="email") String email, Model model){
        model.addAttribute("email", email);
        return "coffee";
    }

}
