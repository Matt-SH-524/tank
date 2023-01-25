package com.mashibing.strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cat[] c = {new Cat(3,3),new Cat(5,5),new Cat(1,1)};
        Dog[] d = {new Dog(3),new Dog(5),new Dog(1)};
        Sorter sorter = new Sorter();
        sorter.sort(c,new CatWeightComparator());
        System.out.println(Arrays.toString(c));
        sorter = new Sorter();
        sorter.sort(c,new CatHeightComparator());
        System.out.println(Arrays.toString(c));
        sorter = new Sorter();
        sorter.sort(d,new DogFoodComparator());
        System.out.println(Arrays.toString(d));
    }
}
