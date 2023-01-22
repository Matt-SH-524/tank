package com.mashibing.tank;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
    private static Properties props = new Properties();

    static {
        try {
//            把config内容放到props里面
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
//        做个读取测试
        System.out.println(Integer.parseInt(PropertyMgr.get("initTankCount").toString()));
    }

    public static Object get(String key) {
        if (props == null) return null;
        return props.get(key);
    }
}
