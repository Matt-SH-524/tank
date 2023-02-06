package com.matt.dp.cor;

import java.util.ArrayList;
import java.util.List;

//设计模式：Chain of Responsibility
public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:)<script>, 你们吃饭了吗？欢迎访问www.matt.com ,大家都是996.。");
//        最初模式
//        new HtmlFilter().doFilter(msg);
//        new SensitiveFilter().doFilter(msg);

//        进化版本
        List<Filter> filters = new ArrayList<>();
        filters.add(new HtmlFilter());
        filters.add(new SensitiveFilter());

        for (Filter f : filters) {
            f.doFilter(msg);
        }

        System.out.println(msg);

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
    void doFilter(Msg m);
}

class HtmlFilter implements Filter {

    @Override
    public void doFilter(Msg m) {
        String msgTemp = m.getMsg();
        msgTemp = msgTemp.replace("<", "[");
        msgTemp = msgTemp.replace(">", "]");
        m.setMsg(msgTemp);
    }
}

//敏感词过滤
class SensitiveFilter implements Filter {

    @Override
    public void doFilter(Msg m) {
        String msgTemp = m.getMsg();
        msgTemp = msgTemp.replaceAll("996", "955");
        m.setMsg(msgTemp);
    }
}
