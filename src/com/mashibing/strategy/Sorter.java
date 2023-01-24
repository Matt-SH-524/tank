package com.mashibing.strategy;

//从小到大排序
public class Sorter {
//    public  static void sort(Cat[] arr) { //Cat类可以转成Comparator
//    sorter现在可以排那些有Comparable接口的类，但还不够灵活
    public  static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j].compareTo(arr[minPos]) == -1 ? j : minPos;
            }
            swap(arr, i, minPos);
        }

    }

    private static void swap(Comparable[] arr, int i, int j) {
        //Cat之间互换位置
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
