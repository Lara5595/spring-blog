package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {


//    Adding
    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public double add(@PathVariable double num1, @PathVariable double num2){
        return num1 + num2;
    }


// Subtracting

    @GetMapping("/sub/{num3}/from/{num4}")
    @ResponseBody
    public int sub(@PathVariable int num3, @PathVariable int num4){
        return num3 - num4;
    }

// Multiply

    @GetMapping("/multiply/{num5}/and/{num6}")
    @ResponseBody
    public int multiply(@PathVariable int num5, @PathVariable int num6){
        return num5 * num6;
    }


//    Divide
    @GetMapping("/divide/{num7}/and/{num8}")
    @ResponseBody
    public int divide(@PathVariable int num7, @PathVariable int num8){
        return num7 / num8;
    }



}





