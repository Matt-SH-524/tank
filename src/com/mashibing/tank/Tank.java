package com.mashibing.tank;

import java.awt.*;

public class Tank {
//    坦克的位置
    private int x,y;
    //    坦克的方向
    private Dir dir;
//坦克的速度，因为是常量定义，不让别人改变，所以用final,也可以加上private
    private final static int SPEED = 5;
    //在tank类里引用TankFrame
    private TankFrame tf = null;

    //    设置坦克的停止状态
    private boolean moving = false;
//定义构造体
    public Tank(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g) {

        //        画笔的颜色先保存下来
        Color tankColor = g.getColor();
//        setColor方法要放在画坦克之前，放在后面就失效了。
        g.setColor(Color.yellow);
        g.fillRect(x,y,50,50);
//        画完子弹后把画笔的颜色重新设回去
        g.setColor(tankColor);
//        设置个控制移动的方法
        move();
    }

    private void move() {
        if(!moving) return;
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
//坦克发射子弹，在坦克的类里写发射子弹的方法。
    public void fire() {
        tf.bullet = new Bullet(this.x,this.y,this.dir);
    }
}
