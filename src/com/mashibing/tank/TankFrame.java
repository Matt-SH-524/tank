package com.mashibing.tank;

import java.awt.Graphics;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//继承Frame类(窗口类)，优势：可以重写Frame方法
public class TankFrame extends Frame {

    //建立一个构造方法
    public TankFrame() {
        //因为自己是一个窗口，可以直接调用窗口的方法
        //设置窗口大小
        setSize(800,600);
        //设置不能改变窗口大小
        setResizable(false);
        setTitle("tank war");
        //Java窗口可见。
        setVisible(true);
        //添加一个window监听器，WindowAdapter()是匿名类。-没有命名的类
        addWindowListener(new WindowAdapter() {
            //重写方法 Generate菜单里
            @Override
            public void windowClosing(WindowEvent e) {
                //super.windowClosing(e); 修改如下
                System.exit(0);
            }

        });

    }

    //窗口被重新绘制的时候会调用这个方法，比如窗口大小改变时候。
    @Override
    public void paint(Graphics g) {
        //这个方法没有被调用，却被打印出来了，说明它是自动调用的。
        //Graphics是画图的类，相当于一支画笔。
        g.fillRect(200,200,50,50);
    }
}
