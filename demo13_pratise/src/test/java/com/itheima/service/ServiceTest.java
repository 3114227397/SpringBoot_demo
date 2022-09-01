package com.itheima.service;

import com.itheima.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTest {

    @Autowired
    BookDao b;

    @Test
    void check(){
//        System.out.println(b.getByUsername("zs"));
    }

}
