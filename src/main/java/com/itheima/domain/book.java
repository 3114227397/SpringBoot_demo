package com.itheima.domain;

import lombok.Data;

@Data
public class book {
    private Integer id;
    private String type;
    private String name;
    private String description;}

/*
 *       create table book(
 *          id int primary key auto_increment,
 *          type varchar(32),
 *          name varchar(32),
 *          description varchar(32)
 *              );
 *
 * */