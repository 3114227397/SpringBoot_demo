package com.itheima.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.BookDao;
import com.itheima.dao.PersonDao;
import com.itheima.dao.WorkerDao;
import com.itheima.domain.people;
import com.itheima.domain.person;
import com.itheima.domain.worker;
import com.itheima.service.BookService;
import com.itheima.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/users")
public class moneyController {
    @Autowired
    BookService b;
    @Autowired
    PersonDao pd;
    @Autowired
    WorkerDao wd;


    @GetMapping
//    查询所有
    public R checkAll(){
        return new R("200",b.checkAll());
    }
//    查询单个
    @GetMapping("/{account}")
    public R checkByAccount(@PathVariable String account){
        return new R("200",b.check(account));
    }


    @PostMapping
//    增加
    public R add(@RequestParam("account") String account,@RequestParam("password") String password){
        return new R(b.add(account,password));
    }
//    删除
    @DeleteMapping("/{account}")
    public R deleteByAccount(@PathVariable String account){
        return new R(b.delete(account));
    }
//    改
    @PutMapping
    public R updateByAccount(@RequestParam String account,@RequestParam String password){
        return new R(b.update(account,password));
    }

//    查询分页
    @GetMapping("/{cur}/{size}")
    public R getPage(@PathVariable int cur,@PathVariable int size){
        return new R("200",b.getPage(cur,size));
    }

//    登录
    @PostMapping("/login")
    public R login(@RequestParam String account,@RequestParam String password){
        if(b.check(account)!=null){//查到有账号
            people pp = b.check(account);
            if(pp.getPassword().equals(password)){//密码正确
                if(account.equals("admin"))return new R(true,"您好，boss","20000");
                String []ss=account.split("_");
                if(ss[0].equals("worker")){
                    return new R(true,"您好，员工"+ss[1]+"号","1000");
                }
                return new R(true,"你是贷款用户","200");
            }else{
                return new R(false,"密码错误","xxx");
            }

        }
        return new R(false,"账号未注册");
    }

//    登出
@PostMapping("/logout")
public R logout(@RequestParam("msg") String msg){
        if(msg.equals("bye"))return new R("603","成功退出账号");
        return new R(false,"退出失败");
}



//获取用户登录信息  ok
@GetMapping("/info/{name}")
    public R getPerson(@PathVariable String name){//假设通过传入name来进行查询
        return new R(true,pd.checkByName(name));
}

//贷款申请  ok
    @PostMapping("/create")
    public R createPerson(@RequestBody person p){//检查是否有没有写的项目
        if(p.getMsg().equals("")||p.getMsg()==null)return new R(false,"请输入msg选项");
        if(p.getName().equals("")||p.getName()==null)return new R(false,"请输入名字");
        return new R(pd.insert(p)>0,"贷款用户信息录入成功","200");
}
//申请管理查询    ok
@GetMapping("/list/{cur}/{size}/{name}")
    public R getPage_list(@PathVariable int cur,@PathVariable int size,@PathVariable String name){
        //这里假设根据名字name进行查询
//    查询
//        person person = pd.checkByName(name);
//    String DB_name = person.getName();
    LambdaQueryWrapper<person> lqw=new LambdaQueryWrapper<>();
    LambdaQueryWrapper<person> qw = lqw.like(name != null, person::getName, name);
//    分页
    IPage<person> page=new Page<>(cur,size);
    IPage<person> personIPage = pd.selectPage(page, qw);
    if(personIPage.getPages()>0)return new R(true,personIPage);
    return new R(false,"没有查询到","404");

}
//    申请管理 -编辑  ok

    @PutMapping("/update")
    public R edit(@RequestParam Integer id,@RequestParam String name,@RequestParam String msg){//这里假设传过来Params
        return new R(pd.modifyById(id,name,msg),"修改成功","20000");//返回true和状态码
    }


//    申请管理 -删除  ok

    @DeleteMapping("/delete/{id}")
    public R deleteById(@PathVariable Integer id){//按照id来删除，并且传入id，路径资源
        return new R(pd.dropById(id),"删除成功","20000");
    }

//    申请管理 -提交审核
        //这里创建数据库，然后设置flag和一个参数来进行标志初审终审的区别

//文件下载  ok
@PostMapping("/createFile")
    public R createFile(@RequestParam Integer id) throws IOException {
        String url="D://aaa/agreement.docx";
        Random r=new Random();
    double v = r.nextDouble(100);
    String s = String.valueOf(v);
    person person = pd.selectById(id);
    BufferedWriter bw=new BufferedWriter(new FileWriter("D://aaa/agreement"+s+".docx"));
    bw.write("贷款合同");
    bw.newLine();
    bw.append("尊敬的").append(person.getName()).append(":");
    bw.newLine();
    bw.append("姓名：").append(person.getName());
    bw.newLine();
    bw.append("身份证：").append(String.valueOf(person.getId()));
    bw.newLine();
    bw.append("备注：").append(person.getMsg());
    bw.append("申请人：").append(person.getName());
    bw.newLine();
    ZonedDateTime zdt=ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String format = dtf.format(zdt);
    bw.write(format);
    bw.close();
    return new R(true,url);
}
//    权限管理 -创建管理员worker
//    创建员工
    @PostMapping("/createUser")
public R createWorker(@RequestBody worker worker){
        return new R(wd.insert(worker)>0,"加入成功","200");
}
@GetMapping("/worker")
public R getAllWorker(){
        return new R(true,wd.selectList(null));
}

//    删除员工
    @DeleteMapping("/deleteUser")
    public R deleteWorkerById(@PathVariable Integer id){
        return new R(wd.deleteById(id)>0,"删除成功","200");
    }

//    展示列表


    @GetMapping("/person")
    public R checkAllPerson(){
        return new R(pd.selectList(null));
    }
}
