package com.mashibing.strategy;

//public interface Comparable {
//    int compareTo(Object o);
//
//    int compareMe(Object o);
//}
//改成泛型的方式
public interface Comparable<T> {
    int compareTo(T o);

    int compareMe(T o);
}
