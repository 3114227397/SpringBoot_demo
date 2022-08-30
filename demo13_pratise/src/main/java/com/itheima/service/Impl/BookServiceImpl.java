package com.itheima.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.BookDao;
import com.itheima.domain.book;
import com.itheima.domain.qq;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class BookServiceImpl extends ServiceImpl<BookDao, qq> implements BookService {
    @Autowired
    BookDao b;

    public void get(String username){
        System.out.println(b.getByUsername(username));
    }
//    @Override
//    public Boolean getByUsername(String username) {
//        return b.equals(username);
//    }
}
