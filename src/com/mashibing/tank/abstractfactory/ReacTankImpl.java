package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.*;

import java.awt.*;
import java.util.Random;

public class ReacTankImpl extends BaseTank {
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
    public Dir dir;
    //坦克的速度，因为是常量定义，不让别人改变，所以用final,也可以加上private
    private final static int SPEED = 3;
    //在tank类里引用TankFrame
    public TankFrame tf = null;
    //    tank存在
    private boolean living = true;

//    public Group getGroup() {
//        return group;
//    }

//    public void setGroup(Group group) {
//        this.group = group;
//    }

    //    区分敌方和我方,默认是敌方
//    public Group group = Group.BAD;

    //    坦克图片的宽度和长度
    public static int WIDTH = ResourceMgr.badTankL.getWidth();
    public static int HEIGHT = ResourceMgr.badTankL.getHeight();

    //    设置坦克的停止状态->因为有了敌人坦克，坦克都要动起来。
    private boolean moving = true;
    //    生成随机数
    private Random random = new Random();
    //    tank的矩形
    public Rectangle rect = new Rectangle();
//    改策略的方式:定义不同类型的成员变量.

    //    FireStrategy fs = new DefaultFireStrategy();
//    FireStrategy fs = new FourDirFireStrategy();
//    可以在tank初始化定义,这样更便捷.
    FireStrategy fs;

    //定义构造体
//    TankFrame是我们的大管家，我们都要持有它的引用
    public ReacTankImpl(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
        this.rect.x = x;
        this.rect.y = y;
        this.rect.width = WIDTH;
        this.rect.height = HEIGHT;
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

    @Override
    public void paint(Graphics g) {

        if (!living) tf.tanks.remove(this);
        //        画笔的颜色先保存下来
        Color tankColor = g.getColor();
//        setColor方法要放在画坦克之前，放在后面就失效了。
        //调用图片画坦克
        if (this.group == Group.GOOD)
            g.setColor(Color.red);
        else if (this.group == Group.BAD)
            g.setColor(Color.yellow);
        g.fillRect(x,y,50,50);
        //        画完子弹后把画笔的颜色重新设回去
        g.setColor(tankColor);
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
//        产生一个100以内的随机数，并且判断是否>95;加判断把mytank随机发射情况给去掉。
        if (random.nextInt(100) > 95 && this.group == Group.BAD) this.fire();
//        定义敌方坦克随机方向
//        让坦克随机停留一段时间再转方向
        if (random.nextInt(100) > 95 && this.group == Group.BAD) randomDir();
//        边界检测
        boundCheck();
        //移动后rect的x和y要重新赋值
        this.rect.x = x;
        this.rect.y = y;
    }

    private void boundCheck() {
        //边界检测，留出2个像素位置，会使画面更美观 。
        if (this.x < 0) x = 2;
        //要加上坦克本身的宽度
        if (this.x > TankFrame.GAME_WIDTH - ReacTankImpl.WIDTH - 2) x = TankFrame.GAME_WIDTH - ReacTankImpl.WIDTH - 2;
        //画面有上沿30高
        if (this.y < 30) y = 30;
        if (this.y > TankFrame.GAME_HEIGHT - ReacTankImpl.HEIGHT - 2) y = TankFrame.GAME_HEIGHT - ReacTankImpl.HEIGHT - 2;
    }

    private void randomDir() {
//        直接取Dir的value，不用多余的判断，显的简便很多。
        this.dir = Dir.values()[random.nextInt(4)];
    }

    //坦克发射子弹，在坦克的类里写发射子弹的方法。
    @Override
    public void fire() {
//        fs.fire(this); 去掉fire的策略模式FourDirFireStrategy
        int bulletX = this.x + ReacTankImpl.WIDTH / 2 - Bullet.WIDTH / 2;
        int bulletY = this.y + ReacTankImpl.HEIGHT / 2 - Bullet.HEIGHT / 2;
        if (group == Group.GOOD) {

            Dir[] dirs = Dir.values();
            for(Dir dir : dirs)
                // 我方坦克开火,新规子弹变成生产子弹 new Bullet(bulletX, bulletY, dir, tank.group, tank.tf);
                this.tf.gf.creatBullet(bulletX, bulletY, dir, this.group, this.tf);
//        我方坦克开火时,设置声音
            new Thread(()->new Audio("audio/tank_fire.wav").loop()).start();
        } else {
            new Bullet(bulletX, bulletY, this.dir, this.group, this.tf);
        }

    }

    public void die() {
        this.living = false;
    }
}
