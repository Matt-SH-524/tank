package com.mashibing.tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {
    public static void main(String[] args) {
        //new个对象，Frame代表一个窗口类。
        Frame f = new Frame();
        //设置窗口大小
        f.setSize(800,600);
        //设置不能改变窗口大小
        f.setResizable(false);
        f.setTitle("tank war");
        //Java窗口可见。
        f.setVisible(true);
        //添加一个window监听器，WindowAdapter()是匿名类。-没有命名的类
        f.addWindowListener(new WindowAdapter() {
            //重写方法 Generate菜单里
            @Override
            public void windowClosing(WindowEvent e) {
                //super.windowClosing(e); 修改如下
                System.exit(0);
            }

        });

    }
}
