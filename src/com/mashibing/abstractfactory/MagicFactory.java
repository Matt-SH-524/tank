package com.mashibing.abstractfactory;

public class MagicFactory extends AbstractFactory {

    @Override
    Food createFood() {
        return new MashRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
