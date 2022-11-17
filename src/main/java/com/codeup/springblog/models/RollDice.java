package com.codeup.springblog.models;

public class RollDice {

//    Instances
    final int sides = 6;

//    Methods
    public int randomNum(){
    return (int)Math.floor(Math.random() * sides + 1);
    }

//    Constructor


    public RollDice() {
    }


}
