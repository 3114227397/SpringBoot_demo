package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
//import com.itheima.domain.book;xx
import com.itheima.domain.people;

import java.util.List;

public interface BookService{
    public Boolean add(String account,String password);
    public Boolean delete(String account);
    public Boolean update(String account,String password);
    public people check(String account);
    public List<people> checkAll();
    public List<people> getPage(int cur,int size);

}
