package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.book;

import java.util.List;

public interface BookService extends IService<book> {
    Boolean add(book m);
    Boolean delete(Integer id);
    Boolean update_my(book m);
//    List<book> checkAll();
    book check(Integer id);
    IPage getPage(int cur,int size);
}
