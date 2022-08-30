package com.itheima.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.book;
import com.itheima.service.BookService;
import com.itheima.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService b;
    @GetMapping
    public R checkAll(){
        return new R(true,b.list());
    }
    @GetMapping("/{id}")
    public R check(@PathVariable Integer id){
        return new R(true,b.check(id));
    }

    @PostMapping
    public R add(@RequestBody book m){
        return new R(b.save(m));
    }
    @PutMapping
    public R update(@RequestBody book m){
        return new R(b.update_my(m));
    }
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(b.delete(id));
    }
    @GetMapping("{cur}/{size}")
    public R getPage(@PathVariable int cur,@PathVariable int size){
        return new R(true,b.getPage(cur, size));
    }


}
