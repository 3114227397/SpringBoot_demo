package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.BookDao;
import com.itheima.domain.book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao,book> implements BookService {

    @Autowired
    private BookDao b;
//
    @Override
    public Boolean add(book m) {
        return b.insert(m)>0;
    }

    @Override
    public Boolean delete(Integer id) {
        return b.deleteById(id)>0;//大于0成功，小于零失败
    }

    @Override
    public Boolean update_my(book m) {
        return b.updateById(m)>0;
    }
//
//    @Override
//    public List<book> checkAll() {
//        return b.selectList(null);
//    }
//
//
    @Override
    public book check(Integer id) {
        book book = b.selectById(id);
        return book;
    }
//
    @Override
    public IPage getPage(int cur, int size) {
        IPage page=new Page(cur,size);
        IPage p = b.selectPage(page, null);
        return p;
    }
}
