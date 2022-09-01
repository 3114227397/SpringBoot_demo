package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.person;
import com.itheima.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(true)
public class PersonTest {
    @Autowired
    PersonDao p;
@Autowired
PersonService ps;
    @Test
    void add(){
        person per=new person("san","老3",3);//
        person per1=new person("yi","老1",3);//
        person per2=new person("er","老2",3);//
        person per3=new person("si","老4",3);//
        p.insert(per1);
        p.insert(per);
        p.insert(per3);
        p.insert(per2);
    }
//    查询
    @Test
    void checkAll(){
//        person per=new person("11","老王",3);//
        p.selectList(null);
    }

    @Test
    void check(){
//        person per/=new person("11","老王",3);//
        System.out.println(p.selectById(3));
        System.out.println(p.checkByName("11"));
//        p.insert();
    }
//删除
    @Test
    void delete(){
        System.out.println(p.dropById(2));
    }
//    修改
    @Test
    void update(){
        LambdaQueryWrapper<person> lqw=new LambdaQueryWrapper<>();

        person per=new person("wang","老王no.3",3);//
//        p.update(per,);
    }
//    分页
    @Test
    void getPage(){
        IPage page=new Page(1,2);
        p.selectPage(page,null);
    }


}


//    create table boss(
//        id int primary key auto_increment,
//        name varchar(32),
//    msg varchar(32),
//Form_id int
//        );