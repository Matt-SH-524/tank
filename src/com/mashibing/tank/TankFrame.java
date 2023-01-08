package com.mashibing.tank;

import java.awt.Graphics;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//继承Frame类(窗口类)，优势：可以重写Frame方法
public class TankFrame extends Frame {
    //想要画面动，坐标就要是变量
    int x=200,y=200;

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

        //键盘监听处理类，这样通过键盘可以让画面动起来。
        this.addKeyListener(new MyKeyListener());

        //添加一个window监听器，WindowAdapter()是匿名类。-没有命名的类
        addWindowListener(new WindowAdapter() {
            //重写方法 在Generate菜单里
            @Override
            public void windowClosing(WindowEvent e) {
                //windowClosing是窗口正在关。
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
        g.fillRect(x,y,50,50);
        x+=10;
        y+=10;
    }

    //内部类
    class MyKeyListener extends KeyAdapter {
        //这个类里面专门处理对键盘的监听

        @Override
        public void keyPressed(KeyEvent e) {
            //一个键被按下去时候调用
            System.out.println("keyPressed");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //一个键被释放时候调用
            System.out.println("keyReleased");
        }


    }
}
