package com.mashibing.tank;

import java.awt.*;

public class Bullet {
    private int x,y;
    private Dir dir;
    private final static int SPEED = 3;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
//        画笔的颜色先保存下来
        Color bulletColor = g.getColor();
//        setColor方法要放在画子弹fillOval之前，放在后面就失效了。
        g.setColor(Color.red); //red和RED一样都是红色
        g.fillOval(x,y,10,10);
//        画完子弹后把画笔的颜色重新设回去
        g.setColor(bulletColor);
//        设置个控制移动的方法
        move();
    }

    private void move() {
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
