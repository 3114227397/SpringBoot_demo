package com.itheima.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.book;
import com.itheima.domain.people;
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
        b.insert_people("ll","111");
        b.insert_people("ee","222");
        b.insert_people("ss","333");
        b.insert_people("admin","approve123456");
        System.out.println(b.insert_people("ww","456"));
    }
    @Test
    void checkAll(){
        System.out.println(b.checkAll());
    }
    @Test
    void checkByAccount(){
        System.out.println(b.checkByAccount("lisi"));
    }
    @Test
    void deleteByAccount(){
        b.deleteByAccount("zs");
    }
    @Test
    void update_people(){
        System.out.println(b.updatePsw("lisi","234"));
    }
    @Test
    void getPage(){
        b.getPage(0,2);
    }


}
