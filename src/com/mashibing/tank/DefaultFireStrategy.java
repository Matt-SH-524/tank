package com.mashibing.tank;

public class DefaultFireStrategy implements FireStrategy{
//    自己练习的单例写法
//    private static final DefaultFireStrategy defaultFire = new DefaultFireStrategy();
//
//    private DefaultFireStrategy() {
//    }
//
//    public static DefaultFireStrategy getDefaultFire() {
//        return defaultFire;
//    }

    @Override
    public void fire(Tank tank) {
        //        计算子弹发射的位置，我们采用简单的方法，从tank的中心打出来。
        int bulletX = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bulletY = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        new Bullet(bulletX, bulletY, tank.dir, tank.group, tank.tf);
//        我方坦克开火时,设置声音
        if(tank.group==Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").loop()).start();
    }
}
