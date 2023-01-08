package com.mashibing.tank;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //new个对象
        TankFrame tf = new TankFrame();
        while (true) {
            //主线程里不断刷新
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
