package com.itheima.utils;

import lombok.Data;

@Data
public class R {
    private Object data;
    private Boolean flag;
    public R(){}
    public R(Boolean flag){
        this.flag=flag;
    }
    public R(Boolean flag,Object data){
        this.flag=flag;
        this.data=data;
    }
}
