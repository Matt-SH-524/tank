package com.mashibing.tank;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //new个对象
        TankFrame tf = new TankFrame();
        while (true) {
            //主线程里不断刷新
            Thread.sleep(50);
            //paint是系统自动调用的，repaint才是外部可以调用的函数。
            tf.repaint();
        }
    }
}
