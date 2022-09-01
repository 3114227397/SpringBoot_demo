package com.itheima.utils;

import lombok.Data;

@Data
public class R {
    private Object data;
    private String code;
    private Boolean flag;
    public R(Boolean flag,Object data){
        this.flag=flag;
        this.data=data;
    }
    public R(Boolean flag,Object data,String code){
        this.data=data;
        this.flag=flag;
        this.code=code;
    }
    public R(Boolean flag){
        this.flag=flag;
    }

    public R(){}
    public R(String code){
        this.code=code;
    }
    public R(Object data){
        this.data=data;
    }
    public R(String code,Object data){
        this.data=data;
        this.code=code;
    }
}
