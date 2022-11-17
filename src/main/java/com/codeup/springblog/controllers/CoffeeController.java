package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Coffee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/coffee")
public class CoffeeController {

    @GetMapping
    public String coffee(){
        return "coffee"; // <- This is our coffee.html
    }

    @GetMapping("/{roast}")
    public String roast(@PathVariable String roast, Model model){
//        Generating and empty coffee ojbject
        Coffee selection = new Coffee(roast, "Cool Beans");
        Coffee selection2 = new Coffee(roast, "Coffee Bros");
//        Using the coffee setter
        selection.setRoast(roast);;
//        Using origin from coffee
        selection.setOrigin("Ethiopia");
        selection2.setOrigin("Vietnam");
        List<Coffee> selections = new ArrayList<>(List.of(selection,selection2));
//        Model makes the information available to the view
        model.addAttribute("selections", selections);
        return "coffee";
    }


    @PostMapping
    public String signUp(@RequestParam(name="email") String email, Model model){
        model.addAttribute("email", email);
        return "coffee";
    }

}



// Lecture is on another branch