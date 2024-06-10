package com.example.demo;

public class MountainBike extends Bicycle{

    public int seatHeight;
    String str ;

    public MountainBike(int gear, int speed, int startHeight){
        super(gear,speed);
        seatHeight = startHeight;
        super.speedUp(10);
        super.speedUp(10,2);
    }

    public void setSeatHeight(int newValue){
        seatHeight = newValue;
    }

    @Override
    public String toString(){
        return(super.toString() + "\nseat height is "+seatHeight);
    }
}
