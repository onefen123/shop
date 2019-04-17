package net.fen.shop.admin.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class Jsondata implements Serializable {
    private static final long serialVersionUID=1L;
    private int code;
    private Object data;
    private String msg;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Jsondata(int code, String msg){
        super();
        this.code=code;
        this.msg=msg;
    }
    public Jsondata(int code, Object data, String msg){
        super();
        this.code=code;
        this.data=data;
        this.msg=msg;
    }
}
