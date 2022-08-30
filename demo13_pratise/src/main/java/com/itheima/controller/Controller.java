package com.itheima.controller;

import com.itheima.dao.BookDao;
import com.itheima.domain.qq;
import com.itheima.service.BookService;
import com.itheima.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mybooks")
public class Controller {
    @Autowired
    BookDao b;

    @GetMapping("/{username}/{password}")
    public R check(@PathVariable String username,@PathVariable String password){
        if(username.length()>11&&username.length()<9)return new R(false,"长度应该在9-11之间");



      if(b.getByUsername(username)!=null){//      "账号输入正确"
          qq DB_psw = b.getByUsername(username);//获取qq的对象方便得到密码
          String psw = DB_psw.getPassword();

          Boolean[] flag=new Boolean[3];
            for(int i=0;i<psw.length();i++){
                if(psw.charAt(i)-'0'>=65&&psw.charAt(i)-'0'<=90&&flag[0]==false)flag[0]=true;
                if(psw.charAt(i)-'0'>=97&&psw.charAt(i)-'0'<=122&&flag[1]==false)flag[1]=true;
                if(psw.charAt(i)-'0'>=0&&psw.charAt(i)-'0'<=9&&flag[2]==false)flag[2]=true;
            }
            for(int i=0;i<flag.length;i++){
                if(flag[i]==false)return new R(false,"密码格式不合格");
            }

          if(password.equals(DB_psw.getPassword())){//匹配密码
              System.out.println("成功登入");
              DB_psw.setPassword(username);
              return new R(true,DB_psw);
          }
          return new R(false,"密码不正确");
      }
      return new R(false,"账号不存在");
    }

}
