package com.itheima.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.BookDao;
import com.itheima.domain.music;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTest {
    @Autowired
    BookService b;

    @Test
    void checkAll(){
        b.list();
    }









//    @Autowired
//    BookService b;
//    @Test
//    void textCheck() {
//        System.out.println(b.check(1));
//    }
//
//    @Test
//    void textAdd(){
//        music m=new music();
//        m.setAge(10);
//        m.setName("lisi");
//        m.setId(3);
//        b.add(m);
//    }
//    @Test
//    void textUpdate(){
//        music m=new music();
//        m.setId(4);
//        m.setMsg("张三");
//        b.update(m);
//    }
//
//    @Test
//    void textDelete(){
//        b.delete(1);
//    }
//    @Test
//    void textCheckAll(){
//        b.checkAll();
//    }
//    @Test
//    void textPage(){
//        b.getPage(1,2);
//    }

}
