package com.mashibing.singleton;

/*饿汉式
类加载到内存后，就实例化一个单例，JVM保证线程安全
简单实用，推荐实用！
唯一缺点：不管用到与否，类装载时就完成实例化
Class forName("")也可以加载类*/
public class Mgr01 {
    //定义一个静态的实例，new Mgr01
    private static final Mgr01 INSTANCE = new Mgr01();

    //构造体是private,new不出来。
    private Mgr01() {
    }

    public static Mgr01 getInstance() {
        return INSTANCE;
    }

    //    测试一下是否相同
    public static void main(String[] args) {
        Mgr01Me m1 = Mgr01Me.getInstance();
        Mgr01Me m2 = Mgr01Me.getInstance();
        System.out.println(m1 == m2);
    }

}
