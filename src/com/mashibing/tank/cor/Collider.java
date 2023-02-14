package com.mashibing.tank.cor;

import com.mashibing.tank.GameObject;

public interface Collider {
//    返回true停止，返回false就继续
    boolean collide(GameObject o1, GameObject o2);
}
