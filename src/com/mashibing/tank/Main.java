package com.mashibing.tank;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //new个对象
        TankFrame tf = new TankFrame();
//        从配置文件中读取敌方坦克的数量
        int initTankCount  = Integer.parseInt(PropertyMgr.get("initTankCount").toString());
//        初始化敌方tanks
        List<Tank> enemyTank = null;
        for (int i = 0; i < initTankCount; i++) {
            tf.tanks.add(new Tank(100 + 80 * i, 200, Dir.DOWN, Group.BAD, tf));
        }
//        播放音乐
        new Thread(() -> new Audio("audio/war1.wav").loop()).start();
        while (true) {
            //主线程里不断刷新
            Thread.sleep(50);
            //paint是系统自动调用的，repaint才是外部可以调用的函数。
            tf.repaint();
        }
    }
}
