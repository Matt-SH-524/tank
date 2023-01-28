package com.mashibing.factorymethod;


//简单工厂:开发简单，但可扩展性不好：如果新添加一种功能就要添加一个方法，方法里面的功能也要写死。
public class SimpleVehicleFactory {
    public Car createCar(){
//        before processing
        return new Car();
    }

    public Plane createPlane() {
        return new Plane();
    }

    public Broom createBroom() {
        return new Broom();
    }
}
