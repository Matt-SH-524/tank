package com.mashibing.tank;

import java.io.IOException;
import java.util.Properties;

//配置文件一般只要一个实例存在就可以了-用到单例
public class PropertyMgr {
    private static Properties props = new Properties();

    static {
        try {
//            把config内容放到props里面,不完善的地方：一下子把config里面的所有内容都读取进来。
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

    public static String getString(String key) {
        if (props == null) return "";
        return props.get(key).toString();
    }
}
