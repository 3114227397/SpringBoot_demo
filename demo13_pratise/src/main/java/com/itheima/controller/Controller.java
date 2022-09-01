/*
package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.BookDao;
import com.itheima.domain.data_domain;
import com.itheima.domain.people;
import com.itheima.service.BookService;
import com.itheima.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;

@RestController
@RequestMapping("/mybooks")
public class Controller {
    @Autowired
    BookDao b;
//    BookService a;

//登录
    @PostMapping("/login")
    public R login(@RequestBody people p){
        String success_code="20000";
        data_domain success_data = new data_domain("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwiYWNjb3VudCI6ImFkbWluIiwidHlwZSI6MywiaWF0IjoxNjYxODY3MTA4LCJleHAiOjE2NjE4Njg5MDh9.q3UJ77VXhsbs-2hpK-tSPwaoA4v_Di1kEMyTsaVY008");


                      if(b.getByAccount(p.getAccount())!=null){//      "有数据"
                        people DB_psw = b.getByAccount(p.getAccount());//获取people的对象方便得到密码
                        String psw = DB_psw.getPassword();//获取数据库密码
                        if(p.getPassword().equals(psw)){//密码正确
                           p.setToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwiYWNjb3VudCI6ImFkbWluIiwidHlwZSI6MywiaWF0IjoxNjYxODY3MTA4LCJleHAiOjE2NjE4Njg5MDh9.q3UJ77VXhsbs-2hpK-tSPwaoA4v_Di1kEMyTsaVY008");
                            b.update(p,null);
                            if(DB_psw.getAccount().equals("admin")) return new R(success_code,success_data);//超级管理员

          }else{
                return new R(null,"密码错误");
          }
      }
        return new R("404","当前没有这个用户");
    }


    //登出
    @PostMapping("/logout")
    public R logout(@RequestBody people token){
        String token1 = token.getToken();
        System.out.println(token1);
        if((b.getByToken(token1))!=null){//匹配正确
            return new R("603","退出成功");
        }
        return new R("失败","令牌无法匹配");
    }


//    @GetMapping("page/{cur}/{size}")
//    public R getPage(@PathVariable int cur, @PathVariable int size){
//        IPage page=new Page(cur,size);
//        IPage pp = b.selectPage(page, null);
//
//        long pages = pp.getPages();
//        return new R("20000",pages);
//    }
@GetMapping("/page/{cur}/{size}")
public R getPage(@PathVariable int cur,@PathVariable int size){
        IPage page=new Page(cur,size);
    return new R("true",b.selectPage(page,null));
}
}






//          Boolean[] flag=new Boolean[3];
//            for(int i=0;i<psw.length();i++){
//                if(psw.charAt(i)-'0'>=65&&psw.charAt(i)-'0'<=90&&flag[0]==false)flag[0]=true;
//                if(psw.charAt(i)-'0'>=97&&psw.charAt(i)-'0'<=122&&flag[1]==false)flag[1]=true;
//                if(psw.charAt(i)-'0'>=0&&psw.charAt(i)-'0'<=9&&flag[2]==false)flag[2]=true;
//            }
//            for(int i=0;i<flag.length;i++){
//                if(flag[i]==false)return new R(false,"密码格式不合格");
//            }

//          if(password.equals(DB_psw.getPassword())){//匹配密码
//              System.out.println("成功登入");
//              DB_psw.setPassword(account);
//              return new R(true,DB_psw);
//          }
//          return new R(false,"密码不正确");
//      return new R(false,"账号不存在");
*/
