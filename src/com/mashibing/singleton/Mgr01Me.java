package com.mashibing.singleton;

public class Mgr01Me {
    private final static Mgr01Me INSTANCE = new Mgr01Me();

    private Mgr01Me() {
    }

    public static Mgr01Me getInstance() {
        return INSTANCE;
    }
}
