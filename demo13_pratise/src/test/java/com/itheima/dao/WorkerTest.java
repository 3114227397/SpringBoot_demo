package com.itheima.dao;

import com.itheima.domain.worker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WorkerTest {
    @Autowired
    WorkerDao w;

    @Test
    void test(){
        String a="worker_01";
        String [] s=a.split("_");
        System.out.println(s[0]);
    }
    @Test
    void checkAll(){
        w.selectList(null);
    }
}
