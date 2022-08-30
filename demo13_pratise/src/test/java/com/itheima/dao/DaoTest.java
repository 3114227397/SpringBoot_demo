package com.itheima.dao;

import com.itheima.domain.book;
import com.itheima.domain.qq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DaoTest {
    @Autowired
    private BookDao b;

    @Test
    void add(){
        qq a=new qq();
        a.setPassword("456");
        a.setUsername("ls");
        b.insert(a);
    }
    @Test
    void check(){
        System.out.println(b.getByUsername("ls"));
    }
}
