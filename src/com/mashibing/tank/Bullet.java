package com.mashibing.tank;

import java.awt.*;

public class Bullet extends GameObject {
    private Dir dir;
    //    子弹存在
    private boolean living = true;

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    //    bullet的矩形
    Rectangle rect = new Rectangle();

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    //    区分敌方和我方,默认是敌方
    private Group group = Group.BAD;
    //    子弹图片的宽度和长度
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();

    private final static int SPEED = 15;

    public Bullet(int x, int y, Dir dir, Group group) {
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

    public void paint(Graphics g) {
//        如果子弹飞出去就不存在了
//        使用容器List，如果不进行回收，容易产生内存泄露，所以Java也会有内存泄露，比如容器的值没有回收。
//        remove时不会越界，因为它会同时调整size.
        if (!living) GameModel.getInstance().remove(this);
/*//        画笔的颜色先保存下来
        Color bulletColor = g.getColor();
//        setColor方法要放在画子弹fillOval之前，放在后面就失效了。
        g.setColor(Color.red); //red和RED一样都是红色
        g.fillOval(x,y,10,10);
//        画完子弹后把画笔的颜色重新设回去
        g.setColor(bulletColor);*/
        //调用图片画坦克
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, this.x, this.y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, this.x, this.y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, this.x, this.y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, this.x, this.y, null);
                break;
        }

//        设置个控制移动的方法
        move();
    }

    private void move() {
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
//        移动后rect的x和y要重新赋值
        this.rect.x = x;
        this.rect.y = y;
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
    }

    public void die() {
        this.living = false;
    }
}
