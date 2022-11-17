package com.codeup.springblog.controllers;

import com.codeup.springblog.models.RollDice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roll-dice")
public class RollDiceController {

    @GetMapping
    public String home(){
        return "rollDice";
    }

    @GetMapping("/{num}")
    public String rollDice(@PathVariable int num, Model model){
        RollDice dice = new RollDice();
        model.addAttribute("randomNum", dice.randomNum());
        model.addAttribute("numberChosen", num);

        return "rollDice";

    }




}
