package com.mashibing.tank;

import com.mashibing.tank.cor.ColliderChain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    //    哪个窗口new出来的坦克，请你把自己传进来。
    Tank myTank = new Tank(200, 500, Dir.DOWN, Group.GOOD, this);
    //    坦克会打出多个子弹，所以子弹是复数，因为子弹个数不确定，所以肯定是定义成容器(相当于动态数组)，而不是定义成数组(就变成静态)
//    List<Bullet> bullets = new ArrayList<>();
//    //    定义敌方坦克-复数
//    List<Tank> tanks = new ArrayList<>();
//    //    定义爆炸-复数
//    List<Explode> explodes = new ArrayList<>();
    //把所有物体(tank,explode,bullet)都放到这个list里面。
    List<GameObject> objects = new ArrayList<>();

    public Tank getMyTank() {
        return myTank;
    }

    public void setMyTank(Tank myTank) {
        this.myTank = myTank;
    }

    //    colliderBT和colliderTT都放到ColliderChain里面
    ColliderChain colliderChain = new ColliderChain();

    public GameModel() {
        //从main方法里移过来。
        //        从配置文件中读取敌方坦克的数量
        int initTankCount = Integer.parseInt(PropertyMgr.get("initTankCount").toString());
//        初始化敌方tanks
        List<Tank> enemyTank = null;
        for (int i = 0; i < initTankCount; i++) {
            objects.add(new Tank(100 + 80 * i, 200, Dir.DOWN, Group.BAD, this));
        }
    }

    public void add(GameObject go) {
        this.objects.add(go);
    }

    public void remove(GameObject go) {
        this.objects.remove(go);
    }

    public void paint(Graphics g) {
        //        画出子弹的数量
//        Color bulletSizeColor = g.getColor();
//        g.setColor(Color.white);
//        g.drawString("子弹数量：" + bullets.size(), 10, 60);
//        g.drawString("敌人数量：" + tanks.size(), 10, 80);
//        g.drawString("爆炸数量：" + explodes.size(), 10, 100);
//        g.setColor(bulletSizeColor);
        //这个方法没有被调用，却被打印出来了，说明它是自动调用的。
        //Graphics g是画图的类，相当于一支画笔。
//        把g这支画笔传给坦克，然后又传给子弹。
        myTank.paint(g);
/*      因为迭代器只能在循环内remove，所以会发生ConcurrentModificationException问题，解决方案：不用迭代器，改为for循环
        for(Bullet b : bullets) {

            b.paint(g);
        }*/
//        所有物体都放到objects里，循环也只要一次画出来
        for (int i = 0; i < objects.size(); i++) objects.get(i).paint(g);
        //碰撞判断
        for (int i = 0; i < objects.size(); i++)
            for (int j = i + 1; j < objects.size(); j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                colliderChain.collide(o1, o2);
            }
//        bullet和tank的碰撞判断：把所有子弹拿出来跟每辆坦克去判断，是否撞上了。
//        for (int i = 0; i < bullets.size(); i++)
//            for (int j = 0; j < tanks.size(); j++) {
//                bullets.get(i).collideWith(tanks.get(j));
//            }
    }
}
