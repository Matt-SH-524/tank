package com.matt.dp.cor;

import java.util.ArrayList;
import java.util.List;

//设计模式：Chain of Responsibility
public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:)<script>, 你们吃饭了吗？欢迎访问matt.com ,大家都是996.。");
//        最初模式
//        new HtmlFilter().doFilter(msg);
//        new SensitiveFilter().doFilter(msg);

//        进化版本-增加ArrayList
//        List<Filter> filters = new ArrayList<>();
//        filters.add(new HtmlFilter());
//        filters.add(new SensitiveFilter());
//
//        for (Filter f : filters) {
//            f.doFilter(msg);
//        }
//       第三版--- 把ArrayList加到FilterChain里面
//        FilterChain fc = new FilterChain();
//        fc.add(new HtmlFilter());
//        fc.add(new SensitiveFilter());
//        fc.doFilter(msg);
//        System.out.println(msg);
//       第四版--- 把FilterChain变成链式编程
        FilterChain fc = new FilterChain();
        fc.add(new HtmlFilter()).add(new SensitiveFilter());
//        增加一个链条
        FilterChain fc2 = new FilterChain();
        fc2.add(new FaceFilter()).add(new URLFilter());
//       第五版--- FilterChain实现Filter接口，两个链条连在一起。
//        fc2.doFilter(msg);
        fc.add(fc2);
        fc.doFilter(msg);
        System.out.println(msg);

    }
}
//       第五版--- FilterChain实现Filter接口，两个链条连在一起。
//class FilterChain {
class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();
    //       第四版--- 把FilterChain变成链式编程
//    void add(Filter f) {
//        filters.add(f);
//    }
    FilterChain add(Filter f) {
        filters.add(f);
        return this;
    }

    public boolean doFilter(Msg m) {
        for (Filter f : filters) {
            if(!f.doFilter(m)) return false;
        }
        return true;
    }

}

class Msg {
    String name;
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    //    toString用来显示这个信息
    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}

interface Filter {
//    从void变成返回bollean型，来控制Filter是否停止
//    void doFilter(Msg m);
    boolean doFilter(Msg m);
}

class HtmlFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {
        String msgTemp = m.getMsg();
        msgTemp = msgTemp.replace("<", "[");
        msgTemp = msgTemp.replace(">", "]");
        m.setMsg(msgTemp);
        return true;
    }
}

//敏感词过滤
class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {
        String msgTemp = m.getMsg();
        msgTemp = msgTemp.replaceAll("996", "955");
        m.setMsg(msgTemp);
        return false;
    }
}

//笑脸变化
class FaceFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {
        String msgTemp = m.getMsg();
        msgTemp = msgTemp.replace(":)", "^_^");
        m.setMsg(msgTemp);
        return true;
    }
}

//URL补全
class URLFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {
        String msgTemp = m.getMsg();
        msgTemp = msgTemp.replaceAll("matt.com", "http://www.matt.com");
        m.setMsg(msgTemp);
        return true;
    }
}