package com.mashibing.factorymethod;

public class Plane implements Moveable{
    @Override
    public void go() {
        System.out.println("Plane fly...");
    }
}
