package com.mashibing.singleton;

/*不仅可以解决线程同步，还可以防止反序列化
* 枚举型没有构造方法(Java语言规定)，所以无法反序列化*/
public enum Mgr08 {
    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() ->
                    System.out.println(Mgr08.INSTANCE.hashCode())
            ).start();
        }
    }
}
