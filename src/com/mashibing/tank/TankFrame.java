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
    Dir dir; //先不设置初始值= Dir.DOWN;
    //tank的速度，因为是常量定义，不让别人改变，所以用final,也可以加上private
    private final static int SPEED = 10;

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
        //x+=10;y+=10;
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
            //paint是系统自动调用的，repaint才是外部可以调用的函数。
//            x+=200;
//            repaint();
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
            //简洁写法
            if(bR) dir = Dir.RIGHT;
            if(bL) dir = Dir.LEFT;
            if(bU) dir = Dir.UP;
            if(bD) dir = Dir.DOWN;
        }
    }

}
