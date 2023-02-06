package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.Audio;
import com.mashibing.tank.ResourceMgr;
import com.mashibing.tank.TankFrame;

import java.awt.*;

//做个方的爆炸
public class RectExplodeImpl extends BaseExplode {
    //    既然都是继承BaseExplode,那就从Explode里面copy内容过来。
    private int x, y;
    private TankFrame tf;
    //    爆炸图片数组控制变量
    private int step = 0;

    //    爆炸图片的宽度和长度
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    public RectExplodeImpl(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        new Audio("audio/explode.wav").play();
    }

    //    既然Explode继承了BaseExplode,那它就变成重写了paint方法。
    @Override
    public void paint(Graphics g) {
//        g.drawImage(ResourceMgr.explodes[step++], this.x, this.y, null);
//        画个简单的方块
        Color c = g.getColor();
        g.setColor(Color.yellow);
        g.fillRect(x, y, 10 * step, 10 * step);
        g.setColor(c);
        step++;

//       大于数组长度，爆炸被remove。
        if (step >= ResourceMgr.explodes.length) tf.explodes.remove(this);
    }
}
