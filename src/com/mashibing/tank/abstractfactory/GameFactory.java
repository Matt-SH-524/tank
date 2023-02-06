package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.*;

public abstract class GameFactory {
    public abstract BaseExplode creatExplode(int x, int y, TankFrame tf);

    public abstract BaseBullet creatBullet(int x, int y, Dir dir, Group group, TankFrame tf);

    public abstract BaseTank creatTank(int x, int y, Dir dir, Group group, TankFrame tf);

}
