package com.itheima.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.person;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PersonDao extends BaseMapper<person> {

    @Select("select * from person where name=#{name}")
    public person checkByName(String name);

    @Delete("delete from person where name=#{name}")
    public Boolean dropByName(String name);

    @Update("update person set name=#{name},msg=#{msg} where id=#{id}")
    public Boolean modifyById(Integer id,String name,String msg);
    @Delete("delete from person where id=#{id}")
    public Boolean dropById(Integer id);
}
