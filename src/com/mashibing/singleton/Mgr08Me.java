package com.mashibing.singleton;

public enum Mgr08Me {
    INSTANCE; //结尾不加；如果是方法结束的话是可以的

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() ->
                    System.out.println(Mgr08.INSTANCE.hashCode())).start();
        }
    }
}
