package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.Dir;
import com.mashibing.tank.Group;

import java.awt.*;

public abstract class BaseTank {
    //    区分敌方和我方,默认是敌方
    public Group group = Group.BAD;
    //    tank的矩形
    public Rectangle rect = new Rectangle();

    public abstract void paint(Graphics g);

    public abstract void fire();

    public abstract void setMoving(boolean b);

    public abstract void setDir(Dir right);

    public Group getGroup(){
        return this.group;
    }

    public abstract void die();

    public abstract int getY();

    public abstract int getX();
}
