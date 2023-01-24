package com.mashibing.singleton;

/*lazy loading
也称懒汉式:什么时候用的时候，什么时候调用。
虽然达到了按需初始化的目的，但多线程访问时候会有影响*/
public class Mgr03 {
    private static Mgr03 INSTANCE;

    private Mgr03() {
    }

//    public static Mgr03 getInstance() {
    public static synchronized Mgr03 getInstance() {//加锁
        if (INSTANCE == null) {
            try {
//                让进程延缓1秒就能发现问题
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
/*
            线程的通常的写法：最简单的匿名内部类的写法
            new Thread(new Runnable() { //Runnable是个接口，对只有一个匿名内部类的表达方式，实现的是没有名字的匿名内部类
                @Override
                public void run() {
                具体实施内容：System.out.println(Mgr03.getInstance().hashCode());
                }
            }).start();
            第二种写法：
            new Thread(() ->{
                    System.out.println(Mgr03.getInstance().hashCode());}
            ).start();
            简写如下：
*/
            new Thread(() ->
                    System.out.println(Mgr03.getInstance().hashCode())
            ).start();
        }
    }
}
