package com.mashibing.tank.cor;

import com.mashibing.tank.GameObject;
import com.mashibing.tank.Tank;

public class TankTankColliderImpl implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            //以后需要把collideWith里面的内容都移过来。
            if (t1.getRect().intersects(t2.getRect())) {
                t1.stop();
                t2.stop();
            } else {
                t1.start();
                t2.start();
            }
        }
        //tank相撞没有死掉所以一直返回true
        return true;
    }
}
