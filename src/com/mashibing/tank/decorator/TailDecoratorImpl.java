package com.mashibing.tank.decorator;

import com.mashibing.tank.GameObject;

import java.awt.*;

public class TailDecoratorImpl extends GODecorator {
    public TailDecoratorImpl(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.getX();
        this.y = go.getY();
        go.paint(g);
        Color c = g.getColor();
        g.setColor(Color.blue);
        g.drawLine(go.getX(), go.getY(), go.getX()+getWidth(), go.getY()+getHeight());
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return go.getWidth();
    }

    @Override
    public int getHeight() {
        return go.getHeight();
    }
}
