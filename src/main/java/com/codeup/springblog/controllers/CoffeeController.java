package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Coffee;
import com.codeup.springblog.repositories.CoffeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Controller
@RequestMapping("/coffee")
public class CoffeeController {

//    We are creating a coffee repo and constructor from the coffee repo instance class
    private final CoffeeRepository coffeeDao;

    public CoffeeController(CoffeeRepository coffeeDao){
        this.coffeeDao = coffeeDao;
    }

    @GetMapping
    public String coffee(){
        return "coffee"; // <- This is our coffee.html
    }

    @GetMapping("/{roast}")
    public String roast(@PathVariable String roast, Model model){
//        Generating and empty coffee object
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

    // This creates a new page that shows the form
    @GetMapping("/new")
    public String addCoffeeForm(){
        return "create-coffee";
    }
//    This is going to captures the parameters that are being send from the form
    @PostMapping("/new")
    public String addCoffee(@RequestParam(name = "roast") String roast, @RequestParam(name = "origin")String origin, @RequestParam(name = "brand")String brand){
        Coffee coffee = new Coffee(roast,origin,brand);
        coffeeDao.save(coffee);
        return "redirect:/coffee/all-coffees";
    }

//    This gets all our coffees for all coffees.html
    @GetMapping("/all-coffees")
    public String allCoffees(Model model){
        List<Coffee> coffees = coffeeDao.findAll();
        model.addAttribute("coffees", coffees);
        return "all-coffees";
    }



    @PostMapping
    public String signUp(@RequestParam(name="email") String email, Model model){
        model.addAttribute("email", email);
        return "coffee";
    }

}
