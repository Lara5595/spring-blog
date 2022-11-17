package com.codeup.springblog.models;

public class rollDice {

    private int roll;

    private int number;

//    Getters and Setters

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    // Method
    public static int rollNumber(){
        return (int) Math.floor(Math.random()*6) +1;
    }

    //    Constructors
    public rollDice(){}

    public rollDice(int roll, int number) {
        this.roll = roll;
        this.number = number;
    }


}
