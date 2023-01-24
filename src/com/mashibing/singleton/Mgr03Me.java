package com.mashibing.singleton;

public class Mgr03Me {
    private static Mgr03Me INSTANCE;

    private Mgr03Me() {
    }

    public static synchronized Mgr03Me getInstance() {
        if (INSTANCE == null) INSTANCE = new Mgr03Me();
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() ->
                    System.out.println(Mgr03Me.getInstance().hashCode())).start();

        }

    }
}
