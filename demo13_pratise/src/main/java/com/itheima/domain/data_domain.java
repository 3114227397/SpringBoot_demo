package com.itheima.domain;

import lombok.Data;

@Data
public class data_domain {
    private String token;
    public data_domain(String token){
        this.token=token;
    }
}
