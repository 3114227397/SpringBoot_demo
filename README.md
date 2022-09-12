# 前言

本开发基于mybatis，druid，mysql，mybatis-plus和springboot等技术基于注解和restful风格进行开发，实现了增删改查和分页的功能

本次开发主要是为了熟悉上述框架的使用，意在学习各种方式，比如：

1. 使用了mybatis的注解开发，手动编写
2. 使用了mybatis-plus提供的方法简化开发
3. 使用了各种的传入参数方式，比如postMapping的json数据传入和@RequestParam的K-V传入方式，当然代码中注释掉了。

4. 因为是学习和熟练，所以部分接口功能并没有完全实现，比如员工的增删改查分页和贷款用户的增删改查分页重复的有些没有去书写。

5. 查询所有员工，查询所有贷款用户等等功能没有详细标注，因为本次开发中数据库实现过于简单，老板的权限和老板，员工，用户外键连接的form表的功能并没有充分发挥，people表可以增加更多字段去使用多表查询，内连接，自连接等等。
6. 本次开发之后，本人发现部分存在问题，但是由于懒惰不想却更改，只是大概的书写了解决方法。

###数据库

####people表：

id int primary auto_increment comment '主键'

account varchar(32) comment'账号'

password varchar(32) comment ''密码''

#### worker,person，boss表

本人为了简便，这里只设置四个参数，避免繁琐。

1. id int主键自增，

2. name varchar（10）
3. msg varchar(32)信息
4. form_id外键连接form的id

####form表

1. id 主键自增
2. work varchar（10） comment'职位'

<img src="C:\Users\G&D\AppData\Roaming\Typora\typora-user-images\image-20220912203632909.png" alt="image-20220912203632909" style="zoom:80%;" />





### 通用类R

1. 定义三个数据
   1. Object data：返回数据
   2. Boolean flag：定义操作成功与否
   3. String code：返回状态码
2. 利用lombok简化开发
3. 定义相应的无参构造和带参构造



# 登录

## 接口

| 资源url：http://localhost:80/users/logins |
| ----------------------------------------- |
| HTTP协议：post                            |

| 参数     | 备注 |
| -------- | ---- |
| account  | 账号 |
| password | 密码 |

| 返回值 |          |
| ------ | -------- |
| flag   | 成功与否 |
| code   | 代码信息 |
| data   | 数据信息 |

这里code返回代码信息，flag返回成功与否，data返回数据

## 代码实现

1. 获取http：postMapping（“/logins”）

2. 参数获取：@RequestBody 获取JSON对象

3. 检查是否有改账号（用户名）

   ~~~java
   if(b.check(p.getAccount())!=null){//查到有账号
   ~~~

4. 如果无，返回未注册的信息，如果有，检查密码会否正确

5. 密码正确，检查account格式

   1. admin：超级管理员
   2. workerxxx:员工
   3. 其余的就是贷款用户

# 退出登录

## 接口

| 资源url：http://localhost:80/users/logout |
| ----------------------------------------- |
| HTTP协议：post                            |

| 参数 | 备注     |
| ---- | -------- |
| msg  | 再见信息 |

返回msg信息，比如'bye'，就返回退出信息，前端收到信息就进行页面跳转。

# 获取用户登录信息

| 资源url：http://localhost:80/users/info/{name} |
| ---------------------------------------------- |
| HTTP协议：get                                  |

| 参数 | 备注 |
| ---- | ---- |
| name | 名字 |

根据==名字==来返回用户信息。

获取参数方式是@PathVariable，获取路径参数

####不足

这个地方稍微不足，因为name不是索引，所以速度会慢很多，只不过这个只是为了增加自己对这些业务的书写能力而设置的，并非实际开发。实际开发建议使用id进行查询。否者的话给name增加一个索引，例如：

~~~java
create index idx_name on people (name)
~~~



# 贷款申请

## 数据库表：person

| 资源url：http://localhost:80/users/create |
| ----------------------------------------- |
| HTTP协议：post                            |

| 参数       | 备注                      |
| ---------- | ------------------------- |
| person对象 | json数据，主要是msg和name |

1. form_id因为连接form的，所以固定

2. id的话设置为自增，防止页分裂，降低效率

判断传入的对象中msg和name是否有，如果为空的话返回错误信息。如果全了的话就返回成功信息

# 分页查询

| 资源url：http://localhost:80/users/list/ |
| ---------------------------------------- |
| HTTP协议：get                            |

| 参数 | 备注           |
| ---- | -------------- |
| cur  | 当前页         |
| size | 每页大小是多少 |
| name | 查询的东西     |

这里假设根据name进行查询。

1. sql语法：like

2. 用LambdaQueryWrapper来设置条件，确保name非空

~~~java
LambdaQueryWrapper<person> lqw=new LambdaQueryWrapper<>();
    LambdaQueryWrapper<person> qw = lqw.like(name != null, person::getName, name);
~~~

3. 分页：
   1. 使用MP提供的selecctPage方法进行分页
      1. 前提是设置好了MP拦截器。
   2. 分号页之后调用getPage（）判断是否查询到结果并且根据结果进行返回



# 申请管理

## 修改

| 资源url：http://localhost:80/users/update |
| ----------------------------------------- |
| HTTP协议：put                             |

| 参数       | 备注                   |
| ---------- | ---------------------- |
| person对象 | 里面是修改信息，包括id |

这里根据传入的JSON数据里面的id进行修改数据，id不改。

当然这里的方法是存在局限的，一定是需要id，name，msg同时存在的情况下，但是有的时候用户并不想同时更改name和msg，或者漏写name或者漏写msg。这个时候就会报错。以下是项目中不足的代码：

~~~java
 @Update("update person set name=#{name},msg=#{msg} where id=#{id}")
    public Boolean modifyById(Integer id,String name,String msg);
~~~

我认为改进的策略有：

1. 写多几个sql语句的方法，对应只修改name或者只修改msg。

   1. 显然这种策略非常复杂，不利于开发

2. 编写动态SQL语句，在xml中利用set标签和if标签进行处理。因为注解开发的非常复杂，所以此处值提供xml配置文件的修改策略：

   ~~~java
   <update id="modifyById" resultType="Boolean">
   update person
   <set>
   	<if test="name!=null and name!=''>name=#{name}</if>
       <if test="msg!=null and msg!=''>msg=#{msg}</if>
   </set>
          where id=#{id};
   </update>
   ~~~

   3. 使用MP内部的updateById（实体类person对象）

   

   ## 删除

   | 资源url：http://localhost:80/users/delete/{id} |
   | ---------------------------------------------- |
   | HTTP协议：delete                               |

   | 参数 | 备注       |
   | ---- | ---------- |
   | id   | 根据id删除 |

   参数获取：@PathVariable

   代码：

   ~~~java
       public R deleteById(@PathVariable Integer id){//按照id来删除，并且传入id，路径资源
           return new R(pd.dropById(id),"删除成功","20000");
       }
   ~~~

   

   这里因为简便，所以是存在不足的。

   1. 如果id不存在，那么返回的response中data和code是按照删除成功的格式返回。只有flag是false。前端只能根据flag判断，

      1. 如果true，本次删除成功
      2. 如果false，删除失败。但是这列并没有为false编写响应的code和data

   2. 并没有设置批量删除的接口，此处简单说一下做法

      1. 如果是mybatis的xml格式的话

         1. 创造个id数组，里面放要删除的id，然后传进占位符。比如：deleteById(@Param("ids") ids);

         2. 数组处理：使用foreach标签：

         3. ~~~java
            <delete>
               delete from person where id in(
                <foreach collection="ids" item="id">
                #{id}
                </foreach>
                )
                </delete>	
            ~~~

      2. 如果是注解方式的话用MybatisPlus的方法

         1. 创建个集合，然后add（要删除的id）
         2. 调用selectBatchIds(集合)

         

# 文件下载

| 资源url：http://localhost:80/users/createFile |
| --------------------------------------------- |
| HTTP协议：Post                                |

| 参数 | 备注                 |
| ---- | -------------------- |
| id   | 根据id下载对应的数据 |

1. 这里使用BufferedWriter指定路径之后开始写文件的格式
   1. 输出格式的名字后面加一串随机double，防止下次的文件重名
2. 时间的话用到ZoneDateTime和DateTimeFormatter

# 管理权限

这里针对的是admin超级管理员用户，他具有所有的权限，自然也有对员工的增删改查功能。这里值写了部分接口，目的只是为了学习

## 创建员工

| 资源url：http://localhost:80/users/createUser |
| --------------------------------------------- |
| HTTP协议：Post                                |

| 参数       | 备注     |
| ---------- | -------- |
| worker对象 | JSON数据 |

1. 接受参数RequestBody
2. 调用语句：MP的insert方法

~~~java
public R createWorker(@RequestBody worker worker){
        return new R(wd.insert(worker)>0,"加入成功","200");
}
~~~



## 查询所有员工

| 资源url：http://localhost:80/users/worker |
| ----------------------------------------- |
| HTTP协议：get                             |

| 参数 | 备注 |
| ---- | ---- |
| 无   |      |

方法返回值：许多Worker对象——List<Worker>

1. 调用MP的selectList方法,这里当然可以使用其他的方法。

~~~java
public R getAllWorker(){
        return new R(true,wd.selectList(null));
}
~~~

## 删除员工

| 资源url：http://localhost:80/users/deleteWorker |
| ----------------------------------------------- |
| HTTP协议：delete                                |

| 参数 | 备注       |
| ---- | ---------- |
| id   | 根据id删除 |

获取参数：@PathVariable

返回值：flag，data，msg

方法调用：MP提供的内部方法deleteById



