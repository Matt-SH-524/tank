package com.mashibing.tank;

public interface FireStrategy {
    //    需要把tank作为参数传进去,否则无法知道子弹的位置
    void fire(Tank tank);
}
