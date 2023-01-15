package com.mashibing.tank;

import java.awt.Graphics;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//继承Frame类(窗口类)，优势：可以重写Frame方法
public class TankFrame extends Frame {

    Tank myTank = new Tank(200,200,Dir.DOWN);
    Bullet myBullet = new Bullet(250,250,Dir.DOWN);
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
        //Graphics g是画图的类，相当于一支画笔。
//        把g这支画笔传给坦克，然后又传给子弹。
        myTank.paint(g);
        myBullet.paint(g);
    }

    //内部类
    class MyKeyListener extends KeyAdapter {
        //这个类里面专门处理对键盘的监听
        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            //一个键被按下去时候调用
            //KeyEvent事件中哪个键被按下了
            int key = e.getKeyCode();
            //判断到底按的是哪个键
            switch (key) {
                //KeyEvent定义了很多虚拟键盘
                case KeyEvent.VK_LEFT:
                    //按下某个键时，定义的布尔值为True
                    bL = true;
                    //按下左键，左移10
//                    x-=10;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
//                    y-=10;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
//                    x+=10;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
//                    y+=10;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //一个键被释放时候调用
            int key = e.getKeyCode();
            //判断到底按的是哪个键
            switch (key) {
                //KeyEvent定义了很多虚拟键盘
                case KeyEvent.VK_LEFT:
                    //键被释放时，定义的布尔值为false
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }
        private void setMainTankDir() {
            /*正式写法
            if(bR) {
                dir = Dir.RIGHT;
            }*/
            if(!bR && !bL && !bU && !bD) myTank.setMoving(false);
            else {//简洁写法
                if (bR) myTank.setDir(Dir.RIGHT);
                if (bL) myTank.setDir(Dir.LEFT);
                if (bU) myTank.setDir(Dir.UP);
                if (bD) myTank.setDir(Dir.DOWN);
                myTank.setMoving(true);
            }
        }
    }

}
