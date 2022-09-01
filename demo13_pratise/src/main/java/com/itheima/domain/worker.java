package com.itheima.domain;

import lombok.Data;

@Data
public class worker {
    private String name;
    private Integer id;
    private String msg;
    private Integer form_id=2;
    public worker(String name,String msg){
        this.name=name;
        this.msg=msg;
    }
    public worker(){}
}
