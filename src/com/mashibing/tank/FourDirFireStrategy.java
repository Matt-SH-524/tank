package com.mashibing.tank;

public class FourDirFireStrategy implements FireStrategy{

    @Override
    public void fire(Tank tank) {
        //        计算子弹发射的位置，我们采用简单的方法，从tank的中心打出来。
        int bulletX = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bulletY = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        Dir[] dirs = Dir.values();
        for(Dir dir : dirs)
            new Bullet(bulletX, bulletY, dir, tank.group, tank.tf);
//        我方坦克开火时,设置声音
        if(tank.group==Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").loop()).start();
    }
}
