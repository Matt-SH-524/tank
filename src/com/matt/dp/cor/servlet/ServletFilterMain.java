package com.matt.dp.cor.servlet;

import java.util.ArrayList;
import java.util.List;

//设计模式：Chain of Responsibility
public class ServletFilterMain {
    public static void main(String[] args) {
        Request request = new Request();
        request.str = "request";
        Response response = new Response();
        response.str = "response";

//        System.out.println(msg);

    }
}

//       第五版--- FilterChain实现Filter接口，两个链条连在一起。
//class FilterChain {
class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();

    //       第四版--- 把FilterChain变成链式编程
//    void add(Filter f) {
//        filters.add(f);
//    }
    FilterChain add(Filter f) {
        filters.add(f);
        return this;
    }

    public boolean doFilter(Request request,Response response) {
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
    boolean doFilter(Request request,Response response);
}

class Request {
    String str;
}

class Response {
    String str;
}

class HtmlFilter implements Filter {

    @Override
    public boolean doFilter(Request request,Response response) {
        return false;
    }
}

//敏感词过滤
class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Request request,Response response) {
        return false;
    }
}

