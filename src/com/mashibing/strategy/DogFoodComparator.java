package com.mashibing.strategy;

//实现接口Comparator时,泛指T参数要设置成实际应用的类.
public class DogFoodComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {
        if (o1.food < o2.food) return -1;
        else if (o1.food > o2.food) return 1;
        else return 0;
    }
}
