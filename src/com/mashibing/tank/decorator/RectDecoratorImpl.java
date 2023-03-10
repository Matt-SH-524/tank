package com.mashibing.tank.decorator;

import com.mashibing.tank.GameObject;

import java.awt.*;

public class RectDecoratorImpl extends GODecorator {
    public RectDecoratorImpl(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.getX();
        this.y = go.getY();
        go.paint(g);
        Color c = g.getColor();
        g.setColor(Color.yellow);
        g.drawRect(go.getX(), go.getY(), go.getWidth(), go.getHeight());
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
