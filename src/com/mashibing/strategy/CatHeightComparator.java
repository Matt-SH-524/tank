package com.mashibing.strategy;

//实现接口Comparator时,泛指T参数要设置成实际应用的类.
public class CatHeightComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.height > o2.height) return -1;
        else if (o1.height < o2.height) return 1;
        else return 0;
    }
}
