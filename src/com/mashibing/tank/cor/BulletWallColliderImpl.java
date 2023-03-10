package com.mashibing.tank.cor;

import com.mashibing.tank.*;

public class BulletWallColliderImpl implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall) {
            Bullet b = (Bullet) o1;
            Wall w = (Wall) o2;
            if (b.getRect().intersects(w.getRect())) {
                b.die();
//                return false;
            }
        } else if (o1 instanceof Wall && o2 instanceof Bullet) {
            return collide(o2, o1);
        }
        return true;
    }
}
