package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


//@Controller: defines that our class is a controller
//@GetMapping: defines a method that should be invoked when a GET request is received for the specified URI
//@ResponseBody: tells Spring that whatever is returned from this method should be the body of our response


@Controller
public class HomeController {


    @GetMapping("/")
    @ResponseBody
    public String landingPage(){
        return "This is the landing page";
    }



//    This adds a number by typing in the url localhost:8080/increment/2
    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }



}


