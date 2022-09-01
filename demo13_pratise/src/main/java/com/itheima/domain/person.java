package com.itheima.domain;

import lombok.Data;

@Data
public class person {
    private Integer id;
    private String name;
    private String msg;
    private Integer form_id=3;
    public person(String name,String msg,Integer form_id){
        this.form_id=form_id;
        this.name=name;
        this.msg=msg;
    }
    public person(String name,String msg){
        this.name=name;
        this.msg=msg;
    }

    public person(){}
}
