package com.mashibing.tank;

import com.mashibing.tank.abstractfactory.BaseExplode;

import java.awt.*;

public class Explode extends BaseExplode {
    private int x,y;
    private TankFrame tf;
//    爆炸图片数组控制变量
    private int step = 0;

    //    爆炸图片的宽度和长度
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        new Audio("audio/explode.wav").play();
    }
//    既然Explode继承了BaseExplode,那它就变成重写了paint方法。
    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], this.x, this.y, null);
//       大于数组长度，爆炸被remove。
        if (step >= ResourceMgr.explodes.length) tf.explodes.remove(this);
    }
}
