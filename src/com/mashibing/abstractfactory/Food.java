package com.mashibing.abstractfactory;
//食品是现实存在的，又不是具体的事物，所以用抽象类比较合适，但可移动的东西(moveable)明显是某一东西的属性，interface。
//形容词用接口，名词用抽象类
public abstract class Food {
    abstract void eat();

}
