package com.mashibing.tank;

import java.awt.*;

public class Bullet {
    private int x,y;
    private Dir dir;
    private TankFrame tf;
//    子弹存在
    private boolean live = true;
    private final static int SPEED = 3;
    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
//        如果子弹飞出去就不存在了
//        使用容器List，如果不进行回收，容易产生内存泄露，所以Java也会有内存泄露，比如容器的值没有回收。
//        remove时不会越界，因为它会同时调整size.
        if(!live) tf.bullets.remove(this);
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
        if(x<0 || y<0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) live =false;
    }
}
