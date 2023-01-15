package com.mashibing.tank;

import java.awt.*;

public class Tank {
//    坦克的位置
    private int x,y;
    //    坦克的方向
    private Dir dir;
//坦克的速度，因为是常量定义，不让别人改变，所以用final,也可以加上private
    private final static int SPEED = 5;
//定义构造体
    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {
        g.fillRect(x,y,50,50);
        switch (dir) {
            case LEFT:
                x-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
            case UP:
                y-=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
        }

    }
}
