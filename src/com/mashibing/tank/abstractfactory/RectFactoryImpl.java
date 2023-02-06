package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.Dir;
import com.mashibing.tank.Group;
import com.mashibing.tank.TankFrame;

//建立个方的爆炸的工厂
public class RectFactoryImpl extends GameFactory {
    @Override
    public BaseExplode creatExplode(int x, int y, TankFrame tf) {
        return new RectExplodeImpl(x, y, tf);
    }

    @Override
    public BaseBullet creatBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return null;
    }

    @Override
    public BaseTank creatTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return null;
    }
}
