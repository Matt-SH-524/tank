package com.mashibing.factorymethod;

public class CarFactory{
    public Moveable create() {

        System.out.println("Car run...");
        return new Car();
    }
}
