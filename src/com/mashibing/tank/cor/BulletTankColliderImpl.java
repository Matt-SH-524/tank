package com.mashibing.tank.cor;

import com.mashibing.tank.*;

public class BulletTankColliderImpl implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
            //子弹和坦克碰撞检测
            //子弹和坦克都是同一方的，就没有伤害
            //判断子弹矩阵和tank矩阵是否相交
            if (b.getGroup() != t.getGroup() && b.getRect().intersects(t.getRect())) {
                //TODO 每次循环都new子弹，会让java占用太多内存，它的垃圾回收器会时不时运行，以后需要改进成只用一个rect
                b.die();
                t.die();
                int eX = t.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
                int eY = t.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
                //碰撞场合把爆炸加进来。
                //爆炸在坦克中心，计算位置时要注意减掉爆炸图片的一半。
                new Explode(eX, eY);
                return false;
            }
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            return collide(o2, o1);
        }
        return true;
    }
}
