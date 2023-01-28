package com.mashibing.factorymethod;

public class Main {
    public static void main(String[] args) {
//        这就是初级的多态的运用
        Moveable m = new Car();
        m.go();
    }
}
