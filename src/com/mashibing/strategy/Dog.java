package com.mashibing.strategy;

//public class Dog implements Comparable{
public class Dog implements Comparable<Dog>{
    int food;

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public int compareMe(Dog dog) {
        return 0;
    }

    @Override
    public int compareTo(Dog dog) {
//        问题：如果传进来不是狗的类型，那强制转换就会报错。
//        Dog dog = (Dog)o;
        if(this.food < dog.food) return -1;
        else if (this.food > dog.food) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
