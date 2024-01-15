package com.example.demo;

public class Bicycle {

    private int gear;
    private int speed;

    public Bicycle(int gear, int speed){
        this.gear = gear;
        this.speed = speed;
    }

    public void applyBrake(int decrement){
        speed -= decrement;
    }

    public void speedUp(int increment){
        speed += increment;
    }
    public void speedUp(int increment, int mutiply){
        speed = speed * mutiply;
    }

    public String toString(){
        return("No of gears are "+gear+ "\n"+ "speed of bicycle is "+speed );
    }

}
