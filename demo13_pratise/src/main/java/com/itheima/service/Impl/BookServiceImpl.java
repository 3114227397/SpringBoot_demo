package com.itheima.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.BookDao;
import com.itheima.domain.book;
import com.itheima.domain.people;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookDao b;

    @Override
    public Boolean add(String account, String password) {
        return b.insert_people(account,password);
    }

    @Override
    public Boolean delete(String account) {
        return b.deleteByAccount(account);
    }

    @Override
    public Boolean update(String account, String password) {
        return b.updatePsw(account,password);
    }

    @Override
    public people check(String account) {
        return b.checkByAccount(account);
    }

    @Override
    public List<people> checkAll() {
        return b.checkAll();
    }

    @Override
    public List<people> getPage(int cur, int size) {
        return b.getPage(cur,size);
    }


//    public void get(String username){
//        System.out.println(b.getByUsername(username));
//    }
//    @Override
//    public Boolean getByUsername(String username) {
//        return b.equals(username);
//    }
//public IPage getPage(int cur, int size) {
//    IPage page=new Page(cur,size);
//    IPage p = b.selectPage(page, null);
//    return p;
//}
}
