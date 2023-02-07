package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.*;

//生产产品时候要建个具体生产产品的工厂
public class DefaultFactory extends GameFactory {

    @Override
    public BaseExplode creatExplode(int x, int y, TankFrame tf) {
        return new Explode(x, y, tf);
    }

    @Override
    public BaseBullet creatBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new Bullet(x, y, dir, group, tf);
    }

    @Override
    public BaseTank creatTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return null;
    }
}
