package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.book;
import com.itheima.domain.people;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookDao{
    @Select("select * from people where account=#{account}")
    public people getByAccount(String account);

    @Select("select * from people where token =#{token}")
    public people getByToken(String token);
//    @Select("select * from people limit #{cur},#{size}")
//    public List<people> getPage(int cur, int size);xx
    @Insert("insert into people(account,password) values(#{account},#{password}) ")
    public Boolean insert_people(String account,String password);

    @Select("select * from people")
    public List<people> checkAll();
    @Select("select * from people where account=#{account}")
    public people checkByAccount(String account);
    @Delete("delete from people where account=#{account}")
    public Boolean deleteByAccount(String account);

    @Update("update people set password=#{password} where account=#{account}")
    public Boolean updatePsw(String account,String password);

    @Select("select * from people limit #{cur},#{size}")
    public List<people> getPage(int cur,int size);

}
