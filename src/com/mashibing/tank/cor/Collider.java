package com.mashibing.tank.cor;

import com.mashibing.tank.GameModel;
import com.mashibing.tank.GameObject;

public interface Collider {
    void collide(GameObject o1, GameObject o2);
}
