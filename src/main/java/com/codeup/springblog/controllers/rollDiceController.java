package com.codeup.springblog.controllers;

import com.codeup.springblog.models.rollDice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/roll-dice")
public class rollDiceController {

    @GetMapping
    public String launchPage(){
        return "roll-dice";
    }

    @GetMapping("/{num}")
    @ResponseBody
    public String rollDice(@PathVariable int num, Model model){
        rollDice select = new rollDice(rollDice.rollNumber(), num);
        select.setNumber(select.rollNumber());
        model.addAttribute("select", select);
        if (select.getNumber() == num){
//            System.out.println(select.getNumber());
            return "You Won";
        } else {
            return "You Loss";
        }

    }


}
