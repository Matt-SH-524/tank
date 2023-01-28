package com.mashibing.factorymethod;

public class Car implements Moveable{
    @Override
    public void go() {
        System.out.println("Car run...");
    }
}
