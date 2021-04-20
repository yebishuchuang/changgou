//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.fh.changgou.entity;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

public class Message implements Serializable {
    private int code;
    private Object content;
    @JSONField(
        serialize = false
    )
    private String routekey;
    @JSONField(
        serialize = false
    )
    private String exechange;

    public Message() {
    }

    public Message(int code, Object content) {
        this.code = code;
        this.content = content;
    }

    public Message(int code, Object content, String routekey, String exechange) {
        this.code = code;
        this.content = content;
        this.routekey = routekey;
        this.exechange = exechange;
    }

    public String getRoutekey() {
        return this.routekey;
    }

    public void setRoutekey(String routekey) {
        this.routekey = routekey;
    }

    public String getExechange() {
        return this.exechange;
    }

    public void setExechange(String exechange) {
        this.exechange = exechange;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getContent() {
        return this.content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
