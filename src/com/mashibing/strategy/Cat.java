package com.mashibing.strategy;

//public class Cat implements Comparable {
//不写<Cat>默认是Object,写了系统会自动帮你做类型检查，如果传进来不是Cat就会报错。
public class Cat implements Comparable<Cat> {
    int weight, height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public int compareTo(Cat cat) {
//        使用Object变量要做强制转换
//        Cat c = (Cat) o;
        if (this.weight < cat.weight) return -1;
        else if (this.weight > cat.weight) return 1;
        else return 0;
    }

    @Override
    public int compareMe(Cat c) {
        return 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
