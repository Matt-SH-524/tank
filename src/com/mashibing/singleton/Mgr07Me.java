package com.mashibing.singleton;

public class Mgr07Me {

    private Mgr07Me() {
    }

    private static class Mgr07MeHolder {
        private final static Mgr07Me INSTANCE = new Mgr07Me();
    }

    public static Mgr07Me getInstance() {
        return Mgr07MeHolder.INSTANCE;
    }
}
