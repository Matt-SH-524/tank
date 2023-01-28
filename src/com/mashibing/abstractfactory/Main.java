package com.mashibing.abstractfactory;

public class Main {
//    灵活的扩展产品一族
    public static void main(String[] args) {
//        modernActivity();
        modernActivityNew();
        MagicActivityNew();

    }

    private static void MagicActivityNew() {
//        魔法世界使用的三种产品
        AbstractFactory af = new MagicFactory();
        Vehicle broom = af.createVehicle();
        broom.go();
        Food mashroom = af.createFood();
        mashroom.eat();
        Weapon magicstick = af.createWeapon();
        magicstick.shoot();
    }

    private static void modernActivity() {
        //现代人使用三种产品
        Car vehicle = new Car();
        vehicle.go();
        Bread food = new Bread();
        food.eat();
        AK47 weapon = new AK47();
        weapon.shoot();
    }

    private static void modernActivityNew() {
        AbstractFactory af = new ModernFactory();
        //现代人使用三种产品
        Vehicle car = af.createVehicle();
        car.go();
        Food bread = af.createFood();
        bread.eat();
        Weapon ak47 = af.createWeapon();
        ak47.shoot();
    }
}


