package com.itheima.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private BookService b;
    @GetMapping
    public List<book> checkAll(){
        return b.list();
    }
    @GetMapping("/{id}")
    public book check(@PathVariable Integer id){
        return b.check(id);
    }

    @PostMapping
    public Boolean add(@RequestBody book m){
        return b.save(m);
    }
    @PutMapping
    public boolean update(@RequestBody book m){
        return b.update_my(m);
    }
    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id){
        return b.delete(id);
    }
    @GetMapping("{cur}/{size}")
    public IPage<book> getPage(@PathVariable int cur,@PathVariable int size){
        IPage page = b.getPage(cur, size);
        return page;
    }


}
