package com.mashibing.singleton;

/*静态内部类方式
JVM保证单例
加载外部类时不会加载内部类，这样可以实现懒加载。*/
public class Mgr07 {
    private Mgr07() {
    }

//    定义个静态class
    private static class Mgr07Holder {
        private final static Mgr07 INSTANCE = new Mgr07();
    }

    public static Mgr07 getInstance(){
//        直接使用静态class中的静态变量
        return Mgr07Holder.INSTANCE;
    }
}
