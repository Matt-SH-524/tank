package com.mashibing.strategy;

//从小到大排序
//Sorter Class后面一定要跟<T>,类里面才能用到<T>.
public class Sorter<T> {
    //    public  static void sort(Cat[] arr) { //Cat类可以转成Comparator
/* sorter现在可以对实现Comparable接口的类进行排序，但还不够灵活：compareTo里面还是固定的，
比如Cat现在只是比较weight，Cat的比较大小的策略可以灵活指定。*/
//    用T以后public  static void sort中的static要去掉。
    public void sort(T[] arr, Comparator comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = comparator.compare(arr[j], arr[minPos]) == -1 ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }
    //    用T以后private static void swap中的static要去掉。
    private void swap(T[] arr, int i, int j) {
        //Cat之间互换位置
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}