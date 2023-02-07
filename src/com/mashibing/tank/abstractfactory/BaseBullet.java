package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.Tank;

import java.awt.Graphics;

public abstract class BaseBullet {
    public abstract void paint(Graphics g);

    public abstract void collideWith(BaseTank tank);
}
