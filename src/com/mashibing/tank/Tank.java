package com.mashibing.tank;

import java.awt.*;
import java.util.Random;

public class Tank {
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    //    坦克的位置
    private int x, y;
    //    坦克的方向
    private Dir dir;
    //坦克的速度，因为是常量定义，不让别人改变，所以用final,也可以加上private
    private final static int SPEED = 3;
    //在tank类里引用TankFrame
    private TankFrame tf = null;
    //    tank存在
    private boolean living = true;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    //    区分敌方和我方,默认是敌方
    private Group group = Group.BAD;

    //    坦克图片的宽度和长度
    public static int WIDTH = ResourceMgr.tankL.getWidth();
    public static int HEIGHT = ResourceMgr.tankL.getHeight();

    //    设置坦克的停止状态->因为有了敌人坦克，坦克都要动起来。
    private boolean moving = true;
    //    生成随机数
    private Random random = new Random();

    //定义构造体
//    TankFrame是我们的大管家，我们都要持有它的引用
    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
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

        if (!living) tf.tanks.remove(this);
/* 没有图片时候画坦克的方法
        //        画笔的颜色先保存下来
        Color tankColor = g.getColor();
//        setColor方法要放在画坦克之前，放在后面就失效了。
        g.setColor(Color.yellow);
        g.fillRect(x,y,50,50);
//        画完子弹后把画笔的颜色重新设回去
        g.setColor(tankColor);
*/
        //调用图片画坦克
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.tankL, this.x, this.y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, this.x, this.y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, this.x, this.y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, this.x, this.y, null);
                break;
        }

//        设置个控制移动的方法
        move();
    }

    private void move() {
        if (!moving) return;
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
//        产生一个10以内的随机数，并且判断是否>8
        if (random.nextInt(10) > 8) this.fire();
    }

    //坦克发射子弹，在坦克的类里写发射子弹的方法。
    public void fire() {
//        计算子弹发射的位置，我们采用简单的方法，从tank的中心打出来。
        int bulletX = this.x + WIDTH / 2 - Bullet.WIDTH / 2;
        int bulletY = this.y + HEIGHT / 2 - Bullet.HEIGHT / 2;
        tf.bullets.add(new Bullet(bulletX, bulletY, this.dir, this.group, tf));
    }

    public void die() {
        this.living = false;
    }
}
