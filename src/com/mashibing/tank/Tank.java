package com.mashibing.tank;

import com.mashibing.tank.decorator.RectDecoratorImpl;
import com.mashibing.tank.decorator.TailDecoratorImpl;

import java.awt.*;
import java.util.Random;

public class Tank extends GameObject {
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

    public int getPrevX() {
        return prevX;
    }

    public void setPrevX(int prevX) {
        this.prevX = prevX;
    }

    public int getPrevY() {
        return prevY;
    }

    public void setPrevY(int prevY) {
        this.prevY = prevY;
    }

    //    坦克前一个位置
    private int prevX, prevY;

    //    坦克的方向
    private Dir dir;
    //坦克的速度，因为是常量定义，不让别人改变，所以用final,也可以加上private
    private final static int SPEED = 3;

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
    public static int WIDTH = ResourceMgr.badTankL.getWidth();
    public static int HEIGHT = ResourceMgr.badTankL.getHeight();

    //    设置坦克的停止状态->因为有了敌人坦克，坦克都要动起来。
    private boolean moving = true;
    //    生成随机数
    private Random random = new Random();

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    //    tank的矩形
    Rectangle rect = new Rectangle();

    //定义构造体
//    TankFrame是我们的大管家，我们都要持有它的引用
    public Tank(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.rect.x = x;
        this.rect.y = y;
        this.rect.width = WIDTH;
        this.rect.height = HEIGHT;
        GameModel.getInstance().add(this);
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
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

        if (!living) GameModel.getInstance().remove(this);
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
        if (this.group == Group.GOOD)
            switch (dir) {
                case LEFT:
                    g.drawImage(ResourceMgr.goodTankL, this.x, this.y, null);
                    break;
                case RIGHT:
                    g.drawImage(ResourceMgr.goodTankR, this.x, this.y, null);
                    break;
                case UP:
                    g.drawImage(ResourceMgr.goodTankU, this.x, this.y, null);
                    break;
                case DOWN:
                    g.drawImage(ResourceMgr.goodTankD, this.x, this.y, null);
                    break;
            }
        else if (this.group == Group.BAD)
            switch (dir) {
                case LEFT:
                    g.drawImage(ResourceMgr.badTankL, this.x, this.y, null);
                    break;
                case RIGHT:
                    g.drawImage(ResourceMgr.badTankR, this.x, this.y, null);
                    break;
                case UP:
                    g.drawImage(ResourceMgr.badTankU, this.x, this.y, null);
                    break;
                case DOWN:
                    g.drawImage(ResourceMgr.badTankD, this.x, this.y, null);
                    break;
            }
//        设置个控制移动的方法
        move();
    }

    private void move() {
//        记录移动之前的位置
        this.prevX = x;
        this.prevY = y;
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
        if (this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        //画面有上沿30高
        if (this.y < 30) y = 30;
        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
    }

    private void randomDir() {
//        直接取Dir的value，不用多余的判断，显的简便很多。
        this.dir = Dir.values()[random.nextInt(4)];
    }

    //坦克发射子弹，在坦克的类里写发射子弹的方法。
    public void fire() {
//        计算子弹发射的位置，我们采用简单的方法，从tank的中心打出来。
        int bulletX = this.x + WIDTH / 2 - Bullet.WIDTH / 2;
        int bulletY = this.y + HEIGHT / 2 - Bullet.HEIGHT / 2;
        GameModel.getInstance().add(new RectDecoratorImpl(new TailDecoratorImpl(new Bullet(bulletX, bulletY, this.dir, this.group))));
    }

    public void die() {
        this.living = false;
    }
    //tank互相碰撞要停止
//    public void stop() {
//        this.moving = false;
////        System.out.println("this.x:" + this.x + ";prevX:" + this.prevX);
//        this.x = this.prevX;
//        this.y = this.prevY;
//    }
//    //tank互相碰撞停止后，要继续动起来。
//    public void start() {
//        this.moving = true;
//    }

    //    把stop和start优化成back方法
    public void back() {
        this.x = this.prevX;
        this.y = this.prevY;
    }
}
