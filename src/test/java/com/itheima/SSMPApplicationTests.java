package com.itheima;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.BookDao;
import com.itheima.domain.book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SSMPApplicationTests {
    @Autowired
    private BookDao b;
//    @Test
//    void textSelect() {
//        System.out.println(b.selectById(1));
//    }
//
//    @Test
//    void textAdd(){
//        book m=new book();
//        m.setAge("10");
//        m.setName("lisi");
//        m.setId(3);
//        b.insert(m);
//    }
//    @Test
//    void textUpdate(){
//        book m=new book();
//        m.setId(4);
//        m.setMsg("张三");
//        b.updateById(m);
//    }
//
//    @Test
//    void textDelete(){
//        b.deleteById(1);
//    }
//    @Test
//    void textSelectAll(){
//       b.selectList(null);
//    }
//    @Test
//    void textPage(){
//        String a="zs";
//        LambdaQueryWrapper<book> lqw=new LambdaQueryWrapper<>();
//        lqw.like(a !=null,book::getName,a);//要查询的不能是null
//        IPage page=new Page(1,2);
//        b.selectPage(page,lqw);
//    }
//    @Test
//    void textIfCheck(){
//        String a="zs";
//        LambdaQueryWrapper<book> lqw=new LambdaQueryWrapper<>();
//        lqw.like(a !=null,book::getName,a);//要查询的不能是null
//        b.selectList(lqw);
//    }
}
