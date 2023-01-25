package com.mashibing.strategy;
//new个新的interface：比较器
@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1,T o2);
//    JDK1.8以后在interface里也可以写方法了
    default void m() {
        System.out.println("m");
    }
}
